package com.formula1.help.actor.user;

import com.formula1.help.actor.company.Company;
import com.formula1.help.actor.personalData.PersonalData;

import java.util.List;

/**
 * Created by alexey on 02.05.16.
 */
public interface User {

    int getID();

    String getFirstName();

    String getLastName();

    String getPassword();

    String getFirstLastName();

    String getAvatarRef();

    /**
     * return list of companies, where user is a participant
     *
     * @return
     */
    List<Company> getUserAssignedCompanies();

    /**
     * return list of companies, where user has admin privileges
     *
     * @return
     */
    List<Company> getUserIsAdminCompanies();

    UserStatus getUserStatus();

    PersonalData getPersonalData();

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setPassword(String password);

    void setAvatarRef(String avatarRef);

    void setUserAssignedCompanies(List<Company> userAssignedCompanies);

    void setUserIsAdminCompanies(List<Company> userIsAdminCompanies);

    void setUserStatus(UserStatus userStatus);

    void setPersonalData(PersonalData personalData);
}
