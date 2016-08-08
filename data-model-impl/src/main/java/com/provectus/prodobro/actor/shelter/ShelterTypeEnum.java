package com.provectus.prodobro.actor.shelter;


public enum ShelterTypeEnum {
    HUMAN(1),
    ANIMAL(2);

    private int id;

    ShelterTypeEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
