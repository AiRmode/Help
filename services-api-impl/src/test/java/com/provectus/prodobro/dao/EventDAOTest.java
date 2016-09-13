package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.event.EventImpl;
import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.shelter.ShelterImpl;
import com.provectus.prodobro.actor.shelter.ShelterStatus;
import com.provectus.prodobro.actor.shelter.ShelterTypeImpl;
import com.provectus.prodobro.dao.actor.EventDAO;
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

        Status status = new ShelterStatus();
        status.setStatus("ACTIVE");
        shelter.setStatus(status);

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
        getEventByIdTest();
        getAllEventsTest();
        getEventByTitleTest();
        getEventsByDateTest();
        getAccessibleEvents();
        getPrivateEvents();
    }

    private void getEventByIdTest() {
        Event eventFromDB = eventDAO.getById(event.getId());

        Assert.assertEquals(event.getTitle(), eventFromDB.getTitle());
        Assert.assertEquals(event.getDate(), eventFromDB.getDate());
        Assert.assertEquals(event.getShelter(), eventFromDB.getShelter());
    }

    private void getAllEventsTest() {
        List<Event> events = eventDAO.getAll();

        Assert.assertEquals(1, events.size());
        Assert.assertEquals(event.getId(), events.get(0).getId());
        Assert.assertEquals(event.getTitle(), events.get(0).getTitle());
        Assert.assertEquals(event.getDate(), events.get(0).getDate());
        Assert.assertEquals(event.getShelter(), events.get(0).getShelter());
    }

    private void getEventByTitleTest() {
        Event eventFromDB = eventDAO.getByTitle(event.getTitle());

        Assert.assertEquals(event.getId(), eventFromDB.getId());
        Assert.assertEquals(event.getDate(), eventFromDB.getDate());
        Assert.assertEquals(event.getShelter(), eventFromDB.getShelter());
    }

    private void getEventsByDateTest() {
        List<Event> events = eventDAO.getByDate(event.getDate());

        Assert.assertEquals(1, events.size());
        Assert.assertEquals(event.getId(), events.get(0).getId());
        Assert.assertEquals(event.getTitle(), events.get(0).getTitle());
        Assert.assertEquals(event.getDate(), events.get(0).getDate());
        Assert.assertEquals(event.getShelter(), events.get(0).getShelter());
    }

    private void getAccessibleEvents() {
        List<Event> events = eventDAO.getAccessible();

        Assert.assertEquals(1, events.size());
        Assert.assertEquals(event.getId(), events.get(0).getId());
        Assert.assertEquals(event.getTitle(), events.get(0).getTitle());
        Assert.assertEquals(event.getDate(), events.get(0).getDate());
        Assert.assertEquals(event.getShelter(), events.get(0).getShelter());
    }

    private void getPrivateEvents() {
        event.setAccessible(false);
        eventDAO.save(event);

        List<Event> events = eventDAO.getPrivate();

        Assert.assertEquals(1, events.size());
        Assert.assertEquals(event.getId(), events.get(0).getId());
        Assert.assertEquals(event.getTitle(), events.get(0).getTitle());
        Assert.assertEquals(event.getDate(), events.get(0).getDate());
        Assert.assertEquals(event.getShelter(), events.get(0).getShelter());
    }
}
