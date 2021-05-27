package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.ReservationTypeDao;
import com.realdolmen.padel.entity.GroupEntity;
import com.realdolmen.padel.entity.ReservationTypeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class HibernateReservationTypeDao implements ReservationTypeDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(ReservationTypeEntity reservationEntity) {
        entityManager.persist(reservationEntity);
    }

    @Override
    public void delete(ReservationTypeEntity reservationEntity) {
        entityManager.remove(reservationEntity);
    }

    @Override
    public List<ReservationTypeEntity> getReservationTypeList() {
        List<ReservationTypeEntity> reservationTypeEntityList = entityManager.createQuery("Select reservationType From ReservationTypeEntity reservationType", ReservationTypeEntity.class).getResultList();
        return reservationTypeEntityList;
    }

    @Override
    public ReservationTypeEntity findReservationTypeById(Long id) {

        ReservationTypeEntity reservationTypeEntity = null;
        try {
            reservationTypeEntity = (ReservationTypeEntity) entityManager.createQuery(
                    "select reservationType from ReservationTypeEntity reservationType where reservationType.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {

        }

        return reservationTypeEntity;
    }


}
