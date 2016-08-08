package com.provectus.prodobro.actor.shelter;


import com.provectus.prodobro.additional.info.Info;
import com.provectus.prodobro.additional.info.InfoType;

import javax.persistence.*;

@Entity
@Table(name = "shelter_info")
public class ShelterInfo implements Info<Shelter> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = ShelterImpl.class)
    @JoinColumn(name = "shelter_id")
    private Shelter owner;

    @Column(name = "info")
    private String info;

    @OneToOne(targetEntity = ShelterInfoType.class)
    @JoinColumn(name = "info_type_id")
    private InfoType type;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Shelter getOwner() {
        return owner;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public InfoType getType() {
        return type;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setOwner(Shelter owner) {
        this.owner = owner;
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public void setType(InfoType type) {
        this.type = type;
    }
}
