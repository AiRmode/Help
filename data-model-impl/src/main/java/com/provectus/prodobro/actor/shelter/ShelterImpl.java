package com.provectus.prodobro.actor.shelter;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.event.EventImpl;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import com.provectus.prodobro.shared.StatusEnum;
import com.provectus.prodobro.shared.avatar.Avatar;
import com.provectus.prodobro.shared.info.Info;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "shelter")
public class ShelterImpl implements Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ShelterAvatar.class)
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "owner",
            targetEntity = ShelterInfo.class
    )
    private Set<Info> info = new HashSet<>();

    @Column(name = "status_id")
    private int statusCode;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToOne(targetEntity = UserImpl.class)
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @Column(name = "last_modified_date")
    private Timestamp lastModifiedDate;

    @OneToOne(targetEntity = UserImpl.class)
    @JoinColumn(name = "last_modified_by_id")
    private User lastModifiedBy;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = ShelterTypeImpl.class)
    @JoinColumn(name = "type_id")
    private ShelterType type;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "shelter",
            targetEntity = EventImpl.class
    )
    private Event event;

    @ManyToMany(
            fetch = FetchType.EAGER,
            targetEntity = TagImpl.class
    )
    @JoinTable(
            name = "shelter_tag",
            joinColumns = @JoinColumn(name = "shelter_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

    public ShelterImpl() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Optional<Avatar> getAvatar() {
        return Optional.ofNullable(avatar);
    }

    @Override
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    @Override
    public Set<Info> getInfo() {
        return info;
    }

    @Override
    public void setInfo(Set<Info> info) {
        this.info = info;
    }

    @Override
    public StatusEnum getStatus() {
        return StatusEnum.getStatusByCode(statusCode);
    }

    @Override
    public void setStatus(StatusEnum status) {
        this.statusCode = status.getCode();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public User getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public ShelterType getType() {
        return type;
    }

    @Override
    public void setType(ShelterType type) {
        this.type = type;
    }

    @Override
    public Optional<Event> getEvent() {
        return Optional.ofNullable(event);
    }

    @Override
    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public Set<Tag> getTags() {
        return tags;
    }

    @Override
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShelterImpl)) return false;

        ShelterImpl shelter = (ShelterImpl) o;

        if (avatar != null ? !avatar.equals(shelter.avatar) : shelter.avatar != null) return false;
        if (!info.equals(shelter.info)) return false;
        if (statusCode != shelter.getStatusCode()) return false;
        if (!createdDate.equals(shelter.createdDate)) return false;
        if (!lastModifiedDate.equals(shelter.lastModifiedDate)) return false;
        if (!title.equals(shelter.title)) return false;
        if (description != null ? !description.equals(shelter.description) : shelter.description != null) return false;
        return type.equals(shelter.type);

    }

    @Override
    public int hashCode() {
        int result = avatar != null ? avatar.hashCode() : 0;
        result = 31 * result + info.hashCode();
        result = 31 * result + statusCode;
        result = 31 * result + createdDate.hashCode();
        result = 31 * result + lastModifiedDate.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + type.hashCode();
        return result;
    }
}
