package com.provectus.prodobro.actor.user;


import com.provectus.prodobro.actor.company.Company;

public class CompanyRelationImpl implements CompanyRelation {

    private int id;
    private Company company;
    private boolean isAdmin;

    public CompanyRelationImpl() {
    }

    public CompanyRelationImpl(Company company, boolean isAdmin) {
        this.company = company;
        this.isAdmin = isAdmin;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Company getCompany() {
        return company;
    }

    @Override
    public boolean isAdmin() {
        return isAdmin;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CompanyRelationImpl)) return false;

        CompanyRelationImpl that = (CompanyRelationImpl) o;

        if (isAdmin != that.isAdmin) return false;
        return company.equals(that.company);

    }

    @Override
    public int hashCode() {
        int result = company.hashCode();
        result = 31 * result + (isAdmin ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CompanyRelationImpl{" +
                "id=" + id +
                ", company=" + company +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
