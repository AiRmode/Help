package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.Actor;
import com.provectus.prodobro.event.Event;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

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
     * @return {@link Set<Event>} of events, where {@link User} is assigned
     */
    Set<Event> getAssignedEvents();

    /**
     * @return {@link Set<Event>} of events, {@link User} has created
     */
    Set<Event> getCreatedEvents();

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setEmail(String email);

    void setPassHash(String passHash);

    void setPhoneNumber(String phoneNumber);

    void setLanguage(Locale language);

    void setCompanyRelation(CompanyRelation companyRelation);

    void setAssignedEvents(Set<Event> assignedEvents);

    void setCreatedEvents(Set<Event> createdEvents);

    void addAssignedEvent(Event event);

    void removeAssignedEvent(Event event);

    void addCreatedEvent(Event event);

    void removeCreatedEvent(Event event);

}
