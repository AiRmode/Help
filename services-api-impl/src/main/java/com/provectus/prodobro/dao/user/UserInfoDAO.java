package com.provectus.prodobro.dao.user;


import com.provectus.prodobro.actor.user.UserInfo;
import com.provectus.prodobro.dao.GenericDAO;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.util.List;

public class UserInfoDAO implements GenericDAO<UserInfo, Long>{

    private SessionFactory sessionFactory;

    @Override
    public void save(UserInfo object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public UserInfo getById(Long id) {
        return sessionFactory.getCurrentSession().get(UserInfo.class, id);
    }

    @Override
    public void update(UserInfo object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void remove(UserInfo object) {
        sessionFactory.getCurrentSession().remove(object);
    }

    @Override
    public List<UserInfo> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from UserInfo ")
                .list();
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
