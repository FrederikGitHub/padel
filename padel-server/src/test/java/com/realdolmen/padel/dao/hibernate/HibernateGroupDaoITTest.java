package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.CourtDao;
import com.realdolmen.padel.dao.GroupDao;
import com.realdolmen.padel.entity.CourtEntity;
import com.realdolmen.padel.entity.GroupEntity;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;

@Ignore
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HibernateGroupDaoITTest {

    @Autowired
    private GroupDao groupDao;


    @Test
    @Transactional
    @Rollback(true)
    public void testCrudGroupTable() {
        GroupEntity groupEntity = new GroupEntity();

        groupEntity.setName("ghfhhgf");
        groupDao.save(groupEntity);
        /*List<GroupEntity> groupEntityList = groupDao.getGroupList();
        GroupEntity lastAdded = groupEntityList.get(groupEntityList.size()-1);
        groupDao.delete(groupEntityList.get(groupEntityList.size()-1));
        Assert.assertNotNull(groupEntityList);*/
    }





}
