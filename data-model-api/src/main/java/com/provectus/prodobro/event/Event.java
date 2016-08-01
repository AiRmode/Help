package com.provectus.prodobro.event;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Event {

    int getId();

    String getTitle();

    Set<Info> getInfo();

    Optional<String> getDescription();

    Shelter getShelter();

    Timestamp getDate();

    boolean isAccessible();

    Timestamp getCreatedDate();

    User getCreatedBy();

    Timestamp getLastModifiedDate();

    User getLastModifiedBy();

    Set<User> getAssignedUsers();

    Set<Company> getAssignedCompanies();

    void setId(int id);

    void setTitle(String title);

    void setInfo(Set<Info> info);

    void setDescription(String description);

    void setShelter(Shelter shelter);

    void setDate(Timestamp date);

    void setAccessible(boolean accessible);

    void setCreatedDate(Timestamp createdDate);

    void setCreatedBy(User createdBy);

    void setLastModifiedDate(Timestamp lastModifiedDate);

    void setLastModifiedBy(User lastModifiedBy);

    void addInfo(Info info);

    void removeInfo(Info info);

    void setAssignedUsers(Set<User> assignedUsers);

    void setAssignedCompanies(Set<Company> assignedCompanies);

    void addAssignedUser(User user);

    void removeAssignedUser(User user);

    void addAssignedCompany(Company company);

    void removeAssignedCompany(Company company);

}
