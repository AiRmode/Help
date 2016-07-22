package com.provectus.prodobro.actor.company;


import com.provectus.prodobro.actor.ActorStatus;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.event.Event;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.List;

public class CompanyImpl implements Company {

    private int id;
    private byte[] avatarBytea;
    private List<Info> info;
    private ActorStatus status;
    private Timestamp createdDate;
    private User createdBy;
    private Timestamp lastModifiedDate;
    private User lastModifiedBy;

    private String title;
    private List<String> alias;
    private String description;
    private List<User> users;
    private List<Event> companyAssignedEvents;

    public CompanyImpl(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public byte[] getAvatarBytea() {
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
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getAlias() {
        return alias;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public List<Event> getCompanyAssignedEvents() {
        return companyAssignedEvents;
    }

    @Override
    public void setAvatarBytea(byte[] avatarBytea) {
        this.avatarBytea = avatarBytea;
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
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public void setCompanyAssignedEvents(List<Event> companyAssignedEvents) {
        this.companyAssignedEvents = companyAssignedEvents;
    }
}
