package com.provectus.prodobro.additional.status;


public enum StatusEnum {
    BANNED(-2),
    DELETED(-1),
    NOT_VERIFIED(0),
    ACTIVE(1);

    private int id;

    StatusEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
