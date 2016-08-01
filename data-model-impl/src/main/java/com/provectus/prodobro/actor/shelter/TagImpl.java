package com.provectus.prodobro.actor.shelter;


import java.util.List;
import java.util.Set;

public class TagImpl implements Tag {

    private int id;
    private String title;
    private Set<Shelter> shelters;

    public TagImpl() {
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
    public Set<Shelter> getShelters() {
        return shelters;
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
    public void setShelters(Set<Shelter> shelters) {
        this.shelters = shelters;
    }

    @Override
    public void addShelter(Shelter shelter) {
        shelters.add(shelter);
    }

    @Override
    public void removeShelter(Shelter shelter) {
        shelters.remove(shelter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TagImpl)) return false;

        TagImpl tag = (TagImpl) o;

        if (!title.equals(tag.title)) return false;
        return shelters != null ? shelters.equals(tag.shelters) : tag.shelters == null;

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (shelters != null ? shelters.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TagImpl{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shelters=" + shelters +
                '}';
    }
}
