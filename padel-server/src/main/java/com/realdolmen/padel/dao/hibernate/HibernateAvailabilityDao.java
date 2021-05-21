package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.AvailabilityDao;
import com.realdolmen.padel.entity.AvailabilityEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class HibernateAvailabilityDao implements AvailabilityDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(AvailabilityEntity availabilityEntity) {
        entityManager.persist(availabilityEntity);
    }

    @Override
    public void delete(AvailabilityEntity availabilityEntity) {
        entityManager.remove(availabilityEntity);
    }

    @Override
    public List<AvailabilityEntity> getAvailabilityList() {
        List<AvailabilityEntity> availabilityEntityList = entityManager.createQuery("Select availabilities From AvailabilityEntity availabilities ", AvailabilityEntity.class).getResultList();
        return availabilityEntityList;
    }
}
