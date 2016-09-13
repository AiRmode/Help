package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.shared.status.Status;
import com.provectus.prodobro.shared.status.StatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "user_status")
public class UserStatus implements Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "title")
    private StatusEnum status;

    public UserStatus() {
    }

    public UserStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getStatus() {
        return status.name();
    }

    @Override
    public void setStatus(String status) {
        this.status = StatusEnum.valueOf(status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserStatus)) return false;

        UserStatus that = (UserStatus) o;

        return status == that.status;

    }

    @Override
    public int hashCode() {
        return status.hashCode();
    }
}
