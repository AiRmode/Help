package com.provectus.prodobro.service;


import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.dao.actor.UserDAO;
import com.provectus.prodobro.service.actor.UserService;
import com.provectus.prodobro.shared.status.StatusEnum;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Override
    public void save(User object) {
        userDAO.save(object);
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public void update(User object) {
        userDAO.update(object);
    }

    /**
     * Removing user is deprecated
     * Use makeRemovedById()
     *
     * @param object User
     */
    @Deprecated
    @Override
    public void remove(User object) {
        userDAO.remove(object);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Override
    public void makeRemovedById(Long id) {
        User company = userDAO.getById(id);
        company.getStatus().setStatus("DELETED");
        userDAO.update(company);
    }

    @Override
    public List<User> getByName(String name) {
        return userDAO.getByName(name);
    }

    @Override
    public List<User> getByStatus(StatusEnum status) {
        return userDAO.getByStatus(status);
    }

    @Override
    public List<User> getByStatus(String status) {
        return userDAO.getByStatus(status);
    }

    @Override
    public User getByPhoneNumber(String phoneNumber) {
        return userDAO.getByPhoneNumber(phoneNumber);
    }

    @Override
    public User getByEmail(String email) {
        return userDAO.getByEmail(email);
    }

    @Required
    @Resource(name = "userDAO")
    public void setUserDAO (UserDAO userDAO) {
        this.userDAO = userDAO;
    }
}
