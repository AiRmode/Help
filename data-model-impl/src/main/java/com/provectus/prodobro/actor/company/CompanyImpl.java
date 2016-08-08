package com.provectus.prodobro.actor.company;


import com.provectus.prodobro.actor.EmployeeRelation;
import com.provectus.prodobro.actor.EmployeeRelationImpl;
import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.event.EventImpl;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import com.provectus.prodobro.additional.avatar.Avatar;
import com.provectus.prodobro.additional.info.Info;
import com.provectus.prodobro.additional.status.Status;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Entity
@Table(name = "company")
public class CompanyImpl implements Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = CompanyAvatar.class)
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", targetEntity = CompanyInfo.class)
    private Set<Info> info = new TreeSet<>();

    @OneToOne(cascade = CascadeType.ALL, targetEntity = CompanyStatus.class)
    @JoinColumn(name = "status_id")
    private Status status;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = UserImpl.class)
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @Column(name = "last_modified_date")
    private Timestamp lastModifiedDate;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = UserImpl.class)
    @JoinColumn(name = "last_modified_by_id")
    private User lastModifiedBy;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "company", targetEntity = CompanyAliasImpl.class)
    private Set<CompanyAlias> aliases = new TreeSet<>();

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "company", targetEntity = EmployeeRelationImpl.class)
    private Set<EmployeeRelation> employeeRelations = new TreeSet<>();

    @ManyToMany(targetEntity = EventImpl.class)
    @JoinTable(
            name = "company_event",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private Set<Event> assignedEvents = new TreeSet<>();

    public CompanyImpl() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Optional<Avatar> getAvatar() {
        return Optional.ofNullable(avatar);
    }

    @Override
    public Optional<byte[]> getAvatarBytea() {
        return Optional.ofNullable(avatar.getBytea());
    }

    @Override
    public Set<Info> getInfo() {
        return info;
    }

    @Override
    public Status getStatus() {
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
    public Set<CompanyAlias> getAliases() {
        return aliases;
    }

    @Override
    public Set<String> getStringAliases() {
        return aliases.stream().map(CompanyAlias::getAlias).collect(Collectors.toSet());
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
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    @Override
    public void setInfo(Set<Info> info) {
        this.info = info;
    }

    @Override
    public void setStatus(Status status) {
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
    public void setAliases(Set<CompanyAlias> aliases) {
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
    public void addAlias(CompanyAlias alias) {
        aliases.add(alias);
    }

    @Override
    public void removeAlias(CompanyAlias alias) {
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


}
