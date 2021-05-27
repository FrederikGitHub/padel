package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.CourtTimeSlotDao;
import com.realdolmen.padel.dao.TimeSlotDao;
import com.realdolmen.padel.entity.CourtEntity;
import com.realdolmen.padel.entity.CourtTimeSlotEntity;
import com.realdolmen.padel.entity.GroupEntity;
import com.realdolmen.padel.entity.TimeSlotEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class HibernateCourtTimeSlotDao implements CourtTimeSlotDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(CourtTimeSlotEntity courtTimeSlotEntity) {

    }

    @Override
    public void delete(CourtTimeSlotEntity courtTimeSlotEntity) {

    }

    @Override
    public List<CourtTimeSlotEntity> getCourtTimeSlotList() {
        List<CourtTimeSlotEntity> courtTimeSlotEntityList = entityManager.createQuery("Select courtTimeSlotEntity From CourtTimeSlotEntity courtTimeSlotEntity", CourtTimeSlotEntity.class).getResultList();
        return courtTimeSlotEntityList;
    }

    @Override
    public CourtTimeSlotEntity findCourtTimeSlotById(Long id) {
        CourtTimeSlotEntity courtTimeSlotEntity = null;
        try {
            courtTimeSlotEntity = (CourtTimeSlotEntity) entityManager.createQuery(
                    "select courtTimeSlotEntity from CourtTimeSlotEntity courtTimeSlotEntity where courtTimeSlotEntity.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {

        }

        return courtTimeSlotEntity;
    }




}
