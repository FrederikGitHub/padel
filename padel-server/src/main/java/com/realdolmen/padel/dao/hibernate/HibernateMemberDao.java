package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.MemberDao;
import com.realdolmen.padel.entity.GroupEntity;
import com.realdolmen.padel.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class HibernateMemberDao implements MemberDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(MemberEntity memberEntity) {
        entityManager.persist(memberEntity);
    }

    @Override
    public void delete(MemberEntity memberEntity) {
        entityManager.remove(memberEntity);
    }

    @Override
    public List<MemberEntity> getMemberList() {
        List<MemberEntity> memberList = entityManager.createQuery("Select members From MemberEntity members", MemberEntity.class).getResultList();
        return memberList;
    }

    public MemberEntity findMemberById(Long id) {

        MemberEntity memberEntity = null;
        try {
            memberEntity = entityManager.getReference(MemberEntity.class,id);
            /*memberEntity = (MemberEntity) entityManager.createQuery(
                    "select member from MemberEntity member where member.id = :id")
                    .setParameter("id", id)
                    .getSingleResult();*/
        } catch (Exception e) {
            System.out.println("" + e);
        }

        return memberEntity;
    }




}
