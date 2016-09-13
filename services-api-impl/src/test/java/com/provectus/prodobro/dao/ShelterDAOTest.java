package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.shelter.ShelterImpl;
import com.provectus.prodobro.actor.shelter.ShelterStatus;
import com.provectus.prodobro.actor.shelter.ShelterTypeImpl;
import com.provectus.prodobro.dao.actor.ShelterDAO;
import com.provectus.prodobro.shared.status.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ShelterDAOTest {

    @Autowired
    private ShelterDAO shelterDAO;

    private Shelter shelter;

    @Before
    public void setUpData() {
        shelter = new ShelterImpl();
        shelter.setTitle("Shelter");

        ShelterTypeImpl shelterType = new ShelterTypeImpl();
        shelterType.setType("HUMAN");
        shelter.setType(shelterType);

        Status status = new ShelterStatus();
        status.setStatus("ACTIVE");
        shelter.setStatus(status);

        Timestamp timestamp = new Timestamp(new Date().getTime());
        shelter.setCreatedDate(timestamp);
        shelter.setLastModifiedDate(timestamp);
    }

    @Test
    @Transactional
    @Rollback
    public void shelterDAOTest() {
        shelterDAO.save(shelter);
        getByIdTest();
        getAllTest();
        getByTitleTest();
        getByStatusTest();
        getByTypeTest();
    }

    private void getByTypeTest() {
        List<Shelter> shelters = shelterDAO.getByType(shelter.getType().getType());

        Assert.assertEquals(1, shelters.size());
        Assert.assertEquals(shelter.getId(), shelters.get(0).getId());
        Assert.assertEquals(shelter.getTitle(), shelters.get(0).getTitle());
        Assert.assertEquals(shelter.getCreatedDate(), shelters.get(0).getCreatedDate());
    }

    private void getByStatusTest() {
        List<Shelter> shelters = shelterDAO.getByStatus(shelter.getStatus().getStatus());

        Assert.assertEquals(1, shelters.size());
        Assert.assertEquals(shelter.getId(), shelters.get(0).getId());
        Assert.assertEquals(shelter.getTitle(), shelters.get(0).getTitle());
        Assert.assertEquals(shelter.getType(), shelters.get(0).getType());
        Assert.assertEquals(shelter.getCreatedDate(), shelters.get(0).getCreatedDate());
    }

    private void getByTitleTest() {
        Shelter shelterFromDB = shelterDAO.getByTitle(shelter.getTitle());

        Assert.assertEquals(shelter.getId(), shelterFromDB.getId());
        Assert.assertEquals(shelter.getType(), shelterFromDB.getType());
        Assert.assertEquals(shelter.getCreatedDate(), shelterFromDB.getCreatedDate());
    }

    private void getAllTest() {
        List<Shelter> shelters = shelterDAO.getAll();

        Assert.assertEquals(1, shelters.size());
        Assert.assertEquals(shelter.getId(), shelters.get(0).getId());
        Assert.assertEquals(shelter.getTitle(), shelters.get(0).getTitle());
        Assert.assertEquals(shelter.getType(), shelters.get(0).getType());
        Assert.assertEquals(shelter.getCreatedDate(), shelters.get(0).getCreatedDate());
    }

    private void getByIdTest() {
        Shelter shelterFromDB = shelterDAO.getById(shelter.getId());

        Assert.assertEquals(shelter.getTitle(), shelterFromDB.getTitle());
        Assert.assertEquals(shelter.getType(), shelterFromDB.getType());
        Assert.assertEquals(shelter.getCreatedDate(), shelterFromDB.getCreatedDate());
    }
}
