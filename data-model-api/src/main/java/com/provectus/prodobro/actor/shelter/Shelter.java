package com.provectus.prodobro.actor.shelter;


import com.provectus.prodobro.actor.Actor;
import com.provectus.prodobro.event.Event;

import java.util.List;

public interface Shelter extends Actor {

    String getTitle();

    String getDescription();

    ShelterType getType();

    /**
     * @return {@link Event} for shelter
     * @throws NullPointerException if no assigned event
     */
    Event getEvent() throws NullPointerException;

    List<Tag> getTags();

    void setTitle(String title);

    void setDescription(String description);

    void setType(ShelterType type);

    void setEvent(Event event);

    void setTags(List<Tag> tags);


}
