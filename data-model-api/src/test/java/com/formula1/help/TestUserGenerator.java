package com.formula1.help;

import com.formula1.help.actors.Company;
import com.formula1.help.actors.User;
import com.formula1.help.actors.UserStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexey on 03.05.16.
 */
@Service
public class TestUserGenerator {

    public User getValidUser() {
        return new User() {
            @Override
            public int getID() {
                return 1;
            }

            @Override
            public String getFirstName() {
                return "Gendalf";
            }

            @Override
            public String getLastName() {
                return "White";
            }

            @Override
            public String getEmail() {
                return "wgendalf@middleearth.ring";
            }

            @Override
            public String getPassword() {
                return "youShellNotPass";
            }

            @Override
            public String getFullPhoneNumber() {
                return "+911123123";
            }

            @Override
            public int getPhoneNumber() {
                return 911123123;
            }

            @Override
            public String getFirstLastName() {
                return null;
            }

            @Override
            public String getAvatarRef() {
                return null;
            }

            @Override
            public List<Company> getUserAssignedCompanies() {
                return null;
            }

            @Override
            public List<Company> getUserIsAdminCompanies() {
                return null;
            }

            @Override
            public UserStatus getUserStatus() {
                return UserStatus.ACTIVE;
            }

            @Override
            public void setFirstName(String firstName) {

            }

            @Override
            public void setLastName(String lastName) {

            }

            @Override
            public void setEmail(String email) {

            }

            @Override
            public void setPassword(String password) {

            }

            @Override
            public void setPhoneNumber(int phoneNumber) {

            }

            @Override
            public void setAvatarRef(String avatarRef) {

            }

            @Override
            public void setUserAssignedCompanies(List<Company> userAssignedCompanies) {

            }

            @Override
            public void setUserIsAdminCompanies(List<Company> userIsAdminCompanies) {

            }

            @Override
            public void setUserStatus(UserStatus userStatus) {

            }
        };
    }
}
