package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.event.EventImpl;
import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.shelter.ShelterImpl;
import com.provectus.prodobro.actor.shelter.ShelterTypeImpl;
import com.provectus.prodobro.dao.actor.EventDAO;
import com.provectus.prodobro.dao.actor.ShelterDAO;
import com.provectus.prodobro.shared.StatusEnumNew;
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

import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = "classpath:applicationContext-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EventDAOTest {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private ShelterDAO shelterDAO;

    private Event event;
    private Shelter shelter;

    @Before
    public void setUpData() {

        //event can't exist without shelter, so we need to initialize shelter too
        shelter = new ShelterImpl();
        shelter.setTitle("Shelter");

        ShelterTypeImpl shelterType = new ShelterTypeImpl();
        shelterType.setType("HUMAN");
        shelter.setType(shelterType);
        shelter.setStatus(StatusEnumNew.ACTIVE);

        Timestamp timestamp = new Timestamp(new Date().getTime());
        shelter.setCreatedDate(timestamp);
        shelter.setLastModifiedDate(timestamp);

        event = new EventImpl();
        event.setTitle("Event");
        event.setShelter(shelter);
        event.setDate(timestamp);
        event.setCreatedDate(timestamp);
        event.setLastModifiedDate(timestamp);
        event.setAccessible(true);
    }

    @Test
    @Transactional
    @Rollback
    public void eventDAOTest() {
        shelterDAO.save(shelter);
        eventDAO.save(event);
        getByIdTest();
        getAllTest();
        getByTitleTest();
        getByDateTest();
        getAccessibleTest();
        getPrivateTest();
    }

    private void getByIdTest() {
        Event eventFromDB = eventDAO.getById(event.getId());
        assertTrue(eventFromDB.equals(event));
    }

    private void getAllTest() {
        List<Event> events = eventDAO.getAll();
        assertTrue(events.contains(event));
    }

    private void getByTitleTest() {
        Event eventFromDB = eventDAO.getByTitle(event.getTitle());
        assertTrue(eventFromDB.equals(event));
    }

    private void getByDateTest() {
        List<Event> events = eventDAO.getByDate(event.getDate());
        assertTrue(events.contains(event));
    }

    private void getAccessibleTest() {
        List<Event> events = eventDAO.getAccessible();
        assertTrue(events.contains(event));
    }

    private void getPrivateTest() {
        event.setAccessible(false);
        eventDAO.save(event);

        List<Event> events = eventDAO.getPrivate();
        assertTrue(events.contains(event));
    }
}
