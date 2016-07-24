package com.provectus.prodobro.actor.company;


import com.provectus.prodobro.actor.Actor;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.event.Event;

import java.util.List;

public interface Company extends Actor {

    String getTitle();

    List<String> getAlias();

    String getDescription();

    /**
     * @return {@link List<User>} of assigned users
     */
    List<User> getUsers();

    /**
     * @return {@link List<User>} of admin users
     */
    List<User> getAdmins();

    /**
     * @return {@link List<User>} of company assigned events
     */
    List<Event> getCompanyAssignedEvents();

    void setTitle(String title);

    void setAlias(List<String> alias);

    void setDescription(String description);

    void setUsers(List<User> users);

    void setCompanyAssignedEvents(List<Event> companyAssignedEvents);


}
