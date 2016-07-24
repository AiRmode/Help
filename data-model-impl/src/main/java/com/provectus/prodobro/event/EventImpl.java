package com.provectus.prodobro.event;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.info.Info;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class EventImpl implements Event {

    private int id;
    private String title;
    private List<Info> info;
    private Optional<String> description;
    private Shelter shelter;
    private Timestamp date;
    private boolean accessible;
    private Timestamp createdDate;
    private User createdBy;
    private Timestamp lastModifiedDate;
    private User lastModifiedBy;
    private List<User> assignedUsers;
    private List<Company> assignedCompanies;

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
    public List<Info> getInfo() {
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
    public List<User> getAssignedUsers() {
        return assignedUsers;
    }

    @Override
    public List<Company> getAssignedCompanies() {
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
    public void setInfo(List<Info> info) {
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
    public void setAssignedUsers(List<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }

    @Override
    public void setAssignedCompanies(List<Company> assignedCompanies) {
        this.assignedCompanies = assignedCompanies;
    }
}
