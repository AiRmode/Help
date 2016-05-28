package com.formula1.help.actor.shelter;

import com.formula1.help.actor.personalData.PersonalData;

import java.util.List;
import java.util.Set;

/**
 * Created by alexey on 03.05.16.
 */
public interface Shelter {
    int getID();

    String getTitle();

    void setTitle(String title);

    Set<String> getAlias();

    void addAlias(String title);

    void removeAlias(String title);

    void setPersonalData(PersonalData personalData);

    PersonalData getPersonalData();

    String getDescription();

    void setDescription(String description);

    List<String> getTags();

    void getTags(List<String> tags);

    List<String> getAssignedCategories();

    void setAssignedCategories(List<String> assignedCategories);
}
