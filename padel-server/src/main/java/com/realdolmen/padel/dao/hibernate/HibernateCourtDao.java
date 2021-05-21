package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.CourtDao;
import com.realdolmen.padel.entity.CourtEntity;
import com.realdolmen.padel.entity.GroupEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class HibernateCourtDao implements CourtDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(CourtEntity courtEntity) {
        entityManager.persist(courtEntity);
    }

    @Override
    public void delete(CourtEntity courtEntity) {
        entityManager.remove(courtEntity);
    }

    @Override
    public List<CourtEntity> getCourtList() {
        List<CourtEntity> courtList = entityManager.createQuery("Select court From CourtEntity court", CourtEntity.class).getResultList();
        return courtList;
    }

    public CourtEntity findCourtById(Long id) {

        CourtEntity courtEntity = null;
        try {
            courtEntity = (CourtEntity) entityManager.createQuery(
                    "select court from CourtEntity court where court.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {

        }

        return courtEntity;
    }
}
