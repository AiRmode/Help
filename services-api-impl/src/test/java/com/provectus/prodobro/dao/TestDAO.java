package com.provectus.prodobro.dao;


import com.provectus.prodobro.dao.actor.CompanyDAO;
import com.provectus.prodobro.dao.actor.EventDAO;
import com.provectus.prodobro.dao.actor.ShelterDAO;
import com.provectus.prodobro.dao.actor.UserDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@ContextConfiguration(locations = "classpath:applicationContext-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestDAO {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CompanyDAO companyDAO;
    @Autowired
    private ShelterDAO shelterDAO;
    @Autowired
    private EventDAO eventDAO;
    @Autowired
    private TagDAO tagDAO;

    @Before
    public void setUpTestData() {
    }


    @Test
    @Transactional
    @Rollback
    public void testAllDAOs() {
    }

}
