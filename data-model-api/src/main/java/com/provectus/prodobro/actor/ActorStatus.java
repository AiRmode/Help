package com.provectus.prodobro.actor;


public enum ActorStatus {
    BANNED(-2),
    DELETED(-1),
    NOT_VERIFIED(0),
    ACTIVE(1);

    private int id;

    ActorStatus(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
