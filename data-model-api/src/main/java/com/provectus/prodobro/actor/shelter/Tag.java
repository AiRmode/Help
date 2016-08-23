package com.provectus.prodobro.actor.shelter;


import java.util.Set;


public interface Tag {

    Long getId();

    String getTitle();

    Set<Shelter> getShelters();

    void setId(Long id);

    void setTitle(String title);

    void setShelters(Set<Shelter> shelters);
}
