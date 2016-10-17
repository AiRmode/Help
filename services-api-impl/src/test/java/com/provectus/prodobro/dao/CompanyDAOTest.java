package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.company.CompanyImpl;
import com.provectus.prodobro.dao.actor.CompanyDAO;
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
public class CompanyDAOTest {

    @Autowired
    private CompanyDAO companyDAO;

    private Company company;

    @Before
    public void setUpData() {
        company = new CompanyImpl();
        company.setTitle("Provectus");
        company.setStatus(StatusEnum.ACTIVE);

        Timestamp timestamp = new Timestamp(new Date().getTime());
        company.setCreatedDate(timestamp);
        company.setLastModifiedDate(timestamp);
    }

    @Test
    @Transactional
    @Rollback
    public void companyDAOTest() {
        companyDAO.save(company);
        getByIdTest();
        getAllTest();
        getByTitleTest();
        getByStatusTest();
    }

    private void getByStatusTest() {
        List<Company> companies = companyDAO.getByStatus(StatusEnum.ACTIVE);
        assertTrue(companies.contains(company));
    }

    private void getByTitleTest() {
        Company companyFromDB = companyDAO.getByTitle(company.getTitle());
        assertTrue(companyFromDB.equals(company));
    }

    private void getAllTest() {
        List<Company> companies = companyDAO.getAll();
        assertTrue(companies.contains(company));
    }

    private void getByIdTest() {
        Company companyFromDB = companyDAO.getById(company.getId());
        assertTrue(companyFromDB.equals(company));
    }
}
