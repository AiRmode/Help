package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.company.Company;

public interface CompanyRelation {

    Company getCompany();

    boolean isAdmin();

    void setCompany(Company company);

    void setIsAdmin(boolean isAdmin);

}
