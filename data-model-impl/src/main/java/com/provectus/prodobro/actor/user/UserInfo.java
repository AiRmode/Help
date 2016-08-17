package com.provectus.prodobro.actor.user;

import com.provectus.prodobro.shared.info.Info;
import com.provectus.prodobro.shared.info.InfoTypeEnum;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "info_type")
    private InfoTypeEnum type;

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
    public String getType() {
        return type.name();
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
    public void setType(String type) {
        this.type = InfoTypeEnum.valueOf(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo)) return false;

        UserInfo userInfo = (UserInfo) o;

        if (!owner.equals(userInfo.owner)) return false;
        if (!info.equals(userInfo.info)) return false;
        return type == userInfo.type;

    }

    @Override
    public int hashCode() {
        int result = owner.hashCode();
        result = 31 * result + info.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
