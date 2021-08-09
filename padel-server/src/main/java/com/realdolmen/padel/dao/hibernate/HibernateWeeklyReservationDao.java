package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.WeeklyReserveDao;
import com.realdolmen.padel.entity.WeeklyReserveEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class HibernateWeeklyReservationDao implements WeeklyReserveDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(WeeklyReserveEntity weeklyReserveEntity) {
        entityManager.persist(weeklyReserveEntity);
    }


}
