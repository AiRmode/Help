package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.Actor;
import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.event.Event;

import java.util.List;
import java.util.Locale;

public interface User extends Actor {

    String getFirstName();

    String getLastName();

    String getEmail();

    String getPassHash();

    String getPhoneNumber();

    /**
     * @return User`s locale
     */
    Locale getLanguage();

    /**
     * @return {@link List<Company>} of companies, where {@link User} is assigned
     */
    List<Company> getUserAssignedCompanies();

    /**
     * @return {@link List<Company>} of companies, where {@link User} is assigned as admin
     */
    List<Company> getUserIsAdminCompanies();

    /**
     * @return {@link List<Event>} of events, where {@link User} is assigned
     */
    List<Event> getUserAssignedEvents();

    /**
     * @return {@link List<Event>} of events, {@link User} has created
     */
    List<Event> getUserCreatedEvents();

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setEmail(String email);

    void setPassHash(String passHash);

    void setPhoneNumber(String phoneNumber);

    void setLanguage(Locale language);

    void setUserAssignedCompanies(List<Company> userAssignedCompanies);

    void setUserIsAdminCompanies(List<Company> userIsAdminCompanies);

    void setUserAssignedEvents(List<Event> userAssignedEvents);

    void setUserCreatedEvents(List<Event> userCreatedEvents);

}
