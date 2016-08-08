package com.provectus.prodobro.actor.event;


import com.provectus.prodobro.actor.shelter.ShelterInfoType;
import com.provectus.prodobro.additional.info.Info;
import com.provectus.prodobro.additional.info.InfoType;

import javax.persistence.*;

@Entity
@Table(name = "event_info")
public class EventInfo implements Info<Event> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = EventImpl.class)
    @JoinColumn(name = "event_id")
    private Event owner;

    @Column(name = "info")
    private String info;

    @OneToOne(targetEntity = ShelterInfoType.class)
    @JoinColumn(name = "info_type_id")
    private InfoType type;

    public EventInfo() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Event getOwner() {
        return owner;
    }

    @Override
    public InfoType getType() {
        return type;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setOwner(Event owner) {
        this.owner = owner;
    }

    @Override
    public void setType(InfoType type) {
        this.type = type;
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
    }

}
