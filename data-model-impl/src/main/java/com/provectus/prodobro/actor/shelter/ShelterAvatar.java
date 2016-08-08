package com.provectus.prodobro.actor.shelter;


import com.provectus.prodobro.additional.avatar.Avatar;

import javax.persistence.*;

@Entity
@Table(name = "shelter_avatar")
public class ShelterAvatar implements Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "avatar")
    private byte[] bytea;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public byte[] getBytea() {
        return bytea;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setBytea(byte[] bytea) {
        this.bytea = bytea;
    }
}
