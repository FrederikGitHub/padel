package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.AvailabilityDao;
import com.realdolmen.padel.entity.AvailabilityEntity;
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


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Ignore
public class HibernateAvailabilityDaoITTest {

    @Autowired
    private AvailabilityDao availabilityDao;


    @Test
    @Transactional
    @Rollback(true)
    public void testCrudAvailabilityTable() {
        AvailabilityEntity availabilityEntity = new AvailabilityEntity();
        availabilityEntity.setWeekNumbers("1,2,3,4,5");
        availabilityEntity.setLabel("100%");
        availabilityDao.save(availabilityEntity);
        List<AvailabilityEntity> availabilityEntityList = availabilityDao.getAvailabilityList();
        AvailabilityEntity lastAddedAvailabilityEntity = availabilityEntityList.get(availabilityEntityList.size()-1);
        availabilityDao.delete(availabilityEntityList.get(availabilityEntityList.size()-1));
        Assert.assertNotNull(availabilityEntityList);
    }




}
