package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.additional.status.Status;
import com.provectus.prodobro.additional.status.StatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "user_status")
public class UserStatus implements Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "title")
    private StatusEnum status;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getStatus() {
        return status.name();
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setStatus(String status) {
        this.status = StatusEnum.valueOf(status);
    }

    @Override
    public String toString() {
        return "UserStatus{" +
                "id=" + id +
                ", status=" + status +
                '}';
    }
}
