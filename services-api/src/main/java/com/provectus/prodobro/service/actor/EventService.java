package com.provectus.prodobro.service.actor;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.service.GenericService;
import com.provectus.prodobro.shared.status.StatusEnum;

import java.sql.Timestamp;
import java.util.List;

public interface EventService extends GenericService<Event, Long> {

    Event getByTitle(String title);

    List<Event> getByDate(Timestamp date);

    List<Event> getByStatus(StatusEnum status);

    List<Event> getByStatus(String status);

    List<Event> getAccessible();

    List<Event> getPrivate();
}
