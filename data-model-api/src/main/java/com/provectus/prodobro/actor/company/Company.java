package com.provectus.prodobro.actor.company;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.relation.EmployeeRelation;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.shared.avatar.Avatar;
import com.provectus.prodobro.shared.info.Info;
import com.provectus.prodobro.shared.status.Status;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Set;

public interface Company {

    Long getId();

    Optional<Avatar> getAvatar();

    /**
     * Information: Photos, Emails, Websites, etc.
     *
     * @return {@link Set< Info >} of Actor`s information
     */
    Set<Info> getInfo();

    Status getStatus();

    Timestamp getCreatedDate();

    User getCreatedBy();

    Timestamp getLastModifiedDate();

    User getLastModifiedBy();

    String getTitle();

    Set<String> getStringAliases();

    Set<CompanyAlias> getAliases();

    String getDescription();

    /**
     * @return {@link Set<EmployeeRelation>} of assigned users
     */
    Set<EmployeeRelation> getEmployeeRelations();

    Set<User> getUsers();

    Set<User> getAdmins();

    /**
     * @return {@link Set<User>} of company assigned events
     */
    Set<Event> getAssignedEvents();

    void setId(Long id);

    void setAvatar(Avatar avatar);

    void setInfo(Set<Info> info);

    void setStatus(Status status);

    void setCreatedDate(Timestamp createdDate);

    void setCreatedBy(User createdBy);

    void setLastModifiedDate(Timestamp lastModifiedDate);

    void setLastModifiedBy(User lastModifiedBy);

    void setTitle(String title);

    void setAliases(Set<CompanyAlias> aliases);

    void setDescription(String description);

    void setEmployeeRelations(Set<EmployeeRelation> employeeRelations);

    void setAssignedEvents(Set<Event> assignedEvents);

}
