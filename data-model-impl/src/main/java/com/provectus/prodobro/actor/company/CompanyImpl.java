package com.provectus.prodobro.actor.company;


import com.provectus.prodobro.actor.ActorStatus;
import com.provectus.prodobro.actor.EmployeeRelation;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.event.Event;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CompanyImpl implements Company {

    private int id;
    private byte[] avatarBytea;
    private Set<Info> info = new TreeSet<>();
    private ActorStatus status;
    private Timestamp createdDate;
    private User createdBy;
    private Timestamp lastModifiedDate;
    private User lastModifiedBy;

    private String title;
    private Set<String> aliases = new TreeSet<>();
    private String description;
    private Set<EmployeeRelation> employeeRelations = new TreeSet<>();
    private Set<Event> assignedEvents = new TreeSet<>();

    public CompanyImpl() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Optional<byte[]> getAvatarBytea() {
        return Optional.ofNullable(avatarBytea);
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
    public Set<EmployeeRelation> getEmployeeRelations() {
        return employeeRelations;
    }

    @Override
    public Set<User> getUsers() {
        return employeeRelations.stream()
                .map(EmployeeRelation::getUser)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<User> getAdmins() {
        return employeeRelations.stream()
                .filter(EmployeeRelation::isAdmin)
                .map(EmployeeRelation::getUser)
                .collect(Collectors.toSet());
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
        this.avatarBytea = avatarBytea;
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
    public void setEmployeeRelations(Set<EmployeeRelation> employeeRelations) {
        this.employeeRelations = employeeRelations;
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
    public void addAlias(String alias) {
        aliases.add(alias);
    }

    @Override
    public void removeAlias(String alias) {
        aliases.remove(alias);
    }

    @Override
    public void addEmployeeRelation(EmployeeRelation employeeRelation) {
        employeeRelations.add(employeeRelation);
    }

    @Override
    public void removeEmployeeRelation(EmployeeRelation employeeRelation) {
        employeeRelations.remove(employeeRelation);
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

        if (!Arrays.equals(avatarBytea, company.avatarBytea)) return false;
        if (!info.equals(company.info)) return false;
        if (status != company.status) return false;
        if (!createdDate.equals(company.createdDate)) return false;
        if (!createdBy.equals(company.createdBy)) return false;
        if (!lastModifiedDate.equals(company.lastModifiedDate)) return false;
        if (!lastModifiedBy.equals(company.lastModifiedBy)) return false;
        if (!title.equals(company.title)) return false;
        if (!aliases.equals(company.aliases)) return false;
        if (description != null ? !description.equals(company.description) : company.description != null) return false;
        if (!employeeRelations.equals(company.employeeRelations)) return false;
        return assignedEvents.equals(company.assignedEvents);

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(avatarBytea);
        result = 31 * result + info.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + createdDate.hashCode();
        result = 31 * result + createdBy.hashCode();
        result = 31 * result + lastModifiedDate.hashCode();
        result = 31 * result + lastModifiedBy.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + aliases.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + employeeRelations.hashCode();
        result = 31 * result + assignedEvents.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CompanyImpl{" +
                "id=" + id +
                ", avatarBytea=" + Arrays.toString(avatarBytea) +
                ", info=" + info +
                ", status=" + status.name() +
                ", createdDate=" + createdDate +
                ", createdBy=" + createdBy +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastModifiedBy=" + lastModifiedBy +
                ", title='" + title + '\'' +
                ", aliases=" + aliases +
                ", description='" + description + '\'' +
                ", employeeRelations=" + employeeRelations +
                ", assignedEvents=" + assignedEvents +
                '}';
    }
}
