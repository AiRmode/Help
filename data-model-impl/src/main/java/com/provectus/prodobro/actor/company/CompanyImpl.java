package com.provectus.prodobro.actor.company;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.event.EventImpl;
import com.provectus.prodobro.actor.relation.EmployeeRelation;
import com.provectus.prodobro.actor.relation.EmployeeRelationImpl;
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
import java.util.stream.Collectors;

@Entity
@Table(name = "company")
public class CompanyImpl implements Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = CompanyAvatar.class)
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "owner",
            targetEntity = CompanyInfo.class
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

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "company",
            targetEntity = CompanyAliasImpl.class
    )
    private Set<CompanyAlias> aliases = new HashSet<>();

    @Column(name = "description")
    private String description;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "company",
            targetEntity = EmployeeRelationImpl.class
    )
    private Set<EmployeeRelation> employeeRelations = new HashSet<>();

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "assignedCompanies",
            targetEntity = EventImpl.class
    )
    private Set<Event> assignedEvents = new HashSet<>();

    public CompanyImpl() {
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
    public Set<CompanyAlias> getAliases() {
        return aliases;
    }

    @Override
    public void setAliases(Set<CompanyAlias> aliases) {
        this.aliases = aliases;
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
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Set<EmployeeRelation> getEmployeeRelations() {
        return employeeRelations;
    }

    @Override
    public void setEmployeeRelations(Set<EmployeeRelation> employeeRelations) {
        this.employeeRelations = employeeRelations;
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
    public void setAssignedEvents(Set<Event> assignedEvents) {
        this.assignedEvents = assignedEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyImpl)) return false;

        CompanyImpl company = (CompanyImpl) o;

        if (!info.equals(company.info)) return false;
        if (statusCode != company.getStatusCode()) return false;
        if (!createdDate.equals(company.createdDate)) return false;
        if (!lastModifiedDate.equals(company.lastModifiedDate)) return false;
        if (!title.equals(company.title)) return false;
        if (!aliases.equals(company.aliases)) return false;
        return description != null ? description.equals(company.description) : company.description == null;

    }

    @Override
    public int hashCode() {
        int result = info.hashCode();
        result = 31 * result + statusCode;
        result = 31 * result + createdDate.hashCode();
        result = 31 * result + lastModifiedDate.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + aliases.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
