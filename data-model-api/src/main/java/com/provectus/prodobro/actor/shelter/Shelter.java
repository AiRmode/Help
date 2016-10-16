package com.provectus.prodobro.actor.shelter;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.shared.StatusEnumNew;
import com.provectus.prodobro.shared.avatar.Avatar;
import com.provectus.prodobro.shared.info.Info;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Set;

public interface Shelter {

    Long getId();

    void setId(Long id);

    Optional<Avatar> getAvatar();

    void setAvatar(Avatar avatar);

    /**
     * Information: Photos, Emails, Websites, etc.
     *
     * @return {@link Set<Info>} of Actor`s information
     */
    Set<Info> getInfo();

    void setInfo(Set<Info> info);

    StatusEnumNew getStatus();

    void setStatus(StatusEnumNew status);

    int getStatusCode();

    void setStatusCode(int statusCode);

    Timestamp getCreatedDate();

    void setCreatedDate(Timestamp createdDate);

    User getCreatedBy();

    void setCreatedBy(User createdBy);

    Timestamp getLastModifiedDate();

    void setLastModifiedDate(Timestamp lastModifiedDate);

    User getLastModifiedBy();

    void setLastModifiedBy(User lastModifiedBy);

    String getTitle();

    void setTitle(String title);

    Optional<String> getDescription();

    void setDescription(String description);

    ShelterType getType();

    void setType(ShelterType type);

    /**
     * @return {@link Optional}<{@link Event}> for shelter
     */
    Optional<Event> getEvent();

    void setEvent(Event event);

    Set<Tag> getTags();

    void setTags(Set<Tag> tags);

}
