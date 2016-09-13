package com.provectus.prodobro.actor.event;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.shared.avatar.Avatar;
import com.provectus.prodobro.shared.info.Info;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Set;

public interface Event {

    Long getId();

    void setId(Long id);

    String getTitle();

    void setTitle(String title);

    Optional<Avatar> getAvatar();

    Set<Info> getInfo();

    void setInfo(Set<Info> info);

    Optional<String> getDescription();

    void setDescription(String description);

    Shelter getShelter();

    void setShelter(Shelter shelter);

    Timestamp getDate();

    void setDate(Timestamp date);

    boolean isAccessible();

    void setAccessible(boolean accessible);

    Timestamp getCreatedDate();

    void setCreatedDate(Timestamp createdDate);

    User getCreatedBy();

    void setCreatedBy(User createdBy);

    Timestamp getLastModifiedDate();

    void setLastModifiedDate(Timestamp lastModifiedDate);

    User getLastModifiedBy();

    void setLastModifiedBy(User lastModifiedBy);

    Set<User> getAssignedUsers();

    void setAssignedUsers(Set<User> assignedUsers);

    Set<Company> getAssignedCompanies();

    void setAssignedCompanies(Set<Company> assignedCompanies);

}
