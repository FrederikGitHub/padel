package com.realdolmen.padel.service;

import com.realdolmen.padel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    MemberService memberService;

    @Override
    public List<WeekPlanning> generateWeekPlanning(LocalDate fromDate, LocalDate toDate, List<TimeSlot> timeSlotList, Group group) {
        List<WeekPlanning> weekPlanningList = new ArrayList<WeekPlanning>();
        List<Member> members = memberService.getMembersForGroup(group.getId());
        Integer weeklyAmountReserves = members.size() - (timeSlotList.size()*4);
        Map<Integer,List<WeekTimeSlot>> timeSlotsByWeek = getTimeSlotsByWeek(fromDate,toDate,timeSlotList);
        Integer week=0;

        for (Map.Entry<Integer, List<WeekTimeSlot>> entry : timeSlotsByWeek.entrySet()) {

            List<Member> availableWeekMembers = new ArrayList<>(members);
            WeekPlanning weekPlanning = new WeekPlanning();
            List<Member> reserveList = getWeeklyReserveList(week,availableWeekMembers,weeklyAmountReserves);
            weekPlanning.setReserveList(reserveList);
            availableWeekMembers.removeAll(reserveList);
            List<Reservation> weekReservationList = new ArrayList<Reservation>();

            List<WeekTimeSlot> weekTimeSlots = entry.getValue();
            for (WeekTimeSlot weekTimeSlot:weekTimeSlots){
                Reservation reservation = new Reservation();
                reservation.setWeek(entry.getKey());
                reservation.setDay(weekTimeSlot.getDay().getDayOfMonth());
                reservation.setMonth(weekTimeSlot.getDay().getMonthValue());
                reservation.setYear(weekTimeSlot.getDay().getYear());
                reservation.setTimeSlot(weekTimeSlot.getTimeslot());
                List<Member> reservationMembers = getRandomWeekMembers(availableWeekMembers);
                reservation.setReservationMembers(reservationMembers);
                weekReservationList.add(reservation);
            }

            weekPlanning.setReservationList(weekReservationList);
            week++;
            weekPlanningList.add(weekPlanning);
        }




        return weekPlanningList;
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

    private List<Member> getWeeklyReserveList(int weekNr, List<Member> memberList, int weeklyAmountReserves){
        List<Member> reserveList = new ArrayList<Member>();
        int beginIndex = weekNr * weeklyAmountReserves;
        int endIndex = beginIndex + weeklyAmountReserves;
        for (int i=beginIndex;i<endIndex;i++){
            reserveList.add(memberList.get(i % memberList.size()));
        }

        return reserveList;

    }

    private Map<Integer,List<WeekTimeSlot>> getTimeSlotsByWeek(LocalDate fromDate, LocalDate toDate, List<TimeSlot> timeSlots){
        List<WeekTimeSlot> fullPeriodTimeSlotList = new ArrayList<WeekTimeSlot>();
        LocalDate firstPossibleReservationDate = getFirstPossibleReservationDate(fromDate,timeSlots.get(0));
        LocalDate lastPossibleReservationDate = getLastPossibleReservationDate(toDate,timeSlots.get(timeSlots.size()-1));
        LocalDate runningReservationDate = firstPossibleReservationDate;
        do{
            List<WeekTimeSlot> timeSlotsOfDay = getDayTimeSlots(runningReservationDate,timeSlots);
            if (!CollectionUtils.isEmpty(timeSlotsOfDay)){
                fullPeriodTimeSlotList.addAll(timeSlotsOfDay);
            }
            runningReservationDate = runningReservationDate.plusDays(1);
        }while(runningReservationDate.isBefore(lastPossibleReservationDate) || runningReservationDate.isEqual(lastPossibleReservationDate));

        Map<Integer, List<WeekTimeSlot>> timeSlotsByWeek =
                fullPeriodTimeSlotList.stream().collect(Collectors.groupingBy(WeekTimeSlot::getWeekNr));

        return timeSlotsByWeek;
    }

    private LocalDate getFirstPossibleReservationDate(LocalDate fromDate,TimeSlot timeSlot){
        boolean found = false;
        LocalDate runningDate = fromDate;
        do{
            if (runningDate.getDayOfWeek().getValue() == timeSlot.getWeekday().getId()){
                found=true;
            }
            if (!found){
                runningDate = runningDate.plusDays(1);
            }

        }while(!found);
        return runningDate;
    }

    private LocalDate getLastPossibleReservationDate(LocalDate toDate, TimeSlot timeSlot){
        boolean found = false;
        LocalDate runningDate = toDate;
        do{
            if (runningDate.getDayOfWeek().getValue() == timeSlot.getWeekday().getId()){
                found=true;
            }
            if (!found){
                runningDate = runningDate.minusDays(1);
            }

        }while(!found);
        return runningDate;
    }

    private List<WeekTimeSlot> getDayTimeSlots(LocalDate day,List<TimeSlot> timeSlotList){
        List<WeekTimeSlot> weekTimeSlotList = new ArrayList<WeekTimeSlot>();
        for (TimeSlot timeSlot:timeSlotList){
            if (day.getDayOfWeek().getValue()==timeSlot.getWeekday().getId()){
                //todo set weektimeslot
                int weekOfYear = day.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
                WeekTimeSlot weekTimeSlot = new WeekTimeSlot();
                weekTimeSlot.setWeekNr(weekOfYear);
                weekTimeSlot.setDay(day);
                weekTimeSlot.setTimeslot(timeSlot);
                weekTimeSlotList.add(weekTimeSlot);
            }
        }
        return weekTimeSlotList;
    }



    @Override
    public List<Reservation> getMemberReservations(Member member, Date fromDate, Date toDate, List<ReservationType> reservationTypeList) {
        return null;
    }

    @Override
    public Map<Court, List<Reservation>> getDayReservations(Date day) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void create(Reservation reservation) {

    }

    @Override
    public void update(Reservation reservation) {

    }
}
