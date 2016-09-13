package com.provectus.prodobro.dao;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.event.EventImpl;
import com.provectus.prodobro.dao.actor.EventDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Transactional
@Repository("eventDAO")
@SuppressWarnings("unchecked")
public class EventDAOImpl implements EventDAO {

    private SessionFactory sessionFactory;

    @Override
    public void save(Event object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Transactional(readOnly = true)
    @Override
    public Event getById(Long id) {
        return sessionFactory.getCurrentSession().get(EventImpl.class, id);
    }

    @Override
    public void update(Event object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void remove(Event object) {
        sessionFactory.getCurrentSession().remove(object);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Event> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from EventImpl")
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public Event getByTitle(String title) {
        return (Event) sessionFactory
                .getCurrentSession()
                .createQuery("from EventImpl o where o.title=:title")
                .setParameter("title", title)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Event> getByDate(Timestamp date) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from EventImpl o where o.date=:date")
                .setParameter("date", date)
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Event> getAccessible() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from EventImpl o where o.accessible=true")
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Event> getPrivate() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from EventImpl o where o.accessible=false")
                .list();
    }

    @Required
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
