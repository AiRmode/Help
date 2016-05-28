package com.formula1.help;

import com.formula1.help.actor.company.Company;
import com.formula1.help.actor.company.CompanyStatus;
import com.formula1.help.actor.personalData.PersonalData;
import com.formula1.help.actor.user.User;

import java.util.Set;

/**
 * Created by alexey on 03.05.16.
 */
public class CompanyImpl implements Company {
    private final int id;
    private User createdUser;
    private Set<String> aliases;
    private Set<String> webSite;
    private Set<User> adminUsers;
    private Set<User> members;
    private Set<String> companyType;
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
    public String getTitle() {
        return null;
    }

    @Override
    public void setTitle(String title) {

    }

    @Override
    public Set<String> getAliases() {
        return aliases;
    }

    @Override
    public void addAlias(String title) {

    }

    @Override
    public void removeAlias(String title) {

    }

    @Override
    public Set<String> getWebSite() {
        return webSite;
    }

    @Override
    public void addWebSite(String webSite) {

    }

    @Override
    public void removeWebSite(String webSite) {

    }

    @Override
    public Set<User> getCompanyAdminUsers() {
        return adminUsers;
    }

    @Override
    public Set<User> getMembers() {
        return members;
    }

    @Override
    public Set<String> getCompanyType() {
        return companyType;
    }

    @Override
    public CompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    @Override
    public PersonalData getPersonalData() {
        return null;
    }

    @Override
    public void addAdminUser(User adminUser) {

    }

    @Override
    public void addMember(User member) {

    }

    @Override
    public void removeAdminUser(User adminUser) {

    }

    @Override
    public void removeMemberUser(User user) {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyImpl company = (CompanyImpl) o;

        if (id != company.id) return false;
        if (createdUser != null ? !createdUser.equals(company.createdUser) : company.createdUser != null) return false;
        if (aliases != null ? !aliases.equals(company.aliases) : company.aliases != null) return false;
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
        result = 31 * result + (aliases != null ? aliases.hashCode() : 0);
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
                ", aliases='" + aliases + '\'' +
                ", webSite='" + webSite + '\'' +
                ", adminUsers=" + adminUsers +
                ", members=" + members +
                ", companyType=" + companyType +
                ", companyStatus=" + companyStatus +
                '}';
    }
}
