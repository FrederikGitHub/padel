package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.MemberDao;
import com.realdolmen.padel.entity.MemberEntity;
import com.realdolmen.padel.util.HashingUtility;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Ignore
public class HibernateMemberDaoITTest {

    @Autowired
    private MemberDao memberDao;


    @Test
    @Transactional
    @Rollback(true)
    public void testCrudMemberTable() throws NoSuchAlgorithmException {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName("Van Heddeghem");
        memberEntity.setFirstName("Frederik");
        memberEntity.setEmail("frederik.vanheddeghem@gmail.com");
        memberEntity.setPassword(HashingUtility.getHash("SHA-256"));
        memberEntity.setActive("Y");
        memberDao.save(memberEntity);
        List<MemberEntity> memberEntityList = memberDao.getMemberList();
        MemberEntity lastAdded = memberEntityList.get(memberEntityList.size()-1);
        memberDao.delete(memberEntityList.get(memberEntityList.size()-1));
        Assert.assertNotNull(memberEntityList);
    }





}
