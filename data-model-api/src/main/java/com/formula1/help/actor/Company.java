package com.formula1.help.actor;

import java.util.List;

/**
 * Created by alexey on 02.05.16.
 */
public interface Company {

     int getCompanyID();

     User getCreatedUser();

     String getName();

     List<String> getWebSite();

     List<User> getAdminUsers();

     List<User> getMembers();

     List<String> getCompanyType();

     CompanyStatus getCompanyStatus();

     void setCreatedUser(User createdUser);

     void setName(String name);

     void setWebSite(List<String> webSite);

     void setAdminUsers(List<User> adminUsers);

     void setMembers(List<User> members);

     void setCompanyType(List<String> companyType);

     void setCompanyStatus(CompanyStatus companyStatus);
}
