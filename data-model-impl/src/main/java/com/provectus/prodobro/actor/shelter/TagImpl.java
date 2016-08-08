package com.provectus.prodobro.actor.shelter;


import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "tag")
public class TagImpl implements Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToMany(targetEntity = ShelterImpl.class)
    @JoinTable(
            name = "shelter_tag",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "shelter_id")
    )
    private Set<Shelter> shelters = new TreeSet<>();

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
        return shelters.equals(tag.shelters);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + shelters.hashCode();
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
