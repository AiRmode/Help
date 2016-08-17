package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.event.EventImpl;
import com.provectus.prodobro.actor.relation.EmployeeRelation;
import com.provectus.prodobro.actor.relation.EmployeeRelationImpl;
import com.provectus.prodobro.shared.avatar.Avatar;
import com.provectus.prodobro.shared.info.Info;
import com.provectus.prodobro.shared.status.Status;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
public class UserImpl implements User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = UserAvatar.class)
    @JoinColumn(name = "avatar_id")
    private Avatar avatar;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "owner",
            targetEntity = UserInfo.class
    )
    private Set<Info> info = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, targetEntity = UserStatus.class)
    @JoinColumn(name = "status_id")
    private Status status;

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

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "pass_hash")
    private String passHash;

    @Column(name = "phone_num")
    private String phoneNumber;

    @Column(name = "locale_lang")
    private Locale language;

    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "user",
            targetEntity = EmployeeRelationImpl.class
    )
    private EmployeeRelation employeeRelation;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "assignedUsers",
            targetEntity = EventImpl.class
    )
    private Set<Event> assignedEvents = new HashSet<>();

    public UserImpl() {
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
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassHash() {
        return passHash;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public Locale getLanguage() {
        return language;
    }

    @Override
    public Optional<EmployeeRelation> getEmployeeRelation() {
        return Optional.ofNullable(employeeRelation);
    }

    @Override
    public Set<Event> getAssignedEvents() {
        return assignedEvents;
    }

    @Override
    public Set<Event> getCreatedEvents() {
        return assignedEvents.stream().filter(
                line -> line.getShelter()
                        .getCreatedBy()
                        .equals(this)
        ).collect(Collectors.toSet());
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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setLanguage(Locale language) {
        this.language = language;
    }

    @Override
    public void setEmployeeRelation(EmployeeRelation employeeRelation) {
        this.employeeRelation = employeeRelation;
    }

    @Override
    public void setAssignedEvents(Set<Event> assignedEvents) {
        this.assignedEvents = assignedEvents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserImpl)) return false;

        UserImpl user = (UserImpl) o;

        if (avatar != null ? !avatar.equals(user.avatar) : user.avatar != null) return false;
        if (!info.equals(user.info)) return false;
        if (!status.equals(user.status)) return false;
        if (!createdDate.equals(user.createdDate)) return false;
        if (!createdBy.equals(user.createdBy)) return false;
        if (!lastModifiedDate.equals(user.lastModifiedDate)) return false;
        if (!lastModifiedBy.equals(user.lastModifiedBy)) return false;
        if (!name.equals(user.name)) return false;
        if (!email.equals(user.email)) return false;
        if (!passHash.equals(user.passHash)) return false;
        if (!phoneNumber.equals(user.phoneNumber)) return false;
        if (!language.equals(user.language)) return false;
        if (employeeRelation != null ? !employeeRelation.equals(user.employeeRelation) : user.employeeRelation != null)
            return false;
        return assignedEvents.equals(user.assignedEvents);

    }

    @Override
    public int hashCode() {
        int result = avatar != null ? avatar.hashCode() : 0;
        result = 31 * result + info.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + createdDate.hashCode();
        result = 31 * result + createdBy.hashCode();
        result = 31 * result + lastModifiedDate.hashCode();
        result = 31 * result + lastModifiedBy.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + passHash.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + language.hashCode();
        result = 31 * result + (employeeRelation != null ? employeeRelation.hashCode() : 0);
        result = 31 * result + assignedEvents.hashCode();
        return result;
    }
}
