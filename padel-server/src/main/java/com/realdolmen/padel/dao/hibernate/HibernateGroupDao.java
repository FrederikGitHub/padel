package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.GroupDao;
import com.realdolmen.padel.entity.CourtEntity;
import com.realdolmen.padel.entity.GroupEntity;
import com.realdolmen.padel.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class HibernateGroupDao implements GroupDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(GroupEntity groupEntity) {
        entityManager.persist(groupEntity);
    }

    @Override
    public void delete(GroupEntity groupEntity) {
        entityManager.remove(groupEntity);
    }

    @Override
    public List<GroupEntity> getGroupList() {
        List<GroupEntity> groupList = entityManager.createQuery("Select groups From GroupEntity groups ", GroupEntity.class).getResultList();
        return groupList;
    }

    public GroupEntity findGroupById(Long id) {

        GroupEntity groupEntity = null;
        try {
            groupEntity = (GroupEntity) entityManager.createQuery(
                    "select group from GroupEntity group where group.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (Exception e) {

        }

        return groupEntity;
    }
}
