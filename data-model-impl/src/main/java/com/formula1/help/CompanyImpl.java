package com.formula1.help;

import com.formula1.help.actor.Company;
import com.formula1.help.actor.CompanyStatus;
import com.formula1.help.actor.User;

import java.util.List;

/**
 * Created by alexey on 03.05.16.
 */
public class CompanyImpl implements Company {
    private final int id;
    private User createdUser;
    private String name;
    private List<String> webSite;
    private List<User> adminUsers;
    private List<User> members;
    private List<String> companyType;
    private CompanyStatus companyStatus;

    public CompanyImpl(int id) {
        this.id = id;
    }

    @Override
    public int getCompanyID() {
        return id;
    }

    @Override
    public User getCreatedUser() {
        return createdUser;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getWebSite() {
        return webSite;
    }

    @Override
    public List<User> getAdminUsers() {
        return adminUsers;
    }

    @Override
    public List<User> getMembers() {
        return members;
    }

    @Override
    public List<String> getCompanyType() {
        return companyType;
    }

    @Override
    public CompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    @Override
    public void setCreatedUser(User createdUser) {
        this.createdUser = createdUser;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setWebSite(List<String> webSite) {
        this.webSite = webSite;
    }

    @Override
    public void setAdminUsers(List<User> adminUsers) {
        this.adminUsers = adminUsers;
    }

    @Override
    public void setMembers(List<User> members) {
        this.members = members;
    }

    @Override
    public void setCompanyType(List<String> companyType) {
        this.companyType = companyType;
    }

    @Override
    public void setCompanyStatus(CompanyStatus companyStatus) {
        this.companyStatus = companyStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyImpl company = (CompanyImpl) o;

        if (id != company.id) return false;
        if (createdUser != null ? !createdUser.equals(company.createdUser) : company.createdUser != null) return false;
        if (name != null ? !name.equals(company.name) : company.name != null) return false;
        if (webSite != null ? !webSite.equals(company.webSite) : company.webSite != null) return false;
        if (adminUsers != null ? !adminUsers.equals(company.adminUsers) : company.adminUsers != null) return false;
        if (members != null ? !members.equals(company.members) : company.members != null) return false;
        if (companyType != null ? !companyType.equals(company.companyType) : company.companyType != null) return false;
        return companyStatus == company.companyStatus;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (createdUser != null ? createdUser.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (webSite != null ? webSite.hashCode() : 0);
        result = 31 * result + (adminUsers != null ? adminUsers.hashCode() : 0);
        result = 31 * result + (members != null ? members.hashCode() : 0);
        result = 31 * result + (companyType != null ? companyType.hashCode() : 0);
        result = 31 * result + (companyStatus != null ? companyStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CompanyImpl{" +
                "id=" + id +
                ", createdUser=" + createdUser +
                ", name='" + name + '\'' +
                ", webSite='" + webSite + '\'' +
                ", adminUsers=" + adminUsers +
                ", members=" + members +
                ", companyType=" + companyType +
                ", companyStatus=" + companyStatus +
                '}';
    }
}
