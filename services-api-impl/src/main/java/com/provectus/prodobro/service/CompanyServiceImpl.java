package com.provectus.prodobro.service;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.dao.actor.CompanyDAO;
import com.provectus.prodobro.service.actor.CompanyService;
import com.provectus.prodobro.shared.StatusEnumNew;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    private CompanyDAO companyDAO;

    @Override
    public void save(Company object) {
        companyDAO.save(object);
    }

    @Override
    public Company getById(Long id) {
        return companyDAO.getById(id);
    }

    @Override
    public void update(Company object) {
        companyDAO.update(object);
    }

    /**
     * Removing company is deprecated
     * Use makeRemovedById()
     *
     * @param object Company
     */
    @Deprecated
    @Override
    public void remove(Company object) {
        companyDAO.remove(object);
    }

    @Override
    public List<Company> getAll() {
        return companyDAO.getAll();
    }

    @Override
    public void makeRemovedById(Long id) {
        Company company = companyDAO.getById(id);
        company.setStatus(StatusEnumNew.DELETED);
        companyDAO.update(company);
    }

    @Override
    public Company getByTitle(String title) {
        return companyDAO.getByTitle(title);
    }

    @Override
    public List<Company> getByStatus(StatusEnumNew status) {
        return companyDAO.getByStatus(status);
    }

    @Required
    @Resource(name = "companyDAO")
    public void setCompanyDAO(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }
}
