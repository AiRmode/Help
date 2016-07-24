package com.provectus.prodobro.actor.shelter;


import com.provectus.prodobro.actor.Actor;
import com.provectus.prodobro.event.Event;

import java.util.List;
import java.util.Optional;

public interface Shelter extends Actor {

    String getTitle();

    Optional<String> getDescription();

    ShelterType getType();

    /**
     * @return {@link Optional}<{@link Event}> for shelter
     */
    Optional<Event> getEvent();

    List<Tag> getTags();

    void setTitle(String title);

    void setDescription(String description);

    void setType(ShelterType type);

    void setEvent(Event event);

    void setTags(List<Tag> tags);


}
