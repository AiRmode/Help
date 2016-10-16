package com.provectus.prodobro.actor.company;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.relation.EmployeeRelation;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.shared.StatusEnumNew;
import com.provectus.prodobro.shared.avatar.Avatar;
import com.provectus.prodobro.shared.info.Info;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Set;

public interface Company {

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

    String getTitle();

    void setTitle(String title);

    Set<String> getStringAliases();

    Set<CompanyAlias> getAliases();

    void setAliases(Set<CompanyAlias> aliases);

    String getDescription();

    void setDescription(String description);

    /**
     * @return {@link Set<EmployeeRelation>} of assigned users
     */
    Set<EmployeeRelation> getEmployeeRelations();

    void setEmployeeRelations(Set<EmployeeRelation> employeeRelations);

    Set<User> getUsers();

    Set<User> getAdmins();

    /**
     * @return {@link Set<User>} of company assigned events
     */
    Set<Event> getAssignedEvents();

    void setAssignedEvents(Set<Event> assignedEvents);

}
