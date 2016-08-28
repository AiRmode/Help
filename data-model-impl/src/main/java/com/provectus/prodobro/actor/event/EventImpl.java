package com.provectus.prodobro.actor.event;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.company.CompanyImpl;
import com.provectus.prodobro.actor.shelter.Shelter;
import com.provectus.prodobro.actor.shelter.ShelterImpl;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import com.provectus.prodobro.shared.avatar.Avatar;
import com.provectus.prodobro.shared.info.Info;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "event")
public class EventImpl implements Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "owner",
            targetEntity = EventInfo.class
    )
    private Set<Info> info = new HashSet<>();

    @Column(name = "description")
    private String description;

    @OneToOne(targetEntity = ShelterImpl.class)
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "is_accessible")
    private boolean accessible;

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

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = UserImpl.class
    )
    @JoinTable(
            name = "user_event",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> assignedUsers = new HashSet<>();

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            targetEntity = CompanyImpl.class
    )
    @JoinTable(
            name = "company_event",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "company_id")
    )
    private Set<Company> assignedCompanies = new HashSet<>();

    public EventImpl() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Optional<Avatar> getAvatar() {
        return shelter.getAvatar();
    }

    @Override
    public Set<Info> getInfo() {
        return info;
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
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
    public void setId(Long id) {
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
        this.description = description;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventImpl)) return false;

        EventImpl event = (EventImpl) o;

        if (accessible != event.accessible) return false;
        if (!title.equals(event.title)) return false;
        if (!info.equals(event.info)) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (!date.equals(event.date)) return false;
        if (!createdDate.equals(event.createdDate)) return false;
        return lastModifiedDate.equals(event.lastModifiedDate);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + info.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + date.hashCode();
        result = 31 * result + (accessible ? 1 : 0);
        result = 31 * result + createdDate.hashCode();
        result = 31 * result + lastModifiedDate.hashCode();
        return result;
    }
}
