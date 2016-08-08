package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.EmployeeRelation;
import com.provectus.prodobro.actor.EmployeeRelationImpl;
import com.provectus.prodobro.actor.event.Event;
import com.provectus.prodobro.actor.event.EventImpl;
import com.provectus.prodobro.additional.avatar.Avatar;
import com.provectus.prodobro.additional.info.Info;
import com.provectus.prodobro.additional.status.Status;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "owner", targetEntity = UserInfo.class)
    private Set<Info> info = new TreeSet<>();

    @OneToOne(cascade = CascadeType.ALL, targetEntity = UserStatus.class)
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

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "pass_hash")
    private String passHash;

    @Column(name = "phone_num")
    private String phoneNumber;

    @Column(name = "locale_lang")
    private Locale language;

    @OneToOne(mappedBy = "user", targetEntity = EmployeeRelationImpl.class)
    private EmployeeRelation employeeRelation;

    @ManyToMany(targetEntity = EventImpl.class)
    @JoinTable(
            name = "user_event",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private Set<Event> assignedEvents = new TreeSet<>();

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
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
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
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public void addInfo(Info info) {
        this.info.add(info);
    }

    @Override
    public void removeInfo(Info info) {
        this.info.remove(info);
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
    public String toString() {
        return "UserImpl{" +
                "id=" + id +
                ", avatar=" + avatar +
                ", status=" + status +
                ", info=" + info +
                ", createdDate=" + createdDate +
                ", createdBy=" + createdBy.getId() +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastModifiedBy=" + lastModifiedBy.getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passHash='" + passHash + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", language=" + language +
                ", employeeRelation=" + employeeRelation +
                ", assignedEvents=" + assignedEvents +
                '}';
    }
}
