package com.provectus.prodobro.actor.shelter;


import java.util.List;


public interface Tag {

    int getId();

    String getTitle();

    List<Shelter> getShelters();

    void setTitle(String title);

    void setShelters(List<Shelter> shelters);
}
