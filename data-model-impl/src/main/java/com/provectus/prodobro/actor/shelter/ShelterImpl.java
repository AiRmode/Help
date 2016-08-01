package com.provectus.prodobro.actor.shelter;


import com.provectus.prodobro.actor.ActorStatus;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.event.Event;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class ShelterImpl implements Shelter {

    private int id;
    private Optional<byte[]> avatarBytea;
    private Set<Info> info = new TreeSet<>();
    private ActorStatus status;
    private Timestamp createdDate;
    private User createdBy;
    private Timestamp lastModifiedDate;
    private User lastModifiedBy;

    private String title;
    private Optional<String> description;
    private ShelterType type;
    private Optional<Event> event;
    private Set<Tag> tags = new TreeSet<>();

    public ShelterImpl() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Optional<byte[]> getAvatarBytea() {
        return avatarBytea;
    }

    @Override
    public Set<Info> getInfo() {
        return info;
    }

    @Override
    public ActorStatus getStatus() {
        return status;
    }

    @Override
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    @Override
    public User getCreatedBy() {
        return createdBy;
    }

    @Override
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public User getLastModifiedBy() {
        return lastModifiedBy;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Optional<String> getDescription() {
        return description;
    }

    @Override
    public ShelterType getType() {
        return type;
    }

    @Override
    public Optional<Event> getEvent() {
        return event;
    }

    @Override
    public Set<Tag> getTags() {
        return tags;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setAvatarBytea(byte[] avatarBytea) {
        this.avatarBytea = Optional.ofNullable(avatarBytea);
    }

    @Override
    public void setInfo(Set<Info> info) {
        this.info = info;
    }

    @Override
    public void setStatus(ActorStatus status) {
        this.status = status;
    }

    @Override
    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public void setLastModifiedBy(User lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setDescription(String description) {
        this.description = Optional.ofNullable(description);
    }

    @Override
    public void setType(ShelterType type) {
        this.type = type;
    }

    @Override
    public void setEvent(Event event) {
        this.event = Optional.ofNullable(event);
    }

    @Override
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public void addInfo(Info info) {
        this.info.add(info);
    }

    @Override
    public void removeInfo(Info info) {
        this.info.remove(info);
    }

    @Override
    public void addTag(Tag tag) {
        tags.add(tag);
    }

    @Override
    public void removeTag(Tag tag) {
        tags.remove(tag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShelterImpl)) return false;

        ShelterImpl shelter = (ShelterImpl) o;

        if (avatarBytea != null ? !avatarBytea.equals(shelter.avatarBytea) : shelter.avatarBytea != null) return false;
        if (info != null ? !info.equals(shelter.info) : shelter.info != null) return false;
        if (status != shelter.status) return false;
        if (!createdDate.equals(shelter.createdDate)) return false;
        if (!createdBy.equals(shelter.createdBy)) return false;
        if (!lastModifiedDate.equals(shelter.lastModifiedDate)) return false;
        if (!lastModifiedBy.equals(shelter.lastModifiedBy)) return false;
        if (!title.equals(shelter.title)) return false;
        if (description != null ? !description.equals(shelter.description) : shelter.description != null) return false;
        if (type != shelter.type) return false;
        if (event != null ? !event.equals(shelter.event) : shelter.event != null) return false;
        return tags != null ? tags.equals(shelter.tags) : shelter.tags == null;

    }

    @Override
    public int hashCode() {
        int result = avatarBytea != null ? avatarBytea.hashCode() : 0;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + status.hashCode();
        result = 31 * result + createdDate.hashCode();
        result = 31 * result + createdBy.hashCode();
        result = 31 * result + lastModifiedDate.hashCode();
        result = 31 * result + lastModifiedBy.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + type.hashCode();
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShelterImpl{" +
                "id=" + id +
                ", avatarBytea=" + avatarBytea +
                ", info=" + info +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", createdBy=" + createdBy +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastModifiedBy=" + lastModifiedBy +
                ", title='" + title + '\'' +
                ", description=" + description +
                ", type=" + type +
                ", event=" + event +
                ", tags=" + tags +
                '}';
    }
}
