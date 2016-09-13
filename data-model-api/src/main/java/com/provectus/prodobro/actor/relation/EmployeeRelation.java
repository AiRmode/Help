package com.provectus.prodobro.actor.relation;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.user.User;

public interface EmployeeRelation {

    Long getId();

    void setId(Long id);

    User getUser();

    void setUser(User user);

    Company getCompany();

    void setCompany(Company company);

    boolean isAdmin();

    void setIsAdmin(boolean isAdmin);

}
