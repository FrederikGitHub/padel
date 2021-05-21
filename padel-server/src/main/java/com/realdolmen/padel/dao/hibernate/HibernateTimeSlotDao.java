package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.TimeSlotDao;
import com.realdolmen.padel.entity.TimeSlotEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class HibernateTimeSlotDao implements TimeSlotDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(TimeSlotEntity timeSlotEntity) {
        entityManager.persist(timeSlotEntity);
    }

    @Override
    public void delete(TimeSlotEntity timeSlotEntity) {
        entityManager.remove(timeSlotEntity);
    }

    @Override
    public List<TimeSlotEntity> getTimeSlotList() {
        List<TimeSlotEntity> timeSlotList = entityManager.createQuery("Select timeSlot From TimeSlotEntity timeSlot", TimeSlotEntity.class).getResultList();
        return timeSlotList;
    }


}
