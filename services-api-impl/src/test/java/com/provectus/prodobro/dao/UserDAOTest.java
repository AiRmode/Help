package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import com.provectus.prodobro.actor.user.UserStatus;
import com.provectus.prodobro.dao.actor.UserDAO;
import com.provectus.prodobro.shared.status.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@ContextConfiguration(locations = "classpath:applicationContext-services.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    private User user;

    @Before
    public void setUpData() {
        user = new UserImpl();
        user.setName("User");
        user.setEmail("Email");
        user.setPhoneNumber("Phone");
        user.setPassHash("Pass");

        Status userStatus = new UserStatus();
        userStatus.setStatus("ACTIVE");
        user.setStatus(userStatus);

        Timestamp timestamp = new Timestamp(new Date().getTime());
        user.setCreatedDate(timestamp);
        user.setLastModifiedDate(timestamp);
    }

    @Test
    @Transactional
    @Rollback
    public void userDAOTest() {
        userDAO.save(user);
        getByIdTest();
        getAllTest();
        getByNameTest();
        getByStatusTest();
        getByPhoneNumberTest();
        getByEmailTest();
        getByLoginAndPasswordTest();
    }

    private void getByIdTest() {
        User userFromDB = userDAO.getById(user.getId());

        Assert.assertEquals(user.getName(), userFromDB.getName());
        Assert.assertEquals(user.getEmail(), userFromDB.getEmail());
        Assert.assertEquals(user.getPhoneNumber(), userFromDB.getPhoneNumber());
    }

    private void getAllTest() {
        List<User> users = userDAO.getAll();

        Assert.assertEquals(1, users.size());
        Assert.assertEquals(user.getId(), users.get(0).getId());
        Assert.assertEquals(user.getName(), users.get(0).getName());
        Assert.assertEquals(user.getEmail(), users.get(0).getEmail());
        Assert.assertEquals(user.getPhoneNumber(), users.get(0).getPhoneNumber());
    }

    private void getByNameTest() {
        List<User> users = userDAO.getByName(user.getName());

        Assert.assertEquals(1, users.size());
        Assert.assertEquals(user.getId(), users.get(0).getId());
        Assert.assertEquals(user.getEmail(), users.get(0).getEmail());
        Assert.assertEquals(user.getPhoneNumber(), users.get(0).getPhoneNumber());
    }

    private void getByStatusTest() {
        List<User> users = userDAO.getByStatus(user.getStatus().getStatus());

        Assert.assertEquals(1, users.size());
        Assert.assertEquals(user.getId(), users.get(0).getId());
        Assert.assertEquals(user.getName(), users.get(0).getName());
        Assert.assertEquals(user.getEmail(), users.get(0).getEmail());
        Assert.assertEquals(user.getPhoneNumber(), users.get(0).getPhoneNumber());
    }

    private void getByPhoneNumberTest() {
        User userFromDB = userDAO.getByPhoneNumber(user.getPhoneNumber());

        Assert.assertEquals(user.getId(), userFromDB.getId());
        Assert.assertEquals(user.getName(), userFromDB.getName());
        Assert.assertEquals(user.getEmail(), userFromDB.getEmail());
    }

    private void getByEmailTest() {
        User userFromDB = userDAO.getByEmail(user.getEmail());

        Assert.assertEquals(user.getId(), userFromDB.getId());
        Assert.assertEquals(user.getName(), userFromDB.getName());
        Assert.assertEquals(user.getPhoneNumber(), userFromDB.getPhoneNumber());
    }

    private void getByLoginAndPasswordTest() {
        User userByEmail = userDAO.getByLoginAndPassword(user.getEmail(), user.getPassHash());
        User userByPhoneNum = userDAO.getByLoginAndPassword(user.getPhoneNumber(), user.getPassHash());

        Assert.assertEquals(userByEmail.getEmail(), userByPhoneNum.getEmail());
        Assert.assertEquals(userByEmail.getName(), userByPhoneNum.getName());
        Assert.assertEquals(userByEmail.getPhoneNumber(), userByPhoneNum.getPhoneNumber());
        Assert.assertEquals(userByEmail.getId(), userByPhoneNum.getId());
    }
}
