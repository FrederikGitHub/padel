package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.ReservationDao;
import com.realdolmen.padel.entity.CourtEntity;
import com.realdolmen.padel.entity.MemberEntity;
import com.realdolmen.padel.entity.ReservationEntity;
import com.realdolmen.padel.model.CourtTimeSlot;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;


@Repository
public class HibernateReservationDao implements ReservationDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(ReservationEntity reservationEntity) {
        entityManager.persist(reservationEntity);
    }

    @Override
    public void delete(ReservationEntity reservationEntity) {
        entityManager.remove(reservationEntity);
    }

    @Override
    public List<ReservationEntity> getReservationList() {
        List<ReservationEntity> reservationList = entityManager.createQuery("Select reservation From ReservationEntity reservation", ReservationEntity.class).getResultList();
        return reservationList;
    }

    public ReservationEntity findReservationById(Long id) {

        ReservationEntity reservationEntity = null;
        try {
            reservationEntity = (ReservationEntity) entityManager.createQuery(
                    "select reservation from ReservationEntity reservation where reservation.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {

        }

        return reservationEntity;
    }


    public ReservationEntity findReservation(CourtTimeSlot courtTimeSlot, LocalDate localDate) {
        List<ReservationEntity> reservationEntityList = entityManager.createQuery("Select reservation From ReservationEntity reservation where reservation.courtTimeSlotEntity.id = :id and reservation.day = :reservationDay and reservation.month = :reservationMonth and reservation.year = :reservationYear", ReservationEntity.class).setParameter("id", courtTimeSlot.getId()).setParameter("reservationDay", localDate.getDayOfMonth()).setParameter("reservationMonth", localDate.getMonthValue()).setParameter("reservationYear", localDate.getYear()).getResultList();
        if (reservationEntityList != null && reservationEntityList.size()>0){
            return reservationEntityList.get(0);
        }
        return null;
    }

}
