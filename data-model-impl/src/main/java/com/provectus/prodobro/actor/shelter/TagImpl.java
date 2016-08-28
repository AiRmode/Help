package com.provectus.prodobro.actor.shelter;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tag")
public class TagImpl implements Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "tags",
            targetEntity = ShelterImpl.class
    )
    private Set<Shelter> shelters = new HashSet<>();

    public TagImpl() {
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
    public Set<Shelter> getShelters() {
        return shelters;
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
    public void setShelters(Set<Shelter> shelters) {
        this.shelters = shelters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TagImpl)) return false;

        TagImpl tag = (TagImpl) o;

        return title.equals(tag.title);

    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
