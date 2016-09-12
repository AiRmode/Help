package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.company.CompanyImpl;
import com.provectus.prodobro.actor.company.CompanyStatus;
import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.shelter.Tag;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import com.provectus.prodobro.actor.user.UserStatus;
import com.provectus.prodobro.dao.actor.CompanyDAO;
import com.provectus.prodobro.dao.actor.EventDAO;
import com.provectus.prodobro.dao.actor.ShelterDAO;
import com.provectus.prodobro.dao.actor.UserDAO;
import com.provectus.prodobro.shared.status.Status;
import com.provectus.prodobro.shared.status.StatusEnum;
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
public class TestDAO {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private CompanyDAO companyDAO;
    @Autowired
    private ShelterDAO shelterDAO;
    @Autowired
    private EventDAO eventDAO;
    @Autowired
    private TagDAO tagDAO;

    private User user;
    private Company company;
    private Shelter shelter;
    private Event event;
    private Tag tag;

    @Before
    public void setUpTestData() {
        initUser();
        initCompany();
        initShelter();
        initEvent();
        initTag();
    }

    private void initUser() {
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

    private void initCompany() {
        company = new CompanyImpl();
        company.setTitle("Provectus");

        Status status = new CompanyStatus();
        status.setStatus("ACTIVE");
        company.setStatus(status);

        company.setCreatedBy(user);
        company.setLastModifiedBy(user);

        Timestamp timestamp = new Timestamp(new Date().getTime());
        company.setCreatedDate(timestamp);
        company.setLastModifiedDate(timestamp);
    }

    private void initShelter() {
    }

    private void initEvent() {
    }

    private void initTag() {
    }

    @Test
    @Transactional
    @Rollback
    public void allDAOTest() {
        userDAO.save(user);

        getUserByIdTest();
        getAllUsersTest();
        getUsersByNameTest();
        getUsersByStatusTest();
        getUserByPhoneNumberTest();
        getUserByEmailTest();

        companyDAO.save(company);
        getCompanyById();
        getAllCompanies();
        getCompanyByTitle();
        getCompaniesByStatus();
    }

    private void getCompaniesByStatus() {
        List<Company> companies = companyDAO.getByStatus(StatusEnum.ACTIVE);

        Assert.assertEquals(1, companies.size());
        Assert.assertEquals(company.getTitle(), companies.get(0).getTitle());
        Assert.assertEquals(company.getId(), companies.get(0).getId());
        Assert.assertEquals(company.getCreatedBy(), companies.get(0).getCreatedBy());
        Assert.assertEquals(company.getCreatedDate(), companies.get(0).getCreatedDate());
    }

    private void getCompanyByTitle() {
        Company companyFromDB = companyDAO.getByTitle(company.getTitle());

        Assert.assertEquals(company.getId(), companyFromDB.getId());
        Assert.assertEquals(company.getStatus(), companyFromDB.getStatus());
        Assert.assertEquals(company.getCreatedBy(), companyFromDB.getCreatedBy());
        Assert.assertEquals(company.getCreatedDate(), companyFromDB.getCreatedDate());
    }

    private void getAllCompanies() {
        List<Company> companies = companyDAO.getAll();

        Assert.assertEquals(1, companies.size());
        Assert.assertEquals(company.getTitle(), companies.get(0).getTitle());
        Assert.assertEquals(company.getId(), companies.get(0).getId());
        Assert.assertEquals(company.getCreatedBy(), companies.get(0).getCreatedBy());
        Assert.assertEquals(company.getCreatedDate(), companies.get(0).getCreatedDate());
    }

    private void getCompanyById() {
        Company companyFromDB = companyDAO.getById(company.getId());

        Assert.assertEquals(company.getTitle(), companyFromDB.getTitle());
        Assert.assertEquals(company.getStatus(), companyFromDB.getStatus());
        Assert.assertEquals(company.getCreatedBy(), companyFromDB.getCreatedBy());
        Assert.assertEquals(company.getCreatedDate(), companyFromDB.getCreatedDate());
    }

    private void getUserByIdTest() {
        User userFromDB = userDAO.getById(user.getId());

        Assert.assertEquals(user.getName(), userFromDB.getName());
        Assert.assertEquals(user.getEmail(), userFromDB.getEmail());
        Assert.assertEquals(user.getPhoneNumber(), userFromDB.getPhoneNumber());
    }

    private void getAllUsersTest() {
        List<User> users = userDAO.getAll();

        Assert.assertEquals(1, users.size());
        Assert.assertEquals(user.getId(), users.get(0).getId());
        Assert.assertEquals(user.getName(), users.get(0).getName());
        Assert.assertEquals(user.getEmail(), users.get(0).getEmail());
        Assert.assertEquals(user.getPhoneNumber(), users.get(0).getPhoneNumber());
    }

    private void getUsersByNameTest() {
        List<User> users = userDAO.getByName(user.getName());

        Assert.assertEquals(1, users.size());
        Assert.assertEquals(user.getId(), users.get(0).getId());
        Assert.assertEquals(user.getEmail(), users.get(0).getEmail());
        Assert.assertEquals(user.getPhoneNumber(), users.get(0).getPhoneNumber());
    }

    private void getUsersByStatusTest() {
        List<User> users = userDAO.getByStatus(user.getStatus().getStatus());

        Assert.assertEquals(1, users.size());
        Assert.assertEquals(user.getId(), users.get(0).getId());
        Assert.assertEquals(user.getName(), users.get(0).getName());
        Assert.assertEquals(user.getEmail(), users.get(0).getEmail());
        Assert.assertEquals(user.getPhoneNumber(), users.get(0).getPhoneNumber());
    }

    private void getUserByPhoneNumberTest() {
        User userFromDB = userDAO.getByPhoneNumber(user.getPhoneNumber());

        Assert.assertEquals(user.getId(), userFromDB.getId());
        Assert.assertEquals(user.getName(), userFromDB.getName());
        Assert.assertEquals(user.getEmail(), userFromDB.getEmail());
    }

    private void getUserByEmailTest() {
        User userFromDB = userDAO.getByEmail(user.getEmail());

        Assert.assertEquals(user.getId(), userFromDB.getId());
        Assert.assertEquals(user.getName(), userFromDB.getName());
        Assert.assertEquals(user.getPhoneNumber(), userFromDB.getPhoneNumber());
    }
}
