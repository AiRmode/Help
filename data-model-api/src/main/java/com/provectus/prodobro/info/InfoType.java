package com.provectus.prodobro.info;


public enum InfoType {

    EMAIL(1),
    SKYPE(2),
    PHONE_NUMBER(3),
    WEBSITE(4),
    IMAGE(5);

    private int id;

    InfoType(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
