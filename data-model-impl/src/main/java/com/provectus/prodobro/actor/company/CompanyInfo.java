package com.provectus.prodobro.actor.company;


import com.provectus.prodobro.shared.info.Info;
import com.provectus.prodobro.shared.info.InfoTypeEnum;

import javax.persistence.*;

@Entity
@Table(name = "company_info")
public class CompanyInfo implements Info<Company> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(targetEntity = CompanyImpl.class)
    @JoinColumn(name = "company_id")
    private Company owner;

    @Column(name = "info")
    private String info;

    @Enumerated(EnumType.STRING)
    @Column(name = "info_type")
    private InfoTypeEnum type;

    public CompanyInfo() {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Company getOwner() {
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
    public void setOwner(Company owner) {
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
        if (!(o instanceof CompanyInfo)) return false;

        CompanyInfo that = (CompanyInfo) o;

        if (!owner.equals(that.owner)) return false;
        if (!info.equals(that.info)) return false;
        return type == that.type;

    }

    @Override
    public int hashCode() {
        int result = owner.hashCode();
        result = 31 * result + info.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
