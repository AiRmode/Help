package com.provectus.prodobro.actor.shelter;


import java.util.List;


public interface Tag {

    int getId();

    String getTitle();

    List<Shelter> getShelters();

    void setId(int id);

    void setTitle(String title);

    void setShelters(List<Shelter> shelters);
}
