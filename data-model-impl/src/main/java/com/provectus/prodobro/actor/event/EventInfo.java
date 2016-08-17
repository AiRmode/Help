package com.provectus.prodobro.actor.event;


import com.provectus.prodobro.shared.info.Info;
import com.provectus.prodobro.shared.info.InfoTypeEnum;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "info_type")
    private InfoTypeEnum type;

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
    public String getType() {
        return type.name();
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
    public void setType(String type) {
        this.type = InfoTypeEnum.valueOf(type);
    }

    @Override
    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventInfo)) return false;

        EventInfo eventInfo = (EventInfo) o;

        if (!owner.equals(eventInfo.owner)) return false;
        if (!info.equals(eventInfo.info)) return false;
        return type == eventInfo.type;

    }

    @Override
    public int hashCode() {
        int result = owner.hashCode();
        result = 31 * result + info.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
