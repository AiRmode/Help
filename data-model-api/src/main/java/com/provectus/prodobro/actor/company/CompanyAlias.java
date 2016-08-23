package com.provectus.prodobro.actor.company;


public interface CompanyAlias {

    Long getId();

    String getAlias();

    Company getCompany();

    void setId(Long id);

    void setAlias(String alias);

    void setCompany(Company company);
}
