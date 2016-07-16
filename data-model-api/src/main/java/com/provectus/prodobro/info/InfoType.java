package com.provectus.prodobro.info;


public enum InfoType {

    EMAIL(1),
    WEBSITE(2),
    IMAGE(3);

    private int id;

    InfoType(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
