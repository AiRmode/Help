package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import com.provectus.prodobro.dao.actor.UserDAO;
import com.provectus.prodobro.shared.status.StatusEnumNew;
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

import static org.junit.Assert.assertEquals;

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
        user.setStatus(StatusEnumNew.ACTIVE);

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

//        assertEquals(user, userFromDB);   //TODO

        assertEquals(user.getName(), userFromDB.getName());
        assertEquals(user.getEmail(), userFromDB.getEmail());
        assertEquals(user.getPhoneNumber(), userFromDB.getPhoneNumber());
    }

    private void getAllTest() {
        List<User> users = userDAO.getAll();

        assertEquals(1, users.size());
        assertEquals(user.getId(), users.get(0).getId());
        assertEquals(user.getName(), users.get(0).getName());
        assertEquals(user.getEmail(), users.get(0).getEmail());
        assertEquals(user.getPhoneNumber(), users.get(0).getPhoneNumber());
    }

    private void getByNameTest() {
        List<User> users = userDAO.getByName(user.getName());

        assertEquals(1, users.size());
        assertEquals(user.getId(), users.get(0).getId());
        assertEquals(user.getEmail(), users.get(0).getEmail());
        assertEquals(user.getPhoneNumber(), users.get(0).getPhoneNumber());
    }

    private void getByStatusTest() {
        List<User> users = userDAO.getByStatus(user.getStatus());

        assertEquals(1, users.size());
        assertEquals(user.getId(), users.get(0).getId());
        assertEquals(user.getName(), users.get(0).getName());
        assertEquals(user.getEmail(), users.get(0).getEmail());
        assertEquals(user.getPhoneNumber(), users.get(0).getPhoneNumber());
    }

    private void getByPhoneNumberTest() {
        User userFromDB = userDAO.getByPhoneNumber(user.getPhoneNumber());

        assertEquals(user.getId(), userFromDB.getId());
        assertEquals(user.getName(), userFromDB.getName());
        assertEquals(user.getEmail(), userFromDB.getEmail());
    }

    private void getByEmailTest() {
        User userFromDB = userDAO.getByEmail(user.getEmail());

        assertEquals(user.getId(), userFromDB.getId());
        assertEquals(user.getName(), userFromDB.getName());
        assertEquals(user.getPhoneNumber(), userFromDB.getPhoneNumber());
    }

    private void getByLoginAndPasswordTest() {
        User userByEmail = userDAO.getByLoginAndPassword(user.getEmail(), user.getPassHash());
        User userByPhoneNum = userDAO.getByLoginAndPassword(user.getPhoneNumber(), user.getPassHash());

        assertEquals(userByEmail.getEmail(), userByPhoneNum.getEmail());
        assertEquals(userByEmail.getName(), userByPhoneNum.getName());
        assertEquals(userByEmail.getPhoneNumber(), userByPhoneNum.getPhoneNumber());
        assertEquals(userByEmail.getId(), userByPhoneNum.getId());
    }
}
