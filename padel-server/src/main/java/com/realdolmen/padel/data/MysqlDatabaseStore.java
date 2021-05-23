package com.realdolmen.padel.data;

import com.realdolmen.padel.dao.*;
import com.realdolmen.padel.entity.*;
import com.realdolmen.padel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
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
        MemberEntity memberEntity = Member.Functions.TO_MEMBER_ENTITY.apply(member);
        memberDao.save(memberEntity);
    }

    @Override
    public void delete(Member member) {
        MemberEntity memberEntity = memberDao.findMemberById(member.getId());
        memberDao.delete(memberEntity);
    }



    @Override
    public void update(Member member) {
        MemberEntity memberEntity = memberDao.findMemberById(member.getId());
        memberDao.save(memberEntity);
    }

    @Override
    public void create(Group group) {
        GroupEntity groupEntity = Group.Functions.TO_GROUP_ENTITY.apply(group);
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
        groupDao.save(groupEntity);
    }

    @Override
    public void create(Court court) {
        CourtEntity courtEntity = Court.Functions.TO_COURT_ENTITY.apply(court);
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
        courtDao.delete(courtEntity);
    }

    @Override
    public void create(Reservation reservation) {
        ReservationEntity reservationEntity = new ReservationEntity();

        if (reservation.getGroup() != null){
            GroupEntity groupEntity = groupDao.findGroupById(reservation.getGroup().getId());
            reservationEntity.setGroupEntity(groupEntity);
        }


        reservationDao.save(reservationEntity);
    }

    @Override
    public void delete(Reservation reservation) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Reservation reservation) {
        throw new UnsupportedOperationException();
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
    public List<CourtTimeSlot> getCourtTimeSlots() {
        throw new UnsupportedOperationException();
    }
}
