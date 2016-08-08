package com.provectus.prodobro.actor.company;


public interface CompanyAlias {

    int getId();

    String getAlias();

    Company getCompany();

    void setId(int id);

    void setAlias(String alias);

    void setCompany(Company company);
}
