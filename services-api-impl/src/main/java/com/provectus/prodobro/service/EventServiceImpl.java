package com.provectus.prodobro.service;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.dao.actor.EventDAO;
import com.provectus.prodobro.service.actor.EventService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service("eventService")
public class EventServiceImpl implements EventService {

    private EventDAO eventDAO;

    @Override
    public void save(Event object) {
        eventDAO.save(object);
    }

    @Override
    public Event getById(Long id) {
        return eventDAO.getById(id);
    }

    @Override
    public void update(Event object) {
        eventDAO.update(object);
    }

    @Override
    public void remove(Event object) {
        eventDAO.remove(object);
    }

    @Override
    public List<Event> getAll() {
        return eventDAO.getAll();
    }

    @Override
    public Event getByTitle(String title) {
        return eventDAO.getByTitle(title);
    }

    @Override
    public List<Event> getByDate(Timestamp date) {
        return eventDAO.getByDate(date);
    }

    @Override
    public List<Event> getAccessible() {
        return eventDAO.getAccessible();
    }

    @Override
    public List<Event> getPrivate() {
        return eventDAO.getPrivate();
    }

    @Required
    @Resource(name = "eventDAO")
    public void setCompanyDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

}
