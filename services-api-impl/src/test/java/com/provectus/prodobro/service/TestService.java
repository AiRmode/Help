package com.provectus.prodobro.service;


import com.provectus.prodobro.service.actor.CompanyService;
import com.provectus.prodobro.service.actor.EventService;
import com.provectus.prodobro.service.actor.ShelterService;
import com.provectus.prodobro.service.actor.UserService;
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
public class TestService {

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ShelterService shelterService;
    @Autowired
    private EventService eventService;

    @Before
    public void setUpTestData() {
    }


    @Test
    @Transactional
    @Rollback
    public void testAllServices() {
    }
}
