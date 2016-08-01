package com.provectus.prodobro.actor;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.user.User;

public class EmployeeRelationImpl implements EmployeeRelation {

    private int id;
    private User user;
    private Company company;
    private boolean isAdmin;

    public EmployeeRelationImpl() {
    }

    public EmployeeRelationImpl(int id, User user, Company company, boolean isAdmin) {
        this.id = id;
        this.user = user;
        this.company = company;
        this.isAdmin = isAdmin;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public User getUser() {
        return user;
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
    public void setUser(User user) {
        this.user = user;
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
        if (!(o instanceof EmployeeRelationImpl)) return false;

        EmployeeRelationImpl that = (EmployeeRelationImpl) o;

        if (isAdmin != that.isAdmin) return false;
        if (!user.equals(that.user)) return false;
        return company.equals(that.company);

    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + company.hashCode();
        result = 31 * result + (isAdmin ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeRelationImpl{" +
                "id=" + id +
                ", user=" + user +
                ", company=" + company +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
