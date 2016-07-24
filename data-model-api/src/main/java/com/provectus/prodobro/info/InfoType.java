package com.provectus.prodobro.info;


public enum InfoType {

    EMAIL(1),
    SKYPE(2),
    WEBSITE(3),
    PHONE_NUMBER(4),
    IMAGE(5);

    private int id;

    InfoType(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
