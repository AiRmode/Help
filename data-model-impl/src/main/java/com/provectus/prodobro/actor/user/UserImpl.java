package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.ActorStatus;
import com.provectus.prodobro.event.Event;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class UserImpl implements User {

    private int id;
    private Optional<byte[]> avatarBytea;
    private List<Info> info;
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
    private Optional<CompanyRelation> companyRelation;
    private List<Event> userAssignedEvents;
    private List<Event> userCreatedEvents;

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
    public List<Info> getInfo() {
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
    public Optional<CompanyRelation> getCompanyRelation() {
        return this.companyRelation;
    }

    @Override
    public List<Event> getUserAssignedEvents() {
        return userAssignedEvents;
    }

    @Override
    public List<Event> getUserCreatedEvents() {
        return userCreatedEvents;
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
    public void setInfo(List<Info> info) {
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
    public void setCompanyRelation(CompanyRelation companyRelation) {
        this.companyRelation = Optional.ofNullable(companyRelation);
    }

    @Override
    public void setUserAssignedEvents(List<Event> userAssignedEvents) {
        this.userAssignedEvents = userAssignedEvents;
    }

    @Override
    public void setUserCreatedEvents(List<Event> userCreatedEvents) {
        this.userCreatedEvents = userCreatedEvents;
    }
}
