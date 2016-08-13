package com.provectus.prodobro.actor.relation;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.user.User;

public interface EmployeeRelation {

    int getId();

    User getUser();

    Company getCompany();

    boolean isAdmin();

    void setId(int id);

    void setUser(User user);

    void setCompany(Company company);

    void setIsAdmin(boolean isAdmin);

}
