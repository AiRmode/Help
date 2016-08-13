package com.provectus.prodobro.dao;


import com.provectus.prodobro.actor.user.User;

public interface SuperUserDAO extends GenericDAO<User> {

    void createSuperUser(User user);

    void findSuperUserById(int id);

    void deleteSuperUser(User user);
}
