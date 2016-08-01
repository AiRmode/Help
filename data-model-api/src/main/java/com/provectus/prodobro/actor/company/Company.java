package com.provectus.prodobro.actor.company;


import com.provectus.prodobro.actor.Actor;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.event.Event;

import java.util.List;
import java.util.Set;

public interface Company extends Actor {

    String getTitle();

    Set<String> getAliases();

    String getDescription();

    /**
     * @return {@link Set<User>} of assigned users
     */
    Set<User> getUsers();

    /**
     * @return {@link Set<User>} of admin users
     */
    Set<User> getAdmins();

    /**
     * @return {@link List<User>} of company assigned events
     */
    Set<Event> getAssignedEvents();

    void setTitle(String title);

    void setAliases(Set<String> aliases);

    void setDescription(String description);

    void setUsers(Set<User> users);

    void setAdmins(Set<User> admins);

    void setAssignedEvents(Set<Event> assignedEvents);

    void addAlias(String alias);

    void removeAlias(String alias);

    void addUser(User user);

    void addAdmin(User admin);

    void removeUser(User user);

    void removeAdmin(User admin);

    void addAssignedEvent(Event event);

    void removeAssignedEvent(Event event);

}
