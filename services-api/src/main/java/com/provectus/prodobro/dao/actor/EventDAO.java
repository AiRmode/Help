package com.provectus.prodobro.dao.actor;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.dao.GenericDAO;
import com.provectus.prodobro.shared.status.StatusEnum;

import java.sql.Timestamp;
import java.util.List;

public interface EventDAO extends GenericDAO<Event, Long> {

    Event getByTitle(String title);

    List<Event> getByDate(Timestamp date);

    List<Event> getByStatus(String status);

    List<Event> getByStatus(StatusEnum status);

    List<Event> getAccessible();

    List<Event> getPrivate();
}
