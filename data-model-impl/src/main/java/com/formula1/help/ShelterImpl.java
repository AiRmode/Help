package com.formula1.help;

import com.formula1.help.actor.personalData.PersonalData;
import com.formula1.help.actor.shelter.Shelter;

import java.util.List;
import java.util.Set;

/**
 * Created by alexey on 03.05.16.
 */
public class ShelterImpl implements Shelter {
    private final int id;
    private String name;
    private String description;
    private List<String> tags;
    private List<String> assignedCategories;

    public ShelterImpl(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public void setTitle(String name) {
        this.name = name;
    }

    @Override
    public Set<String> getAlias() {
        return null;
    }

    @Override
    public void addAlias(String title) {

    }

    @Override
    public void removeAlias(String title) {

    }

    @Override
    public void setPersonalData(PersonalData personalData) {

    }

    @Override
    public PersonalData getPersonalData() {
        return null;
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
    public List<String> getTags() {
        return tags;
    }

    @Override
    public void getTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public List<String> getAssignedCategories() {
        return assignedCategories;
    }

    @Override
    public void setAssignedCategories(List<String> assignedCategories) {
        this.assignedCategories = assignedCategories;
    }


    //TODO:update
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShelterImpl that = (ShelterImpl) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        return !(assignedCategories != null ? !assignedCategories.equals(that.assignedCategories) : that.assignedCategories != null);
    }

    //TODO:update
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (assignedCategories != null ? assignedCategories.hashCode() : 0);
        return result;
    }

    //TODO:update
    @Override
    public String toString() {
        return "InNeedEntityImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", tags=" + tags +
                ", assignedCategories=" + assignedCategories +
                '}';
    }
}
