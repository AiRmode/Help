package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.shelter.ShelterImpl;
import com.provectus.prodobro.actor.shelter.ShelterTypeEnum;
import com.provectus.prodobro.dao.actor.ShelterDAO;
import com.provectus.prodobro.shared.status.StatusEnum;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("shelterDAO")
@SuppressWarnings("unchecked")
public class ShelterDAOImpl implements ShelterDAO {

    private SessionFactory sessionFactory;

    @Override
    public void save(Shelter object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Transactional(readOnly = true)
    @Override
    public Shelter getById(Long id) {
        return sessionFactory.getCurrentSession().get(ShelterImpl.class, id);
    }

    @Override
    public void update(Shelter object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void remove(Shelter object) {
        sessionFactory.getCurrentSession().remove(object);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Shelter> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from UserInfo")
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public Shelter getByTitle(String title) {
        return (Shelter) sessionFactory
                .getCurrentSession()
                .createQuery("from ShelterImpl o where o.title=:title")
                .setParameter("title", title)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Shelter> getByStatus(String status) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select c from ShelterImpl c inner join c.status where c.status.status=:status")
                .setParameter("status", StatusEnum.valueOf(status))
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Shelter> getByStatus(StatusEnum status) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select c from ShelterImpl c inner join c.status where c.status.status=:status")
                .setParameter("status", status)
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Shelter> getByType(String type) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select c from ShelterImpl c inner join c.status where c.type.type=:stype")
                .setParameter("stype", ShelterTypeEnum.valueOf(type))
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Shelter> getByType(ShelterTypeEnum type) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select c from ShelterImpl c inner join c.status where c.type.type=:stype")
                .setParameter("stype", type)
                .list();
    }

    @Required
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
