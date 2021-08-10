package com.realdolmen.padel.data;

import com.realdolmen.padel.dao.*;
import com.realdolmen.padel.entity.*;
import com.realdolmen.padel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
@Transactional
@Primary
public class MysqlDatabaseStore implements DataStore {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private CourtDao courtDao;

    @Autowired
    private TimeSlotDao timeSlotDao;

    @Autowired
    private AvailabilityDao availabilityDao;

    @Autowired
    private VtvLevelDao vtvLevelDao;

    @Autowired
    private ReservationTypeDao reservationTypeDao;

    @Autowired
    private CourtTimeSlotDao courtTimeSlotDao;

    @Autowired
    private WeeklyReserveDao weeklyReserveDao;


    @Override
    public List<Group> getGroups() {
        List<GroupEntity> groupEntityList = groupDao.getGroupList();
        List<Group> groupList = groupEntityList.stream().map(Group.Functions.FROM_GROUP_ENTITY).collect(Collectors.toList());
        return groupList;
    }

    @Override
    public List<Reservation> getReservations() {
        List<ReservationEntity> reservationEntityList = reservationDao.getReservationList();
        List<Reservation> reservationList = reservationEntityList.stream().map(Reservation.Functions.FROM_RESERVATION_ENTITY).collect(Collectors.toList());
        return reservationList;
    }

    @Override
    public Reservation findReservation(CourtTimeSlot courtTimeSlot, LocalDate localDate) {
        ReservationEntity reservationEntity = reservationDao.findReservation(courtTimeSlot, localDate);
        Reservation reservation = null;
        if (reservationEntity != null){
            reservation = Reservation.Functions.FROM_RESERVATION_ENTITY.apply(reservationEntity);
        }
        return reservation;
    }

    @Override
    public List<Member> getPadelMembers() {
        List<MemberEntity> memberEntityList = memberDao.getMemberList();
        List<Member> memberList = memberEntityList.stream().map(Member.Functions.FROM_MEMBER_ENTITY).collect(Collectors.toList());
        return memberList;
    }

    @Override
    public List<Court> getCourtList() {
        List<CourtEntity> courtEntityList = courtDao.getCourtList();
        List<Court> courtList = courtEntityList.stream().map(Court.Functions.FROM_COURT_ENTITY).collect(Collectors.toList());
        return courtList;
    }

    @Override
    public List<VtvLevel> getVtvLevels() {
        List<VtvLevelEntity> vtvLevelEntityList = vtvLevelDao.getVtvLevelList();
        List<VtvLevel> vtvLevelList = vtvLevelEntityList.stream().map(VtvLevel.Functions.FROM_VTV_LEVEL_ENTITY).collect(Collectors.toList());
        return vtvLevelList;

    }

    @Override
    public List<Availability> getAvailabilities() {
        List<AvailabilityEntity> availabilityEntityList = availabilityDao.getAvailabilityList();
        List<Availability> availabilityList = availabilityEntityList.stream().map(Availability.Functions.FROM_AVAILABILITY_ENTITY).collect(Collectors.toList());
        return availabilityList;
    }

    @Override
    public List<TimeSlot> getTimeSlots() {
        List<TimeSlotEntity> timeSlotEntityList = timeSlotDao.getTimeSlotList();
        List<TimeSlot> timeSlotList = timeSlotEntityList.stream().map(TimeSlot.Functions.FROM_TIMESLOT_ENTITY).collect(Collectors.toList());
        return timeSlotList;
    }

    @Override
    public void create(Member member) {
        MemberEntity memberEntity = new MemberEntity();
        /*memberEntity.getGroupAvailabilityList().forEach(new Consumer<GroupAvailability>() {
            @Override
            public void accept(GroupAvailability groupAvailability) {
                memberGroupAvailabilityEntityList.add(memberDao.findMemberById(member.getId()));
            }
        });*/

        setMemberProperties(member,memberEntity);
        memberDao.save(memberEntity);
    }

    @Override
    public void delete(Member member) {
        MemberEntity memberEntity = memberDao.findMemberById(member.getId());
        memberDao.delete(memberEntity);
    }

    private void setMemberProperties(Member member, MemberEntity memberEntity){
        memberEntity.setFirstName(member.getFirstName());
        memberEntity.setName(member.getName());
        memberEntity.setGsm(member.getGsm());
        memberEntity.setEmail(member.getEmail());
        memberEntity.setGender(member.getGender());
        memberEntity.setActive(member.getActive());
        if (!CollectionUtils.isEmpty(member.getGroupAvailabilityList())){
            Set<MemberGroupAvailabilityEntity> memberGroupAvailabilityEntityList = member.getGroupAvailabilityList().stream().map(GroupAvailability.Functions.TO_MEMBER_GROUP_AVAILABILITY_ENTITY).collect(Collectors.toSet());
            memberEntity.setGroupAvailabilityList(memberGroupAvailabilityEntityList);
        }
        if (member.getVtvLevel() != null){
            VtvLevelEntity vtvLevelEntity = vtvLevelDao.findLevelById(member.getVtvLevel().getId());
            memberEntity.setVtvLevel(vtvLevelEntity);
        }
    }


    @Override
    public void update(Member member) {
        MemberEntity memberEntity = memberDao.findMemberById(member.getId());

        Set<MemberGroupAvailabilityEntity> memberGroupAvailabilityEntityList = new HashSet<MemberGroupAvailabilityEntity>();

        memberEntity.setGroupAvailabilityList(memberGroupAvailabilityEntityList);

        setMemberProperties(member,memberEntity);
        memberDao.save(memberEntity);
    }

    @Override
    public void create(Group group) {
        GroupEntity groupEntity = new GroupEntity();
        groupEntity.setName(group.getName());
        groupEntity.setActive(group.getActive());
        groupDao.save(groupEntity);
    }

    @Override
    public void delete(Group group) {
        GroupEntity groupEntity = groupDao.findGroupById(group.getId());
        groupDao.delete(groupEntity);
    }

    @Override
    public void update(Group group) {
        GroupEntity groupEntity = groupDao.findGroupById(group.getId());
        groupEntity.setName(group.getName());
        groupEntity.setActive(group.getActive());
        groupDao.save(groupEntity);
    }

    @Override
    public void create(Court court) {
        CourtEntity courtEntity = new CourtEntity();
        courtEntity.setName(court.getName());
        courtEntity.setActive(court.getActive());
        courtDao.save(courtEntity);
    }

    @Override
    public void delete(Court court) {
        CourtEntity courtEntity = courtDao.findCourtById(court.getId());
        courtDao.delete(courtEntity);
    }

    @Override
    public void update(Court court) {
        CourtEntity courtEntity = courtDao.findCourtById(court.getId());
        courtEntity.setName(court.getName());
        courtEntity.setActive(court.getActive());
        courtDao.save(courtEntity);
    }

    @Override
    public void create(Reservation reservation) {
        ReservationEntity reservationEntity = new ReservationEntity();

        if (reservation.getGroup() != null) {
            GroupEntity groupEntity = groupDao.findGroupById(reservation.getGroup().getId());
            reservationEntity.setGroupEntity(groupEntity);
        }

        reservationEntity.setYear(reservation.getYear());
        reservationEntity.setMonth(reservation.getMonth());
        reservationEntity.setDay(reservation.getDay());

        if (reservation.getReservationType() != null) {
            ReservationTypeEntity reservationTypeEntity = reservationTypeDao.findReservationTypeById(reservation.getReservationType().getId());
            reservationEntity.setReservationType(reservationTypeEntity);
        }

        if (reservation.getGroup() != null) {
            GroupEntity groupEntity = groupDao.findGroupById(reservation.getGroup().getId());
            reservationEntity.setGroupEntity(groupEntity);
        }


        Set<MemberEntity> reservationMembers = new HashSet<MemberEntity>();
        reservation.getReservationMembers().forEach(new Consumer<Member>() {
            @Override
            public void accept(Member member) {
                reservationMembers.add(memberDao.findMemberById(member.getId()));
            }
        });
        reservationEntity.setReservationMembers(reservationMembers);


        if (reservation.getCourtTimeSlot() != null) {
            CourtTimeSlotEntity courtTimeSlotEntity = courtTimeSlotDao.findCourtTimeSlotById(reservation.getCourtTimeSlot().getId());
            reservationEntity.setCourtTimeSlot(courtTimeSlotEntity);
        }


        reservationDao.save(reservationEntity);
    }

    @Override
    public void delete(Reservation reservation) {
        ReservationEntity reservationEntity = reservationDao.findReservationById(reservation.getId());
        reservationDao.delete(reservationEntity);
    }

    @Override
    public void update(Reservation reservation) {
        ReservationEntity reservationEntity = reservationDao.findReservationById(reservation.getId());
        reservationDao.save(reservationEntity);
    }

    @Override
    public void deleteAllReservations() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(TimeSlot timeSlot) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(TimeSlot timeSlot) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(TimeSlot timeSlot) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(WeeklyReserve weeklyReserve) {
        WeeklyReserveEntity weeklyReserveEntity = new WeeklyReserveEntity();
        if (weeklyReserve.getGroup() != null) {
            GroupEntity groupEntity = groupDao.findGroupById(weeklyReserve.getGroup().getId());
            weeklyReserveEntity.setGroup(groupEntity);
        }

        if (weeklyReserve.getReservation() != null) {
            LocalDate reservationDate = LocalDate.of(weeklyReserve.getReservation().getYear(),weeklyReserve.getReservation().getMonth(),weeklyReserve.getReservation().getDay());
            ReservationEntity reservationEntity = reservationDao.findReservation(weeklyReserve.getReservation().getCourtTimeSlot(),reservationDate);
            weeklyReserveEntity.setReservation(reservationEntity);
        }

        weeklyReserveEntity.setYear(weeklyReserve.getYear());
        weeklyReserveEntity.setWeekNr(weeklyReserve.getWeekNr());


        if (weeklyReserve.getMember() != null) {
            MemberEntity memberEntity = memberDao.findMemberById(weeklyReserve.getMember().getId());
            weeklyReserveEntity.setMember(memberEntity);
        }


        weeklyReserveDao.save(weeklyReserveEntity);

    }

    @Override
    public List<CourtTimeSlot> getCourtTimeSlots() {
        List<CourtTimeSlotEntity> courtTimeSlotEntityList = courtTimeSlotDao.getCourtTimeSlotList();
        List<CourtTimeSlot> courtTimeSlotList = courtTimeSlotEntityList.stream().map(CourtTimeSlot.Functions.FROM_COURT_TIMESLOT_ENTITY).collect(Collectors.toList());
        return courtTimeSlotList;
    }
}
