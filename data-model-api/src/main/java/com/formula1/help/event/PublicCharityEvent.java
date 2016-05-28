package com.formula1.help.event;

import com.formula1.help.actor.company.Company;
import com.formula1.help.actor.user.User;

import java.util.Set;

/**
 * Created by alexey on 28.05.16.
 */
public interface PublicCharityEvent extends PrivateCharityEvent {

    Set<User> getAppliedUsers();

    void setAppliedUsers(Set<User> users);

    Set<Company> getAppliedCompanies();

    void getAppliedCompanies(Set<Company> companies);

    void applyToEvent(User user);

    void applyToEvent(Company company);
}
