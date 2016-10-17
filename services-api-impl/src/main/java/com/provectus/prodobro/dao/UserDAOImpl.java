package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import com.provectus.prodobro.dao.actor.UserDAO;
import com.provectus.prodobro.shared.StatusEnum;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("userDAO")
@SuppressWarnings("unchecked")
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Override
    public void save(User object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Transactional(readOnly = true)
    @Override
    public User getById(Long id) {
        return sessionFactory.getCurrentSession().get(UserImpl.class, id);
    }

    @Override
    public void update(User object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void remove(User object) {
        sessionFactory.getCurrentSession().remove(object);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from UserImpl")
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getByName(String name) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from UserImpl o where o.name=:name")
                .setParameter("name", name)
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getByStatus(StatusEnum status) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select u from UserImpl u where u.statusCode=:statusCode")
                .setParameter("statusCode", status.getCode())
                .list();
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

    @Transactional(readOnly = true)
    @Override
    public User getByLoginAndPassword(String login, String password) {
        return (User) sessionFactory
                .getCurrentSession()
                .createQuery("from UserImpl where pass_hash=:pass and (email=:login or phone_num=:login)")
                .setParameter("pass", password)
                .setParameter("login", login)
                .uniqueResult();
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
