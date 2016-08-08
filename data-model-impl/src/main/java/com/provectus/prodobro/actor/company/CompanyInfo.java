package com.provectus.prodobro.actor.company;


import com.provectus.prodobro.additional.info.Info;
import com.provectus.prodobro.additional.info.InfoType;

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

    @OneToOne(targetEntity = CompanyInfoType.class)
    @JoinColumn(name = "info_type_id")
    private InfoType type;

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
    public InfoType getType() {
        return type;
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
    public void setType(InfoType type) {
        this.type = type;
    }
}
