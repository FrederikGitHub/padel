package com.realdolmen.padel.service;

import com.realdolmen.padel.data.DataStore;
import com.realdolmen.padel.exception.*;
import com.realdolmen.padel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ReservationServiceImpl implements ReservationService {


    @Autowired
    DataStore dataStore;


    @Override
    public Set<WeekPlanning> restGenerateWeekPlanning(LocalDate fromDate, LocalDate toDate, List<CourtTimeSlotWeek> courtTimeSlotWeekList, List<Member> members, Group group,boolean mixLevels) {
        Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek = courtTimeSlotWeekList.stream().collect(Collectors.toMap(CourtTimeSlotWeek::getWeek, CourtTimeSlotWeek::getCourtTimeSlotList));
        return generateWeekPlanning(fromDate,toDate,courtTimeSlotListByWeek,members,group,mixLevels);
    }

    @Override
    public Set<WeekPlanning> generateWeekPlanning(LocalDate fromDate, LocalDate toDate, Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek, List<Member> members, Group group,boolean mixLevels) {
        if (fromDate.isAfter(toDate)) {
            Map<String, String> paramMap = Stream.of(new String[][]{
                    {"startdate", fromDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))},
                    {"enddate", toDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))},
            }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

            throw new PadelRuntimeException(PadelMessageCode.NO_CORRECT_PLANNING_PERIOD, paramMap);
        }

        Set<WeekPlanning> weekPlanningList = new TreeSet<WeekPlanning>();

        if (members.size() < 4) {
            throw new PadelRuntimeException(PadelMessageCode.NOT_ENOUGH_MEMBERS_TO_MAKE_PLANNING);
        }

        List<Member> highAvailabilityGroupMemberList = members.stream().filter(new Predicate<Member>() {
            @Override
            public boolean test(Member member) {
                List<Integer> availableWeekNumbers = new ArrayList<Integer>();
                Optional<GroupAvailability> groupAvailability = member.getGroupAvailabilityList().stream().filter(GroupAvailability.Predicates.withGroup(group)).findFirst();

                if (groupAvailability.isPresent()) {
                    availableWeekNumbers = groupAvailability.get().getAvailability().getWeekNumbers();
                }

                return (availableWeekNumbers == null || availableWeekNumbers.size() >= 4);
            }
        }).sorted().collect(Collectors.toList());


        Map<Week, List<WeekTimeSlot>> timeSlotsByWeek = getTimeSlotsByWeek(members, group, fromDate, toDate, courtTimeSlotListByWeek);


        Integer reserveIndex = 0;
        for (Map.Entry<Week, List<WeekTimeSlot>> entry : timeSlotsByWeek.entrySet()) {

            List<Member> availableWeekMembers = calculateWeeklyMembers(members, entry.getKey(), group);
            Integer weeklyAmountReserves = availableWeekMembers.size() % 4;
            WeekPlanning weekPlanning = new WeekPlanning();
            weekPlanning.setWeek(entry.getKey());

            List<Member> membersPlannedInOtherGroups = findWeekMembersPlannedInOtherGroup(members, entry.getKey().getWeekOfMonth(), group);

            Map<List<Member>, Integer> reserveList = getWeeklyReserveList(reserveIndex, highAvailabilityGroupMemberList, membersPlannedInOtherGroups, weeklyAmountReserves);
            reserveIndex = reserveList.entrySet().stream().findFirst().get().getValue();
            weekPlanning.setReserveList(reserveList.entrySet().stream().findFirst().get().getKey());
            availableWeekMembers.removeAll(reserveList.entrySet().stream().findFirst().get().getKey());
            List<Reservation> weekReservationList = new ArrayList<Reservation>();

            List<WeekTimeSlot> weekTimeSlots = entry.getValue();
            Map<Integer, List<TimeSlotGroupMembers>> timeSlotGroupMembersByTimeSlotNr=null;
            if (mixLevels){
                timeSlotGroupMembersByTimeSlotNr = findTimeSlotTotalGroupMembers(availableWeekMembers, weekTimeSlots.size(), group);
            }

            Integer weekTimeSlotIndex = 0;
            for (WeekTimeSlot weekTimeSlot : weekTimeSlots) {
                Reservation reservation = new Reservation();
                reservation.setReservationType(ReservationType.AUTO);
                reservation.setWeek(entry.getKey().getWeekOfYear());
                reservation.setDay(weekTimeSlot.getDay().getDayOfMonth());
                reservation.setMonth(weekTimeSlot.getDay().getMonthValue());
                reservation.setYear(weekTimeSlot.getDay().getYear());
                reservation.setCourtTimeSlot(weekTimeSlot.getCourtTimeslot());
                reservation.setReserveMembers(reserveList.entrySet().stream().findFirst().get().getKey());
                reservation.setGroup(group);
                List<Member> reservationMembers;
                if (mixLevels && timeSlotGroupMembersByTimeSlotNr != null){
                    List<TimeSlotGroupMembers> weekTimeSlotGroupMembers = timeSlotGroupMembersByTimeSlotNr.get(weekTimeSlotIndex);
                    reservationMembers = getRandomWeekMembers(availableWeekMembers, weekTimeSlotGroupMembers);
                }else{
                    reservationMembers = getRandomWeekMembers(availableWeekMembers);
                }


                reservation.setReservationMembers(reservationMembers);
                weekReservationList.add(reservation);
                weekTimeSlotIndex++;
            }

            weekPlanning.setReservationList(weekReservationList);

            weekPlanningList.add(weekPlanning);

        }


        return weekPlanningList;
    }

    private Map<Integer, List<TimeSlotGroupMembers>> findTimeSlotTotalGroupMembers(List<Member> availableMembers, int weekTimeSlots, Group group) {
        //List<Member> availableGroupMembers = List<Member> availableGroupMembers = availableWeekMembers.stream().filter(Member.Predicates.withGroup(timeSlotGroupMember.getGroup().getName())).collect(Collectors.toList()).stream().filter(Member.Predicates.withGroup(timeSlotGroupMember.getGroup().getName())).collect(Collectors.toList())
        Map<Integer, List<TimeSlotGroupMembers>> groupMembersByTimeSlot = new HashMap<Integer, List<TimeSlotGroupMembers>>();
        List<Group> availableGroups = availableMembers.stream().flatMap(Member.Functions.TO_GROUP_AVAILABILITY).map(GroupAvailability.Functions.TO_GROUP).distinct().collect(Collectors.toList());
        for (Group availableGroup : availableGroups) {
            List<Member> groupMembers = availableMembers.stream().filter(Member.Predicates.withGroupLevel(availableGroup.getVtvLevels())).collect(Collectors.toList());
            if (groupMembers.size()==0){
                break;
            }
            int minimumMembersInGroup = groupMembers.size() / weekTimeSlots;
            int maximumMembersInGroup = minimumMembersInGroup + 1;
            if (groupMembers.size() % weekTimeSlots == 0) {
                maximumMembersInGroup = minimumMembersInGroup;
            }


            int totalMinimumMembersInGroup = 1;
            int totalMaximumMembersInGroup = weekTimeSlots - totalMinimumMembersInGroup;
            if (groupMembers.size() < weekTimeSlots) {
                totalMinimumMembersInGroup = groupMembers.size();
            } else {
                while (groupMembers.size() != (totalMinimumMembersInGroup * minimumMembersInGroup) + (totalMaximumMembersInGroup * maximumMembersInGroup)) {
                    totalMinimumMembersInGroup++;
                    totalMaximumMembersInGroup = weekTimeSlots - totalMinimumMembersInGroup;
                }
            }


            int j = 0;
            for (j = 0; j < totalMinimumMembersInGroup; j++) {
                List<TimeSlotGroupMembers> weekTimeSlotGroupMembers = groupMembersByTimeSlot.get(j);
                if (!CollectionUtils.isEmpty(weekTimeSlotGroupMembers)) {
                    weekTimeSlotGroupMembers.add(new TimeSlotGroupMembers(availableGroup, minimumMembersInGroup));
                } else {
                    weekTimeSlotGroupMembers = new ArrayList<TimeSlotGroupMembers>();
                    weekTimeSlotGroupMembers.add(new TimeSlotGroupMembers(availableGroup, minimumMembersInGroup));
                }
                groupMembersByTimeSlot.put(j, weekTimeSlotGroupMembers);
            }

            for (int k = 0; k < totalMaximumMembersInGroup; k++) {

                List<TimeSlotGroupMembers> weekTimeSlotGroupMembers = groupMembersByTimeSlot.get(k);
                if (!CollectionUtils.isEmpty(weekTimeSlotGroupMembers)) {
                    weekTimeSlotGroupMembers.add(new TimeSlotGroupMembers(availableGroup, maximumMembersInGroup));
                } else {
                    weekTimeSlotGroupMembers = new ArrayList<TimeSlotGroupMembers>();
                    weekTimeSlotGroupMembers.add(new TimeSlotGroupMembers(availableGroup, minimumMembersInGroup));
                }
                groupMembersByTimeSlot.put(k + j, weekTimeSlotGroupMembers);
            }

        }
        //Map<Integer, List<TimeSlotGroupMembers>> timeSlotTotalGroupMembers;
        Map<Integer, List<TimeSlotGroupMembers>> newGroupMembersByTimeSlot = new HashMap<Integer, List<TimeSlotGroupMembers>>();

        List<TimeSlotGroupMembers> timeSlotGroupMembersToRemove = new ArrayList<TimeSlotGroupMembers>();
        for (Map.Entry<Integer, List<TimeSlotGroupMembers>> entry : groupMembersByTimeSlot.entrySet()) {

            List<TimeSlotGroupMembers> timeSlotGroupMembers = entry.getValue();
            if (timeSlotGroupMembersToRemove.size() > 0) {
                timeSlotGroupMembers.removeAll(timeSlotGroupMembersToRemove);
            }


            List<TimeSlotGroupMembers> mainTimeSlotGroupMembers = lookupTimeSlotGroupMembersForGroup(timeSlotGroupMembers, group);
            TimeSlotGroupMembers mainTimeSlotGroupMember = mainTimeSlotGroupMembers.get(0);

            //for (TimeSlotGroupMembers mainTimeSlotGroupMember:mainTimeSlotGroupMembers) {
            List<TimeSlotGroupMembers> otherTimeSlotGroupMembers = lookupTimeSlotGroupMembersForOtherGroup(timeSlotGroupMembers, group);
            if (otherTimeSlotGroupMembers.size()>0){
                for (TimeSlotGroupMembers otherTimeSlotGroupMember : otherTimeSlotGroupMembers) {
                    if (mainTimeSlotGroupMember.getTotalMembers() + otherTimeSlotGroupMember.getTotalMembers() == 4) {
                        timeSlotGroupMembersToRemove = Arrays.asList(mainTimeSlotGroupMember, otherTimeSlotGroupMember);
                        newGroupMembersByTimeSlot.put(entry.getKey(), Arrays.asList(mainTimeSlotGroupMember, otherTimeSlotGroupMember));
                        break;
                    }

                }
            }else{
                timeSlotGroupMembersToRemove = Arrays.asList(mainTimeSlotGroupMember);
                newGroupMembersByTimeSlot.put(entry.getKey(), Arrays.asList(mainTimeSlotGroupMember));
            }

        }


        return newGroupMembersByTimeSlot;
    }

    private List<TimeSlotGroupMembers> lookupTimeSlotGroupMembersForGroup(List<TimeSlotGroupMembers> timeSlotGroupMembers, Group group) {
        List<TimeSlotGroupMembers> timeSlotGroupMemberList = new ArrayList<TimeSlotGroupMembers>();
        for (TimeSlotGroupMembers timeSlotGroupMember : timeSlotGroupMembers) {
            if (timeSlotGroupMember.getGroup().getName().equalsIgnoreCase(group.getName())) {
                timeSlotGroupMemberList.add(timeSlotGroupMember);
            }
        }
        return timeSlotGroupMemberList;
    }

    private List<TimeSlotGroupMembers> lookupTimeSlotGroupMembersForOtherGroup(List<TimeSlotGroupMembers> timeSlotGroupMembers, Group group) {

        List<TimeSlotGroupMembers> timeSlotGroupMemberList = new ArrayList<TimeSlotGroupMembers>();
        for (TimeSlotGroupMembers timeSlotGroupMember : timeSlotGroupMembers) {
            if (!timeSlotGroupMember.getGroup().getName().equalsIgnoreCase(group.getName())) {
                timeSlotGroupMemberList.add(timeSlotGroupMember);
            }
        }
        return timeSlotGroupMemberList;

    }

    private List<Member> findWeekMembersPlannedInOtherGroup(List<Member> memberList, Integer weekOfMonth, Group group) {
        List<Member> weekMembersPlannedInOtherGroup = new ArrayList<Member>();
        for (Member member : memberList) {
            if (!CollectionUtils.isEmpty(member.getGroupAvailabilityList())) {
                for (GroupAvailability groupAvailability : member.getGroupAvailabilityList()) {
                    if (!groupAvailability.getGroup().equals(group)) {
                        if (groupAvailability.getAvailability().getWeekNumbers().contains(weekOfMonth)) {
                            weekMembersPlannedInOtherGroup.add(member);
                        }
                    }
                }
            }
        }
        return weekMembersPlannedInOtherGroup;

    }

    private List<Member> calculateWeeklyMembers(List<Member> groupMemberList, Week week, Group group) {
        List<Member> weeklyMembers = new ArrayList<Member>();
        for (Member groupMember : groupMemberList) {
            if (groupMember.getGroupAvailabilityList() != null) {
                List<Integer> availableWeekNumbers = new ArrayList<Integer>();

                Optional<GroupAvailability> groupAvailability = groupMember.getGroupAvailabilityList().stream().filter(GroupAvailability.Predicates.withGroup(group)).findFirst();

                if (groupAvailability.isPresent()) {
                    availableWeekNumbers = groupAvailability.get().getAvailability().getWeekNumbers();
                }


                if (availableWeekNumbers.contains(week.getWeekOfMonth())) {
                    weeklyMembers.add(groupMember);
                }
            } else {
                weeklyMembers.add(groupMember);
            }

        }
        return weeklyMembers;
    }

    private List<Member> getRandomWeekMembers(List<Member> availableWeekMembers, List<TimeSlotGroupMembers> timeSlotGroupMembers) {
        List<Member> randomMembers = new ArrayList<Member>();

        for (TimeSlotGroupMembers timeSlotGroupMember : timeSlotGroupMembers) {
            List<Member> availableGroupMembers = availableWeekMembers.stream().filter(Member.Predicates.withGroupLevel(timeSlotGroupMember.getGroup().getVtvLevels())).collect(Collectors.toList());
            for (int i = 0; i < timeSlotGroupMember.getTotalMembers(); i++) {
                Random random = new Random();
                int randomNumber = random.nextInt(timeSlotGroupMember.getTotalMembers() > availableGroupMembers.size() ? availableGroupMembers.size() : timeSlotGroupMember.getTotalMembers());
                Member randomMember = availableGroupMembers.get(randomNumber);
                randomMembers.add(randomMember);
                availableGroupMembers.remove(randomMember);
                availableWeekMembers.remove(randomMember);
            }
        }

        return randomMembers;

    }


    private List<Member> getRandomWeekMembers(List<Member> availableWeekMembers){
        List<Member> randomMembers = new ArrayList<Member>();
        for (int i=0;i<4;i++){
            Random random = new Random();
            Member randomMember = availableWeekMembers.get(random.nextInt(availableWeekMembers.size()));
            randomMembers.add(randomMember);
            availableWeekMembers.remove(randomMember);
        }
        return randomMembers;

    }

    private Map<List<Member>, Integer> getWeeklyReserveList(Integer reserveIndex, List<Member> highAvailabilityGroupMemberList, List<Member> membersPlannedInOtherGroups, int weeklyAmountReserves) {
        List<Member> reserveList = new ArrayList<Member>();
        do {
            Member highAvailabilityGroupMember = highAvailabilityGroupMemberList.get(reserveIndex % highAvailabilityGroupMemberList.size());
            if (!membersPlannedInOtherGroups.contains(highAvailabilityGroupMember)) {
                reserveList.add(highAvailabilityGroupMember);
            }
            reserveIndex++;
        } while (reserveList.size() < weeklyAmountReserves);
        Map<List<Member>, Integer> map = new HashMap<List<Member>, Integer>();
        map.put(reserveList, reserveIndex);
        return map;
    }


    private Map<Week, List<WeekTimeSlot>> getTimeSlotsByWeek(List<Member> groupMemberList, Group group, LocalDate fromDate, LocalDate toDate, Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek) {
        List<WeekTimeSlot> fullPeriodTimeSlotList = new ArrayList<WeekTimeSlot>();
        LocalDate firstPossibleReservationDate = fromDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        LocalDate lastPossibleReservationDate = toDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));

        LocalDate runningReservationDate = firstPossibleReservationDate;
        do {
            List<WeekTimeSlot> timeSlotsOfDay = getDayTimeSlots(runningReservationDate, courtTimeSlotListByWeek);
            if (!CollectionUtils.isEmpty(timeSlotsOfDay)) {
                fullPeriodTimeSlotList.addAll(timeSlotsOfDay);
            }
            runningReservationDate = runningReservationDate.plusDays(1);
        } while (runningReservationDate.isBefore(lastPossibleReservationDate) || runningReservationDate.isEqual(lastPossibleReservationDate));

        Map<Week, List<WeekTimeSlot>> timeSlotsByWeek =
                fullPeriodTimeSlotList.stream().collect(Collectors.groupingBy(WeekTimeSlot::getWeek));

        for (Map.Entry<Week, List<WeekTimeSlot>> entry : timeSlotsByWeek.entrySet()) {

            List<Member> availableWeekMembers = calculateWeeklyMembers(groupMemberList, entry.getKey(), group);
            int neededTimeSlots = availableWeekMembers.size() / 4;
            if (entry.getValue().size() < neededTimeSlots) {
                Map<String, String> paramMap = Stream.of(new String[][]{
                        {"period", entry.getKey().getStartWeekDay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - " + entry.getKey().getEndWeekDay().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))},
                        {"members", new Integer(availableWeekMembers.size()).toString()},
                        {"timeslots", new Integer(neededTimeSlots).toString()},
                }).collect(Collectors.toMap(data -> data[0], data -> data[1]));

                throw new PadelRuntimeException(PadelMessageCode.NOT_ENOUGH_TIMESLOTS, paramMap);
            }
            entry.setValue(entry.getValue().subList(0, (availableWeekMembers.size() / 4)));
        }

        TreeMap<Week, List<WeekTimeSlot>> sortedTimeSlotsByWeek = new TreeMap<>(timeSlotsByWeek);

        return sortedTimeSlotsByWeek;
    }


    private List<CourtTimeSlot> findTimeSlotsForWeek(LocalDate day, Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek) {
        LocalDate monday = day.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        LocalDate sunday = day.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        WeekFields weekFields
                = WeekFields.of(DayOfWeek.MONDAY, 1);
        TemporalField weekOfYear
                = weekFields.weekOfYear();
        int yearWeekNr = sunday.get(weekOfYear);
        List<CourtTimeSlot> courtTimeSlotList = null;
        for (Map.Entry<Week, List<CourtTimeSlot>> entry : courtTimeSlotListByWeek.entrySet()) {
            if (entry.getKey().getWeekOfYear().equals(yearWeekNr)) {
                courtTimeSlotList = entry.getValue();
            }
        }
        return courtTimeSlotList;
    }

    private List<WeekTimeSlot> getDayTimeSlots(LocalDate day, Map<Week, List<CourtTimeSlot>> courtTimeSlotListByWeek) {
        List<WeekTimeSlot> weekTimeSlotList = new ArrayList<WeekTimeSlot>();
        List<CourtTimeSlot> courtTimeSlotList = findTimeSlotsForWeek(day, courtTimeSlotListByWeek);
        for (CourtTimeSlot courtTimeSlot : courtTimeSlotList) {
            if (day.getDayOfWeek().getValue() == courtTimeSlot.getTimeSlot().getDayOfWeek().getValue()) {
                LocalDate monday = day.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
                LocalDate sunday = day.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
                WeekFields weekFields
                        = WeekFields.of(DayOfWeek.MONDAY, 1);

                // apply weekOfMonth()
                TemporalField weekOfMonth
                        = weekFields.weekOfMonth();

                TemporalField weekOfYear
                        = weekFields.weekOfYear();


                Week week = new Week(sunday.get(weekOfYear), sunday.get(weekOfMonth), monday, sunday, monday.getYear());


                WeekTimeSlot weekTimeSlot = new WeekTimeSlot();
                weekTimeSlot.setWeek(week);
                weekTimeSlot.setDay(day);
                weekTimeSlot.setCourtTimeslot(courtTimeSlot);
                weekTimeSlotList.add(weekTimeSlot);
            }
        }
        return weekTimeSlotList;
    }


    @Override
    public Set<WeekPlanning> getGroupWeekPlanning(LocalDate fromDate, LocalDate toDate, Group group) {
        Predicate<Reservation> predicateStartDate = Reservation.Predicates.isAfterDate(fromDate).or(Reservation.Predicates.withDate(fromDate));
        Predicate<Reservation> predicateEndDate = Reservation.Predicates.isBeforeDate(toDate).or(Reservation.Predicates.withDate(toDate));
        Map<Week, List<Reservation>> reservationsByWeek = dataStore.getReservations().stream().filter(Reservation.Predicates.withGroup(group).and(predicateStartDate.and(predicateEndDate))).collect(Collectors.groupingBy(Reservation.Functions.TO_WEEK));
        Set<WeekPlanning> weekPlanningList = new TreeSet<WeekPlanning>();
        for (Map.Entry<Week, List<Reservation>> entry : reservationsByWeek.entrySet()) {
            WeekPlanning weekPlanning = new WeekPlanning();
            weekPlanning.setWeek(entry.getKey());
            weekPlanning.setReservationList(entry.getValue());
            List<Member> reserveList = entry.getValue().stream().flatMap(Reservation.Functions.TO_RESERVE_MEMBERS).distinct().collect(Collectors.toList());
            weekPlanning.setReserveList(reserveList);
            weekPlanningList.add(weekPlanning);
        }
        return weekPlanningList;
    }

    @Override
    public Map<Member, Long> getTotalReservationsByMember(LocalDate fromDate, LocalDate toDate) {
        Predicate<Reservation> predicateStartDate = Reservation.Predicates.isAfterDate(fromDate).or(Reservation.Predicates.withDate(fromDate));
        Predicate<Reservation> predicateEndDate = Reservation.Predicates.isBeforeDate(toDate).or(Reservation.Predicates.withDate(toDate));
        return dataStore.getReservations().stream().filter(predicateStartDate.and(predicateEndDate)).flatMap(Reservation.Functions.TO_MEMBERS).collect(Collectors.groupingBy(o -> o, Collectors.counting()));

    }

    @Override
    public Map<Member, Long> getTotalByeByMember(LocalDate fromDate, LocalDate toDate) {
        Predicate<Reservation> predicateStartDate = Reservation.Predicates.isAfterDate(fromDate).or(Reservation.Predicates.withDate(fromDate));
        Predicate<Reservation> predicateEndDate = Reservation.Predicates.isBeforeDate(toDate).or(Reservation.Predicates.withDate(toDate));
        return dataStore.getReservations().stream().filter(predicateStartDate.and(predicateEndDate)).flatMap(Reservation.Functions.TO_RESERVE_MEMBERS).collect(Collectors.groupingBy(o -> o, Collectors.counting()));
    }

    @Override
    public List<Reservation> getDayReservations(LocalDate day) {
        //return dataStore.getReservations().stream().filter(Reservation.Predicates.withDate(day)).collect(Collectors.groupingBy(Reservation.Functions.TO_COURT));
        return dataStore.getReservations().stream().filter(Reservation.Predicates.withDate(day)).collect(Collectors.toList());
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteAllReservations() {
        dataStore.deleteAllReservations();
    }

    @Override
    public void create(Reservation reservation) {
        dataStore.create(reservation);
    }

    @Override
    public void update(Reservation padelReservation) {
        dataStore.update(padelReservation);
    }


    @Override
    public boolean validateWeekPlanning(Set<WeekPlanning> weekPlannings, boolean validateTimeSlotOverBooking, boolean validateMemberOverBooking) {
        List<Reservation> reservationsToBeCreated = new ArrayList<Reservation>();
        List<Reservation> reservationsToBeUpdated = new ArrayList<Reservation>();
        doValidateWeekPlanning(weekPlannings, reservationsToBeCreated, reservationsToBeUpdated, validateTimeSlotOverBooking, validateMemberOverBooking);
        return true;
    }

    private void doValidateWeekPlanning(Set<WeekPlanning> weekPlannings, List<Reservation> reservationsToBeCreated, List<Reservation> reservationsToBeUpdated, boolean validateTimeSlotOverBooking, boolean validateMemberOverBooking) {

        List<Message> tooManyMemberReservationMessages = new ArrayList<Message>();
        List<Message> tooManyTimeSlotsReservationMessages = new ArrayList<Message>();

        for (WeekPlanning weekPlanning : weekPlannings) {
            for (Reservation reservation : weekPlanning.getReservationList()) {
                Reservation alreadyBookedReservation = findReservationForPeriodAndCourtTimeSlot(LocalDate.of(reservation.getYear(), reservation.getMonth(), reservation.getDay()), reservation.getCourtTimeSlot());
                if (alreadyBookedReservation != null) {
                    String members = alreadyBookedReservation.getReservationMembers().stream().map(Member.Functions.TO_FULL_NAME).collect(Collectors.joining());
                    String court = alreadyBookedReservation.getCourtTimeSlot().getCourt().getName();
                    String startPeriod = alreadyBookedReservation.getCourtTimeSlot().getTimeSlot().getFrom();
                    String endPeriod = alreadyBookedReservation.getCourtTimeSlot().getTimeSlot().getTo();
                    String reservationDate = LocalDate.of(alreadyBookedReservation.getYear(), alreadyBookedReservation.getMonth(), alreadyBookedReservation.getDay()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    Map<String, String> paramMap = Stream.of(new String[][]{
                            {"court", court},
                            {"startPeriod", startPeriod},
                            {"endPeriod", endPeriod},
                            {"reservationDate", reservationDate},
                            {"members", members},
                    }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
                    Message message = new Message(PadelMessageCode.TIMESLOT_OVERBOOKING, paramMap);
                    tooManyTimeSlotsReservationMessages.add(message);

                    reservationsToBeUpdated.add(reservation);

                } else {
                    reservationsToBeCreated.add(reservation);
                }
                reservationsToBeCreated.add(reservation);
                if (validateMemberOverBooking){
                    for (Member reservationMember : reservation.getReservationMembers()) {
                        List<Reservation> weekMemberReservations = findReservationsForPeriodAndMember(weekPlanning.getWeek().getStartWeekDay(), weekPlanning.getWeek().getEndWeekDay(), reservationMember);
                        if (!CollectionUtils.isEmpty(weekMemberReservations)) {

                            String playDates = weekMemberReservations.stream().map(Reservation.Functions.TO_PLAY_DATE).map(new Function<LocalDate, String>() {
                                @Override
                                public String apply(LocalDate localDate) {
                                    return localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                                }
                            }).collect(Collectors.joining());
                            Map<String, String> paramMap = Stream.of(new String[][]{
                                    {"member", reservationMember.getName() + " " + reservationMember.getFirstName()},
                                    {"playdates", playDates},
                            }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
                            Message message = new Message(PadelMessageCode.MEMBER_OVERBOOKING, paramMap);
                            tooManyMemberReservationMessages.add(message);
                        }
                    }
                }

            }
        }
        if (validateTimeSlotOverBooking && reservationsToBeUpdated.size() > 0) {
            IChainedMessage chainedMessage = new ChainedMessage(PadelMessageCode.COURT_OVERBOOKED, null, null);
            chainedMessage.getCauseMessages().addAll(tooManyTimeSlotsReservationMessages);
            throw new PadelRuntimeException(chainedMessage);
        }
        if (validateMemberOverBooking && tooManyMemberReservationMessages.size() > 0) {
            IChainedMessage chainedMessage = new ChainedMessage(PadelMessageCode.TOO_MANY_RESERVATIONS, null, null);
            chainedMessage.getCauseMessages().addAll(tooManyMemberReservationMessages);
            throw new PadelRuntimeException(chainedMessage);
        }
    }

    @Override
    public void storeWeekPlanning(Set<WeekPlanning> weekPlannings, boolean validateTimeSlotOverBooking, boolean validateMemberOverBooking) {
        List<Reservation> reservationsToBeCreated = new ArrayList<Reservation>();
        List<Reservation> reservationsToBeUpdated = new ArrayList<Reservation>();

        doValidateWeekPlanning(weekPlannings, reservationsToBeCreated, reservationsToBeUpdated, validateTimeSlotOverBooking, validateMemberOverBooking);

        reservationsToBeCreated.stream().forEach(new Consumer<Reservation>() {
            @Override
            public void accept(Reservation reservation) {
                create(reservation);
            }
        });
        reservationsToBeUpdated.stream().forEach(new Consumer<Reservation>() {
            @Override
            public void accept(Reservation reservation) {
                update(reservation);
            }
        });
    }

    @Override
    public Reservation findReservationForPeriodAndCourtTimeSlot(LocalDate localdate, CourtTimeSlot courtTimeSlot) {
        Reservation reservation = dataStore.findReservation(courtTimeSlot,localdate);
        return reservation;
    }

    @Override
    public List<Reservation> findReservationsForPeriodAndMember(LocalDate startDate, LocalDate endDate, Member member) {
        Predicate<Reservation> predicateStartDate = Reservation.Predicates.isAfterDate(startDate).or(Reservation.Predicates.withDate(startDate));
        Predicate<Reservation> predicateEndDate = Reservation.Predicates.isBeforeDate(endDate).or(Reservation.Predicates.withDate(endDate));
        return dataStore.getReservations().stream().filter(Reservation.Predicates.hasMember(member).and(predicateStartDate).and(predicateEndDate)).collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findAllReservations() {
        return dataStore.getReservations();
    }
}
