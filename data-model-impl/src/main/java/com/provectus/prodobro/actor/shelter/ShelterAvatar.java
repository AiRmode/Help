package com.provectus.prodobro.actor.shelter;


import com.provectus.prodobro.shared.avatar.Avatar;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "shelter_avatar")
public class ShelterAvatar implements Avatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "avatar")
    private byte[] bytea;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public byte[] getBytea() {
        return bytea;
    }

    @Override
    public void setBytea(byte[] bytea) {
        this.bytea = bytea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShelterAvatar)) return false;

        ShelterAvatar that = (ShelterAvatar) o;

        return Arrays.equals(bytea, that.bytea);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytea);
    }
}
