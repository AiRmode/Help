package com.provectus.prodobro.actor.shelter;


import java.util.List;
import java.util.Set;


public interface Tag {

    int getId();

    String getTitle();

    Set<Shelter> getShelters();

    void setId(int id);

    void setTitle(String title);

    void setShelters(Set<Shelter> shelters);

    void addShelter(Shelter shelter);

    void removeShelter(Shelter shelter);
}
