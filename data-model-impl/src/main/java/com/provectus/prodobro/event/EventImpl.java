package com.provectus.prodobro.event;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class EventImpl implements Event {

    private int id;
    private String title;
    private Set<Info> info;
    private Optional<String> description;
    private Shelter shelter;
    private Timestamp date;
    private boolean accessible;
    private Timestamp createdDate;
    private User createdBy;
    private Timestamp lastModifiedDate;
    private User lastModifiedBy;
    private Set<User> assignedUsers;
    private Set<Company> assignedCompanies;

    public EventImpl() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Set<Info> getInfo() {
        return info;
    }

    @Override
    public Optional<String> getDescription() {
        return description;
    }

    @Override
    public Shelter getShelter() {
        return shelter;
    }

    @Override
    public Timestamp getDate() {
        return date;
    }

    @Override
    public boolean isAccessible() {
        return accessible;
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
    public Set<User> getAssignedUsers() {
        return assignedUsers;
    }

    @Override
    public Set<Company> getAssignedCompanies() {
        return assignedCompanies;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setInfo(Set<Info> info) {
        this.info = info;
    }

    @Override
    public void setDescription(String description) {
        this.description = Optional.ofNullable(description);
    }

    @Override
    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    @Override
    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
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
    public void setAssignedUsers(Set<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    @Override
    public void setAssignedCompanies(Set<Company> assignedCompanies) {
        this.assignedCompanies = assignedCompanies;
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
    public void addAssignedUser(User user) {
        assignedUsers.add(user);
    }

    @Override
    public void removeAssignedUser(User user) {
        assignedUsers.remove(user);
    }

    @Override
    public void addAssignedCompany(Company company) {
        assignedCompanies.add(company);
    }

    @Override
    public void removeAssignedCompany(Company company) {
        assignedCompanies.remove(company);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventImpl)) return false;

        EventImpl event = (EventImpl) o;

        if (accessible != event.accessible) return false;
        if (!title.equals(event.title)) return false;
        if (info != null ? !info.equals(event.info) : event.info != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (!shelter.equals(event.shelter)) return false;
        if (!date.equals(event.date)) return false;
        if (!createdDate.equals(event.createdDate)) return false;
        if (!createdBy.equals(event.createdBy)) return false;
        if (!lastModifiedDate.equals(event.lastModifiedDate)) return false;
        if (!lastModifiedBy.equals(event.lastModifiedBy)) return false;
        if (assignedUsers != null ? !assignedUsers.equals(event.assignedUsers) : event.assignedUsers != null)
            return false;
        return assignedCompanies != null ? assignedCompanies.equals(event.assignedCompanies) : event.assignedCompanies == null;

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (info != null ? info.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + shelter.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + (accessible ? 1 : 0);
        result = 31 * result + createdDate.hashCode();
        result = 31 * result + createdBy.hashCode();
        result = 31 * result + lastModifiedDate.hashCode();
        result = 31 * result + lastModifiedBy.hashCode();
        result = 31 * result + (assignedUsers != null ? assignedUsers.hashCode() : 0);
        result = 31 * result + (assignedCompanies != null ? assignedCompanies.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EventImpl{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", info=" + info +
                ", description=" + description +
                ", shelter=" + shelter +
                ", date=" + date +
                ", accessible=" + accessible +
                ", createdDate=" + createdDate +
                ", createdBy=" + createdBy +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastModifiedBy=" + lastModifiedBy +
                ", assignedUsers=" + assignedUsers +
                ", assignedCompanies=" + assignedCompanies +
                '}';
    }
}
