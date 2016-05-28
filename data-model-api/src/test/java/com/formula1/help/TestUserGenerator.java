package com.formula1.help;

import com.formula1.help.actor.company.Company;
import com.formula1.help.actor.personalData.PersonalData;
import com.formula1.help.actor.user.User;
import com.formula1.help.actor.user.UserStatus;
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
            public String getPassword() {
                return "youShellNotPass";
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
            public PersonalData getPersonalData() {
                return null;
            }

            @Override
            public void setFirstName(String firstName) {

            }

            @Override
            public void setLastName(String lastName) {

            }

            @Override
            public void setPassword(String password) {

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

            @Override
            public void setPersonalData(PersonalData personalData) {

            }
        };
    }
}
