package com.provectus.prodobro.actor.company;


import com.provectus.prodobro.actor.ActorStatus;
import com.provectus.prodobro.actor.user.CompanyRelation;
import com.provectus.prodobro.actor.user.CompanyRelationImpl;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.event.Event;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CompanyImpl implements Company {

    private int id;
    private Optional<byte[]> avatarBytea;
    private Set<Info> info;
    private ActorStatus status;
    private Timestamp createdDate;
    private User createdBy;
    private Timestamp lastModifiedDate;
    private User lastModifiedBy;

    private String title;
    private Set<String> aliases;
    private String description;
    private Set<User> users;
    private Set<User> admins;
    private Set<Event> assignedEvents;

    public CompanyImpl() {
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
    public Set<String> getAliases() {
        return aliases;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Set<User> getUsers() {
        return users;
    }

    @Override
    public Set<User> getAdmins() {
        return admins;
    }

    @Override
    public Set<Event> getAssignedEvents() {
        return assignedEvents;
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
    public void setAliases(Set<String> aliases) {
        this.aliases = aliases;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public void setAdmins(Set<User> admins) {
        this.admins = admins;
    }

    @Override
    public void setAssignedEvents(Set<Event> assignedEvents) {
        this.assignedEvents = assignedEvents;
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
    public void addUser(User user) {
        user.setCompanyRelation(new CompanyRelationImpl(
                this, // Adding company
                false // Adding isAdmin
        ));
        users.add(user);
    }

    @Override
    public void addAdmin(User admin) {
        admin.setCompanyRelation(new CompanyRelationImpl(
                this,
                true
        ));
        admins.add(admin);
    }

    @Override
    public void removeUser(User user) {
        users.remove(user);
    }

    @Override
    public void addAlias(String alias) {
        aliases.add(alias);
    }

    @Override
    public void removeAlias(String alias) {
        aliases.remove(alias);
    }

    @Override
    public void removeAdmin(User admin) {
        admins.remove(admin);
    }

    @Override
    public void addAssignedEvent(Event event) {
        assignedEvents.add(event);
    }

    @Override
    public void removeAssignedEvent(Event event) {
        assignedEvents.remove(event);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyImpl)) return false;

        CompanyImpl company = (CompanyImpl) o;

        if (avatarBytea != null ? !avatarBytea.equals(company.avatarBytea) : company.avatarBytea != null) return false;
        if (info != null ? !info.equals(company.info) : company.info != null) return false;
        if (status != company.status) return false;
        if (!createdDate.equals(company.createdDate)) return false;
        if (!createdBy.equals(company.createdBy)) return false;
        if (!lastModifiedDate.equals(company.lastModifiedDate)) return false;
        if (!lastModifiedBy.equals(company.lastModifiedBy)) return false;
        if (!title.equals(company.title)) return false;
        if (aliases != null ? !aliases.equals(company.aliases) : company.aliases != null) return false;
        if (description != null ? !description.equals(company.description) : company.description != null) return false;
        if (!users.equals(company.users)) return false;
        if (!admins.equals(company.admins)) return false;
        return assignedEvents != null ? assignedEvents.equals(company.assignedEvents) : company.assignedEvents == null;

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
        result = 31 * result + (aliases != null ? aliases.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + users.hashCode();
        result = 31 * result + admins.hashCode();
        result = 31 * result + (assignedEvents != null ? assignedEvents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CompanyImpl{" +
                "id=" + id +
                ", avatarBytea=" + avatarBytea +
                ", info=" + info +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", createdBy=" + createdBy +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastModifiedBy=" + lastModifiedBy +
                ", title='" + title + '\'' +
                ", aliases=" + aliases +
                ", description='" + description + '\'' +
                ", users=" + users +
                ", admins=" + admins +
                ", assignedEvents=" + assignedEvents +
                '}';
    }
}
