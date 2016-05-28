package com.formula1.help.actor.company;

import com.formula1.help.actor.user.User;
import com.formula1.help.actor.personalData.PersonalData;

import java.util.Set;

/**
 * Created by alexey on 02.05.16.
 */
public interface Company {

    int getCompanyID();

    User getCreatedUser();

    String getTitle();

    void setTitle(String title);

    Set<String> getAliases();

    void addAlias(String title);

    void removeAlias(String title);

    Set<String> getWebSite();

    void addWebSite(String webSite);

    void removeWebSite(String webSite);

    Set<User> getCompanyAdminUsers();

    Set<User> getMembers();

    Set<String> getCompanyType();

    CompanyStatus getCompanyStatus();

    PersonalData getPersonalData();

    void addAdminUser(User adminUser);

    void addMember(User member);

    void removeAdminUser(User adminUser);

    void removeMemberUser(User user);
}
