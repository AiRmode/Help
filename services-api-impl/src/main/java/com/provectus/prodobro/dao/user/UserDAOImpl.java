package com.provectus.prodobro.dao.user;


import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import com.provectus.prodobro.dao.actor.UserDAO;
import com.provectus.prodobro.shared.status.Status;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Override
    public void save(User object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public User getById(Long id) {
        return sessionFactory.getCurrentSession().get(UserImpl.class, id);
    }

    @Override
    public void update(User object) {
        sessionFactory.getCurrentSession().update(object);
    }

    /**
     * Removing User from database is deprecated.
     * For removing User change status to DELETED
     * @param object User
     */
    @Deprecated
    @Override
    public void remove(User object) {
        sessionFactory.getCurrentSession().remove(object);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from UserImpl ")
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getByName(String name) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getByStatus(Status status) {
        return null;
    }

    @Transactional(readOnly = true)
    @Override
    public User getByPhoneNumber(String phoneNumber) {
        return (User) sessionFactory
                .getCurrentSession()
                .createQuery("from UserImpl where phone_num=:phone")
                .setParameter("phone", phoneNumber)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    @Override
    public User getByEmail(String email) {
        return (User) sessionFactory
                .getCurrentSession()
                .createQuery("from UserImpl where email=:email")
                .setParameter("email", email)
                .uniqueResult();
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
