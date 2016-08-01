package com.provectus.prodobro.actor;


import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface Actor {

    /**
     * @return Actor`s identifier
     */
    int getId();

    /**
     * @return Actor`s avatar
     */
    Optional<byte[]> getAvatarBytea();

    /**
     * Information: Photos, Emails, Websites, etc.
     *
     * @return {@link List<Info>} of Actor`s information
     */
    Set<Info> getInfo();

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
    void setId(int id);

    void setAvatarBytea(byte[] avatarBytea);

    void setInfo(Set<Info> info);

    void setStatus(ActorStatus status);

    void setCreatedDate(Timestamp createdDate);

    void setCreatedBy(User createdBy);

    void setLastModifiedDate(Timestamp lastModifiedDate);

    void setLastModifiedBy(User lastModifiedBy);

    void addInfo(Info info);

    void removeInfo(Info info);
}
