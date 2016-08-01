package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.company.Company;

public interface CompanyRelation {

    int getId();

    Company getCompany();

    boolean isAdmin();

    void setId(int id);

    void setCompany(Company company);

    void setIsAdmin(boolean isAdmin);

}
