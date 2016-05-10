package com.formula1.help.actors;

import java.util.List;

/**
 * Created by alexey on 02.05.16.
 */
public interface User {

    int getID();

     String getFirstName();

     String getLastName();

     String getEmail();

     String getPassword();

    /**
     * phone number with +
     *
     * @return
     */
     String getFullPhoneNumber();

     int getPhoneNumber();

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

     void setFirstName(String firstName);

     void setLastName(String lastName);

     void setEmail(String email);

     void setPassword(String password);

     void setPhoneNumber(int phoneNumber);

     void setAvatarRef(String avatarRef);

     void setUserAssignedCompanies(List<Company> userAssignedCompanies);

     void setUserIsAdminCompanies(List<Company> userIsAdminCompanies);

     void setUserStatus(UserStatus userStatus);
}
