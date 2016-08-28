package com.provectus.prodobro.actor.shelter;


import com.provectus.prodobro.shared.info.Info;
import com.provectus.prodobro.shared.info.InfoTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "shelter_info")
public class ShelterInfo implements Info<Shelter> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(targetEntity = ShelterImpl.class)
    @JoinColumn(name = "shelter_id")
    private Shelter owner;

    @Column(name = "info")
    private String info;

    @Enumerated(EnumType.STRING)
    @Column(name = "info_type")
    private InfoTypeEnum type;

    @Override
    public Long getId() {
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
    public String getType() {
        return type.name();
    }

    @Override
    public void setId(Long id) {
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
    public void setType(String type) {
        this.type = InfoTypeEnum.valueOf(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShelterInfo)) return false;

        ShelterInfo that = (ShelterInfo) o;

        if (!info.equals(that.info)) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = info.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
