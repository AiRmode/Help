package com.provectus.prodobro.dao;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDAOImpl {

    @PersistenceContext
    private EntityManager manager;

}
