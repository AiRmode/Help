package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.relation.EmployeeRelation;
import com.provectus.prodobro.shared.avatar.Avatar;
import com.provectus.prodobro.shared.info.Info;
import com.provectus.prodobro.shared.status.StatusEnumNew;

import java.sql.Timestamp;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

public interface User {

    Long getId();

    void setId(Long id);

    Optional<Avatar> getAvatar();

    void setAvatar(Avatar avatar);

    /**
     * Information: Photos, Emails, Websites, etc.
     *
     * @return {@link Set<Info>} of Actor`s information
     */
    Set<Info> getInfo();

    void setInfo(Set<Info> info);

    StatusEnumNew getStatus();

    void setStatus(StatusEnumNew status);

    int getStatusCode();

    void setStatusCode(int statusCode);

    Timestamp getCreatedDate();

    void setCreatedDate(Timestamp createdDate);

    User getCreatedBy();

    void setCreatedBy(User createdBy);

    Timestamp getLastModifiedDate();

    void setLastModifiedDate(Timestamp lastModifiedDate);

    User getLastModifiedBy();

    void setLastModifiedBy(User lastModifiedBy);

    String getName();

    void setName(String name);

    String getEmail();

    void setEmail(String email);

    String getPassHash();

    void setPassHash(String passHash);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    boolean isSuperUser();

    void setSuperUser(boolean isSuperUser);

    /**
     * @return User`s locale
     */
    Locale getLanguage();

    void setLanguage(Locale language);

    /**
     * @return {@link Optional<EmployeeRelation>} user`s company
     */
    Optional<EmployeeRelation> getEmployeeRelation();

    void setEmployeeRelation(EmployeeRelation employeeRelation);

    /**
     * @return {@link Set<Event>} of events, where {@link User} is assigned
     */
    Set<Event> getAssignedEvents();

    void setAssignedEvents(Set<Event> assignedEvents);

    /**
     * @return {@link Set<Event>} of events, {@link User} has created
     */
    Set<Event> getCreatedEvents();

}
