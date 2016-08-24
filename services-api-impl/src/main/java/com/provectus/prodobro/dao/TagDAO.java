package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.shelter.Tag;
import com.provectus.prodobro.actor.shelter.TagImpl;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository("tagDAO")
@SuppressWarnings("unchecked")
public class TagDAO implements GenericDAO<Tag, Long> {

    private SessionFactory sessionFactory;

    @Override
    public void save(Tag object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Transactional(readOnly = true)
    @Override
    public Tag getById(Long id) {
        return sessionFactory.getCurrentSession().get(TagImpl.class, id);
    }

    @Override
    public void update(Tag object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void remove(Tag object) {
        sessionFactory.getCurrentSession().remove(object);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Tag> getAll() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from TagImpl")
                .list();
    }
}
