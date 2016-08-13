package com.provectus.prodobro.actor.shelter;


import com.provectus.prodobro.shared.status.Status;
import com.provectus.prodobro.shared.status.StatusEnum;

import javax.persistence.*;


@Entity
@Table(name = "shelter_status")
public class ShelterStatus implements Status {

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

