package com.provectus.prodobro.actor.user;

import com.provectus.prodobro.additional.info.Info;
import com.provectus.prodobro.additional.info.InfoType;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class UserInfo implements Info<User> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = UserImpl.class)
    @JoinColumn(name = "user_id")
    private User owner;

    @Column(name = "info")
    private String info;

    @OneToOne(targetEntity = UserInfoType.class)
    @JoinColumn(name = "info_type_id")
    private InfoType type;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public User getOwner() {
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
    public void setOwner(User owner) {
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", owner=" + owner.getId() +
                ", info='" + info + '\'' +
                ", type=" + type +
                '}';
    }
}
