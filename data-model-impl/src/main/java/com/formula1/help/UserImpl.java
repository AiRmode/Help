package com.formula1.help;

import com.formula1.help.actors.Company;
import com.formula1.help.actors.User;
import com.formula1.help.actors.UserStatus;

import java.util.List;

/**
 * Created by alexey on 03.05.16.
 */
public class UserImpl implements User {
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int phoneNumber;
    private String avatarRef;
    private List<Company> userAssignedCompanies;
    private List<Company> userIsAdminCompanies;
    private UserStatus userStatus;

    public UserImpl(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getFullPhoneNumber() {
        return "+" + String.valueOf(getPhoneNumber());
    }

    @Override
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * return first and last name with single space separator
     *
     * @return
     */
    @Override
    public String getFirstLastName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String getAvatarRef() {
        return avatarRef;
    }

    @Override
    public List<Company> getUserAssignedCompanies() {
        return userAssignedCompanies;
    }

    @Override
    public List<Company> getUserIsAdminCompanies() {
        return userIsAdminCompanies;
    }

    @Override
    public UserStatus getUserStatus() {
        return userStatus;
    }

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void setAvatarRef(String avatarRef) {
        this.avatarRef = avatarRef;
    }

    @Override
    public void setUserAssignedCompanies(List<Company> userAssignedCompanies) {
        this.userAssignedCompanies = userAssignedCompanies;
    }

    @Override
    public void setUserIsAdminCompanies(List<Company> userIsAdminCompanies) {
        this.userIsAdminCompanies = userIsAdminCompanies;
    }

    @Override
    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserImpl user = (UserImpl) o;

        if (id != user.id) return false;
        if (phoneNumber != user.phoneNumber) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (avatarRef != null ? !avatarRef.equals(user.avatarRef) : user.avatarRef != null) return false;
        if (userAssignedCompanies != null ? !userAssignedCompanies.equals(user.userAssignedCompanies) : user.userAssignedCompanies != null)
            return false;
        if (userIsAdminCompanies != null ? !userIsAdminCompanies.equals(user.userIsAdminCompanies) : user.userIsAdminCompanies != null)
            return false;
        return userStatus == user.userStatus;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + phoneNumber;
        result = 31 * result + (avatarRef != null ? avatarRef.hashCode() : 0);
        result = 31 * result + (userAssignedCompanies != null ? userAssignedCompanies.hashCode() : 0);
        result = 31 * result + (userIsAdminCompanies != null ? userIsAdminCompanies.hashCode() : 0);
        result = 31 * result + (userStatus != null ? userStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserImpl{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", avatarRef='" + avatarRef + '\'' +
                ", userAssignedCompanies=" + userAssignedCompanies +
                ", userIsAdminCompanies=" + userIsAdminCompanies +
                ", userStatus=" + userStatus +
                '}';
    }
}
