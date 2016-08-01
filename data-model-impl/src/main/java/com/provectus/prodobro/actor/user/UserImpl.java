package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.ActorStatus;
import com.provectus.prodobro.actor.EmployeeRelation;
import com.provectus.prodobro.event.Event;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class UserImpl implements User {

    private int id;
    private Optional<byte[]> avatarBytea;
    private Set<Info> info = new TreeSet<>();
    private ActorStatus status;
    private Timestamp createdDate;
    private User createdBy;
    private Timestamp lastModifiedDate;
    private User lastModifiedBy;

    private String firstName;
    private String lastName;
    private String email;
    private String passHash;
    private String phoneNumber;
    private Locale language;
    private Optional<EmployeeRelation> employeeRelation;
    private Set<Event> asignedEvents = new TreeSet<>();
    private Set<Event> createdEvents = new TreeSet<>();

    public UserImpl() {
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
        return this.employeeRelation;
    }

    @Override
    public Set<Event> getAssignedEvents() {
        return asignedEvents;
    }

    @Override
    public Set<Event> getCreatedEvents() {
        return createdEvents;
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
        this.employeeRelation = Optional.ofNullable(employeeRelation);
    }

    @Override
    public void setAssignedEvents(Set<Event> assignedEvents) {
        this.asignedEvents = assignedEvents;
    }

    @Override
    public void setCreatedEvents(Set<Event> createdEvents) {
        this.createdEvents = createdEvents;
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
        asignedEvents.add(event);
    }

    @Override
    public void removeAssignedEvent(Event event) {
        asignedEvents.remove(event);
    }

    @Override
    public void addCreatedEvent(Event event) {
        createdEvents.add(event);
    }

    @Override
    public void removeCreatedEvent(Event event) {
        createdEvents.remove(event);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserImpl)) return false;

        UserImpl user = (UserImpl) o;

        if (avatarBytea != null ? !avatarBytea.equals(user.avatarBytea) : user.avatarBytea != null) return false;
        if (info != null ? !info.equals(user.info) : user.info != null) return false;
        if (status != user.status) return false;
        if (!createdDate.equals(user.createdDate)) return false;
        if (!createdBy.equals(user.createdBy)) return false;
        if (!lastModifiedDate.equals(user.lastModifiedDate)) return false;
        if (!lastModifiedBy.equals(user.lastModifiedBy)) return false;
        if (!firstName.equals(user.firstName)) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (!email.equals(user.email)) return false;
        if (!passHash.equals(user.passHash)) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (!language.equals(user.language)) return false;
        if (employeeRelation != null ? !employeeRelation.equals(user.employeeRelation) : user.employeeRelation != null)
            return false;
        if (asignedEvents != null ? !asignedEvents.equals(user.asignedEvents) : user.asignedEvents != null)
            return false;
        return createdEvents != null ? createdEvents.equals(user.createdEvents) : user.createdEvents == null;

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
        result = 31 * result + firstName.hashCode();
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + email.hashCode();
        result = 31 * result + passHash.hashCode();
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + language.hashCode();
        result = 31 * result + (employeeRelation != null ? employeeRelation.hashCode() : 0);
        result = 31 * result + (asignedEvents != null ? asignedEvents.hashCode() : 0);
        result = 31 * result + (createdEvents != null ? createdEvents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserImpl{" +
                "id=" + id +
                ", avatarBytea=" + avatarBytea +
                ", info=" + info +
                ", status=" + status +
                ", createdDate=" + createdDate +
                ", createdBy=" + createdBy +
                ", lastModifiedDate=" + lastModifiedDate +
                ", lastModifiedBy=" + lastModifiedBy +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passHash='" + passHash + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", language=" + language +
                ", employeeRelation=" + employeeRelation +
                ", asignedEvents=" + asignedEvents +
                ", createdEvents=" + createdEvents +
                '}';
    }
}
