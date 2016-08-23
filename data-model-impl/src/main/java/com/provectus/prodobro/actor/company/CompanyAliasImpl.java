package com.provectus.prodobro.actor.company;

import javax.persistence.*;

@Entity
@Table(name = "company_alias")
public class CompanyAliasImpl implements CompanyAlias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "alias")
    private String alias;

    @ManyToOne(targetEntity = CompanyImpl.class)
    @JoinColumn(name = "company_id")
    private Company company;


    @Override
    public Long getId() {
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
    public void setId(Long id) {
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

        return alias.equals(that.alias);

    }

    @Override
    public int hashCode() {
        return alias.hashCode();
    }
}
