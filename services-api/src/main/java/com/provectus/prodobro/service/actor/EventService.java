package com.provectus.prodobro.service.actor;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.shared.status.Status;

import java.sql.Timestamp;
import java.util.List;

public interface EventService {

    void makeRemovedById(Long id);

    Event getByTitle(String title);

    Event getByDate(Timestamp date);

    List<Event> getByStatus(Status status);

    List<Event> getAccessible();

    List<Event> getPrivate();
}
