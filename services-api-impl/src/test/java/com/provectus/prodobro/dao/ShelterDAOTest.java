package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.shelter.ShelterImpl;
import com.provectus.prodobro.actor.shelter.ShelterTypeEnum;
import com.provectus.prodobro.actor.shelter.ShelterTypeImpl;
import com.provectus.prodobro.dao.actor.ShelterDAO;
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
public class ShelterDAOTest {

	@Autowired
	private ShelterDAO shelterDAO;

	private Shelter shelter;

	@Before
	public void setUpData() {
		shelter = new ShelterImpl();
		shelter.setTitle("Shelter");

		ShelterTypeImpl shelterType = new ShelterTypeImpl();
		shelterType.setType(ShelterTypeEnum.HUMAN.name());
		shelter.setType(shelterType);
		shelter.setStatus(StatusEnum.ACTIVE);

		Timestamp timestamp = new Timestamp(new Date().getTime());
		shelter.setCreatedDate(timestamp);
		shelter.setLastModifiedDate(timestamp);
	}

	@Test
	@Transactional
	@Rollback
	public void shelterDAOTest() {
		shelterDAO.save(shelter);
		getByIdTest();
		getAllTest();
		getByTitleTest();
		getByStatusTest();
		getByTypeTest();
	}

	private void getByTypeTest() {
		List<Shelter> shelters = shelterDAO.getByType(shelter.getType().getType());
		assertTrue(shelters.contains(shelter));
	}

	private void getByStatusTest() {
		List<Shelter> shelters = shelterDAO.getByStatus(shelter.getStatus());
		assertTrue(shelters.contains(shelter));
	}

	private void getByTitleTest() {
		Shelter shelterFromDB = shelterDAO.getByTitle(shelter.getTitle());
		assertTrue(shelter.equals(shelterFromDB));
	}

	private void getAllTest() {
		List<Shelter> shelters = shelterDAO.getAll();
		assertTrue(shelters.contains(shelter));
	}

	private void getByIdTest() {
		Shelter shelterFromDB = shelterDAO.getById(shelter.getId());
		assertTrue(shelter.equals(shelterFromDB));
	}
}
