package com.provectus.prodobro.actor.shelter;


import java.util.List;

public class TagImpl implements Tag {

    private int id;
    private String title;
    private List<Shelter> shelters;

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
    public List<Shelter> getShelters() {
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
    public void setShelters(List<Shelter> shelters) {
        this.shelters = shelters;
    }
}
