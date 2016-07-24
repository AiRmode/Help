package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.Actor;
import com.provectus.prodobro.event.Event;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

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
     * @return {@link Optional<CompanyRelation>} user`s company
     */
    Optional<CompanyRelation> getCompanyRelation();

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

    void setCompanyRelation(CompanyRelation companyRelation);

    void setUserAssignedEvents(List<Event> userAssignedEvents);

    void setUserCreatedEvents(List<Event> userCreatedEvents);

}
