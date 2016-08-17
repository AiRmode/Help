package com.provectus.prodobro.dao.actor;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.dao.GenericDAO;
import com.provectus.prodobro.shared.status.Status;
import com.sun.tools.javac.util.List;

import java.sql.Timestamp;

public interface EventDAO extends GenericDAO<Event, Integer> {

    void makeRemovedById(Integer id);

    Event getByTitle(String title);

    Event getByDate(Timestamp date);

    List<Event> getByStatus(Status status);

    List<Event> getAccessible();

    List<Event> getPrivate();
}
