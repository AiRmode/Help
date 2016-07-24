package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.company.Company;

public class CompanyRelationImpl implements CompanyRelation {

    private Company company;
    private boolean isAdmin;

    @Override
    public Company getCompany() {
        return company;
    }

    @Override
    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
