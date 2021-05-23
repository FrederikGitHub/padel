package com.realdolmen.padel.dao.hibernate;

import com.realdolmen.padel.dao.CourtDao;
import com.realdolmen.padel.entity.CourtEntity;
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
public class HibernateCourtDaoITTest {

    @Autowired
    private CourtDao courtDao;


    @Test
    @Transactional
    @Rollback(true)
    public void testCrudCourtTable() {
        CourtEntity courtEntity = new CourtEntity();
        courtEntity.setName("Court 3");
        courtDao.save(courtEntity);
        List<CourtEntity> courtEntityList = courtDao.getCourtList();
        CourtEntity lastAdded = courtEntityList.get(courtEntityList.size()-1);
        courtDao.delete(courtEntityList.get(courtEntityList.size()-1));
        Assert.assertNotNull(courtEntityList);
    }




}
