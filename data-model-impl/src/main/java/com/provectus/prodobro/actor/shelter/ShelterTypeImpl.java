package com.provectus.prodobro.actor.shelter;


import javax.persistence.*;

@Entity
@Table(name = "shelter_type")
public class ShelterTypeImpl implements ShelterType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "title")
    private ShelterTypeEnum type;

    @Override
    public Long getId() {
        return id;
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
    public void setType(String type) {
        this.type = ShelterTypeEnum.valueOf(type);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShelterTypeImpl)) return false;

        ShelterTypeImpl that = (ShelterTypeImpl) o;

        return type == that.type;

    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }
}
