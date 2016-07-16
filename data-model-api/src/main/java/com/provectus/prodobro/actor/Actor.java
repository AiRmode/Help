package com.provectus.prodobro.actor;


import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.List;

public interface Actor {

    /**
     * @return Actor`s identifier
     */
    int getId();

    /**
     * @return Actor`s avatar
     */
    byte[] getAvatarBytea();

    /**
     * Information: Photos, Emails, Websites, etc.
     *
     * @return {@link List<Info>} of Actor`s information
     */
    List<Info> getInfo();

    /**
     * @return current {@link ActorStatus}
     */
    ActorStatus getStatus();

    /**
     * @return Actor`s created date
     */
    Timestamp getCreatedDate();

    /**
     * @return Actor`s creator
     */
    User getCreatedBy();

    /**
     * @return Last modified date
     */
    Timestamp getLastModifiedDate();

    /**
     * @return Actor`s last modifier
     */
    User getLastModifiedBy();

    // Setters
    void setAvatarBytea(byte[] avatarBytea);

    void setInfo(List<Info> info);

    void setStatus(ActorStatus status);

    void setCreatedDate(Timestamp createdDate);

    void setCreatedBy(User createdBy);

    void setLastModifiedDate(Timestamp lastModifiedDate);

    void setLastModifiedBy(User lastModifiedBy);
}
