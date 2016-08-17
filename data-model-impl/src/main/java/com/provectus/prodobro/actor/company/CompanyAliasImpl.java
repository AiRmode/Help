package com.provectus.prodobro.actor.company;

import javax.persistence.*;

@Entity
@Table(name = "company_alias")
public class CompanyAliasImpl implements CompanyAlias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "alias")
    private String alias;

    @ManyToOne(targetEntity = CompanyImpl.class)
    @Column(name = "company_id")
    private Company company;


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public Company getCompany() {
        return company;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyAliasImpl)) return false;

        CompanyAliasImpl that = (CompanyAliasImpl) o;

        if (!alias.equals(that.alias)) return false;
        return company.equals(that.company);

    }

    @Override
    public int hashCode() {
        int result = alias.hashCode();
        result = 31 * result + company.hashCode();
        return result;
    }
}