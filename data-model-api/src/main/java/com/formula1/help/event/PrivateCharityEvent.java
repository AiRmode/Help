package com.formula1.help.event;

import com.formula1.help.actor.company.Company;
import com.formula1.help.actor.shelter.Shelter;
import com.formula1.help.actor.user.User;

/**
 * Created by alexey on 06.05.16.
 */
public interface PrivateCharityEvent {

    Shelter getShelter();

    void setShelter(Shelter shelter);

    User getCreatedUser();

    void setCreatedUser(User user);

    Company getCreatedCompany();

    void getCreatedCompany(Company company);

    Long getEffectiveDate();

    Long getCreatedDate();
}
