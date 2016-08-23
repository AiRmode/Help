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
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "title")
    private StatusEnum status;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getStatus() {
        return status.name();
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void setStatus(String status) {
        this.status = StatusEnum.valueOf(status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShelterStatus)) return false;

        ShelterStatus that = (ShelterStatus) o;

        return status == that.status;

    }

    @Override
    public int hashCode() {
        return status.hashCode();
    }
}

