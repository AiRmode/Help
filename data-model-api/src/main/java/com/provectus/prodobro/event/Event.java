package com.provectus.prodobro.event;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.List;

public interface Event {

    int getId();

    String getTitle();

    List<Info> getInfo();

    String getDescription();

    Shelter getShelter();

    Timestamp getDate();

    boolean isAccessible();

    Timestamp getCreatedDate();

    User getCreatedBy();

    Timestamp getLastModifiedDate();

    User getLastModifiedBy();

    List<User> getAssignedUsers();

    List<Company> getAssignedCompanies();

    void setTitle(String title);

    void setInfo(List<Info> info);

    void setDescription(String description);

    void setShelter(Shelter shelter);

    void setDate(Timestamp date);

    void setAccessible(boolean accessible);

    void setCreatedDate(Timestamp createdDate);

    void setCreatedBy(User createdBy);

    void setLastModifiedDate(Timestamp lastModifiedDate);

    void setLastModifiedBy(User lastModifiedBy);

    void setAssignedUsers(List<User> assignedUsers);

    void setAssignedCompanies(List<Company> assignedCompanies);

}
