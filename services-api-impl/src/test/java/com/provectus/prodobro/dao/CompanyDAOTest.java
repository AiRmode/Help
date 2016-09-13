package com.provectus.prodobro.dao;

import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.company.CompanyImpl;
import com.provectus.prodobro.actor.company.CompanyStatus;
import com.provectus.prodobro.dao.actor.CompanyDAO;
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
public class CompanyDAOTest {

    @Autowired
    private CompanyDAO companyDAO;

    private Company company;

    @Before
    public void setUpData() {
        company = new CompanyImpl();
        company.setTitle("Provectus");

        Status status = new CompanyStatus();
        status.setStatus("ACTIVE");
        company.setStatus(status);

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

        Assert.assertEquals(1, companies.size());
        Assert.assertEquals(company.getTitle(), companies.get(0).getTitle());
        Assert.assertEquals(company.getId(), companies.get(0).getId());
        Assert.assertEquals(company.getCreatedBy(), companies.get(0).getCreatedBy());
        Assert.assertEquals(company.getCreatedDate(), companies.get(0).getCreatedDate());
    }

    private void getByTitleTest() {
        Company companyFromDB = companyDAO.getByTitle(company.getTitle());

        Assert.assertEquals(company.getId(), companyFromDB.getId());
        Assert.assertEquals(company.getStatus(), companyFromDB.getStatus());
        Assert.assertEquals(company.getCreatedBy(), companyFromDB.getCreatedBy());
        Assert.assertEquals(company.getCreatedDate(), companyFromDB.getCreatedDate());
    }

    private void getAllTest() {
        List<Company> companies = companyDAO.getAll();

        Assert.assertEquals(1, companies.size());
        Assert.assertEquals(company.getTitle(), companies.get(0).getTitle());
        Assert.assertEquals(company.getId(), companies.get(0).getId());
        Assert.assertEquals(company.getCreatedBy(), companies.get(0).getCreatedBy());
        Assert.assertEquals(company.getCreatedDate(), companies.get(0).getCreatedDate());
    }

    private void getByIdTest() {
        Company companyFromDB = companyDAO.getById(company.getId());

        Assert.assertEquals(company.getTitle(), companyFromDB.getTitle());
        Assert.assertEquals(company.getStatus(), companyFromDB.getStatus());
        Assert.assertEquals(company.getCreatedBy(), companyFromDB.getCreatedBy());
        Assert.assertEquals(company.getCreatedDate(), companyFromDB.getCreatedDate());
    }
}
