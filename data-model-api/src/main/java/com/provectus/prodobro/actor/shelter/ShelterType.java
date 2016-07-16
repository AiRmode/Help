package com.provectus.prodobro.actor.shelter;


public enum ShelterType {
    HUMAN(1),
    ANIMAL(2);

    private int id;

    ShelterType(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
