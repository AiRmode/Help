package com.provectus.prodobro.actor.relation;


import com.provectus.prodobro.actor.company.Company;
import com.provectus.prodobro.actor.company.CompanyImpl;
import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;

import javax.persistence.*;

@Entity
@Table(name = "company_user")
public class EmployeeRelationImpl implements EmployeeRelation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = UserImpl.class)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(targetEntity = CompanyImpl.class)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "is_admin")
    private boolean isAdmin;

    public EmployeeRelationImpl() {
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

    @Override
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
