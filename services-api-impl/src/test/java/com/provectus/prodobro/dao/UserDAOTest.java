package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import com.provectus.prodobro.dao.actor.UserDAO;
import com.provectus.prodobro.shared.StatusEnum;
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

import static org.junit.Assert.assertTrue;

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
		user.setStatus(StatusEnum.ACTIVE);

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
		assertTrue(user.equals(userFromDB));
	}

	private void getAllTest() {
		List<User> users = userDAO.getAll();
		assertTrue(users.contains(user));
	}

	private void getByNameTest() {
		List<User> users = userDAO.getByName(user.getName());
		assertTrue(users.contains(user));
	}

	private void getByStatusTest() {
		List<User> users = userDAO.getByStatus(user.getStatus());
		assertTrue(users.contains(user));
	}

	private void getByPhoneNumberTest() {
		User userFromDB = userDAO.getByPhoneNumber(user.getPhoneNumber());
		assertTrue(user.equals(userFromDB));
	}

	private void getByEmailTest() {
		User userFromDB = userDAO.getByEmail(user.getEmail());
		assertTrue(user.equals(userFromDB));
	}

	private void getByLoginAndPasswordTest() {
		User userByEmail = userDAO.getByLoginAndPassword(user.getEmail(), user.getPassHash());
		User userByPhoneNum = userDAO.getByLoginAndPassword(user.getPhoneNumber(), user.getPassHash());
		assertTrue(userByEmail.equals(userByPhoneNum));
	}
}
