package com.provectus.prodobro.actor.shelter;


import java.util.Set;


public interface Tag {

    Long getId();

    void setId(Long id);

    String getTitle();

    void setTitle(String title);

    Set<Shelter> getShelters();

    void setShelters(Set<Shelter> shelters);
}
