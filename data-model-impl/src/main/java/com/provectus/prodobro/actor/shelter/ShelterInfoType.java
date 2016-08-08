package com.provectus.prodobro.actor.shelter;

import com.provectus.prodobro.additional.info.InfoType;
import com.provectus.prodobro.additional.info.InfoTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "shelter_info_type")
public class ShelterInfoType implements InfoType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private InfoTypeEnum type;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getType() {
        return type.name();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setType(String type) {
        this.type = InfoTypeEnum.valueOf(type);
    }

    @Override
    public String toString() {
        return type.name();
    }


}