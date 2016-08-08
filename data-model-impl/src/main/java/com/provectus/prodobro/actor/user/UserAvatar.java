package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.additional.avatar.Avatar;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "user_avatar")
public class UserAvatar implements Avatar {

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

    @Override
    public String toString() {
        return "UserAvatar{" +
                "id=" + id +
                ", bytea=" + Arrays.toString(bytea) +
                '}';
    }
}
