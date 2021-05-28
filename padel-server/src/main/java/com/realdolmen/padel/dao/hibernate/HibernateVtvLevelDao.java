package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.VtvLevelDao;
import com.realdolmen.padel.entity.MemberEntity;
import com.realdolmen.padel.entity.VtvLevelEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class HibernateVtvLevelDao implements VtvLevelDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(VtvLevelEntity vtvLevelEntity) {
        entityManager.persist(vtvLevelEntity);
    }

    @Override
    public void delete(VtvLevelEntity vtvLevelEntity) {
        entityManager.remove(vtvLevelEntity);
    }

    @Override
    public List<VtvLevelEntity> getVtvLevelList() {
        List<VtvLevelEntity> vtvLevelList = entityManager.createQuery("Select vtvLevels From VtvLevelEntity vtvLevels ", VtvLevelEntity.class).getResultList();
        return vtvLevelList;
    }

    @Override
    public VtvLevelEntity findLevelById(Long id) {
        VtvLevelEntity vtvLevelEntity = entityManager.getReference(VtvLevelEntity.class,id);
        return vtvLevelEntity;
    }
}
