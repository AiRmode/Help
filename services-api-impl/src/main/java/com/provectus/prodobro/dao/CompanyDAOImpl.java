package com.provectus.prodobro.dao;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.company.CompanyImpl;
import com.provectus.prodobro.dao.actor.CompanyDAO;
import com.provectus.prodobro.shared.StatusEnumNew;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("companyDAO")
@SuppressWarnings("unchecked")
public class CompanyDAOImpl implements CompanyDAO {

    private SessionFactory sessionFactory;

    @Override
    public void save(Company object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Transactional(readOnly = true)
    @Override
    public Company getById(Long id) {
        return sessionFactory.getCurrentSession().get(CompanyImpl.class, id);
    }

    @Override
    public void update(Company object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void remove(Company object) {
        sessionFactory.getCurrentSession().remove(object);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Company> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from CompanyImpl")
                .list();
    }

    @Transactional(readOnly = true)
    @Override
    public Company getByTitle(String title) {
        return (Company) sessionFactory
                .getCurrentSession()
                .createQuery("from CompanyImpl o where o.title=:title")
                .setParameter("title", title)
                .uniqueResult();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Company> getByStatus(StatusEnumNew status) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("select c from CompanyImpl c where c.statusCode=:status")
                .setParameter("status", status.getCode())
                .list();
    }

    @Required
    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
