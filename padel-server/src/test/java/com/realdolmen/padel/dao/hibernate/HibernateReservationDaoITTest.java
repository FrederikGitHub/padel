package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.*;
import com.realdolmen.padel.entity.*;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Ignore
public class HibernateReservationDaoITTest {

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private TimeSlotDao timeSlotDao;

    @Autowired
    private ReservationTypeDao reservationTypeDao;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private MemberDao memberDao;

    @Test
    @Transactional
    @Rollback(true)
    public void testCrudReservationTable() throws NoSuchAlgorithmException {
        ReservationEntity reservationEntity = new ReservationEntity();
        LocalDate currentDate = LocalDate.now();
        reservationEntity.setDay(currentDate.getDayOfMonth());
        reservationEntity.setMonth(currentDate.getMonthValue());
        reservationEntity.setYear(currentDate.getYear());
        reservationEntity.setWeek(currentDate.get(WeekFields.of(new Locale("nl")).weekOfYear()));
        ReservationTypeEntity reservationTypeEntity = new ReservationTypeEntity();
        reservationTypeEntity.setName("FIXED");
        reservationTypeDao.save(reservationTypeEntity);
        List<ReservationTypeEntity> reservationTypeEntityList = reservationTypeDao.getReservationTypeList();
        ReservationTypeEntity fixedReservationType = reservationTypeEntityList.get(reservationTypeEntityList.size()-1);
        reservationEntity.setReservationType(fixedReservationType);
        TimeSlotEntity timeSlotEntity = timeSlotDao.getTimeSlotList().get(0);
        reservationEntity.setTimeSlot(timeSlotEntity);
        GroupEntity groupEntity = groupDao.getGroupList().get(0);
        reservationEntity.setGroupEntity(groupEntity);
        List<MemberEntity> memberEntityList = memberDao.getMemberList();
        reservationEntity.setReservationMembers(new HashSet(memberEntityList));
        reservationDao.save(reservationEntity);
        List<ReservationEntity> reservationList = reservationDao.getReservationList();
        reservationDao.delete(reservationList.get(reservationList.size()-1));
    }

}
