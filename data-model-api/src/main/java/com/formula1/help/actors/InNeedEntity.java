package com.formula1.help.actors;

import java.util.List;

/**
 * Created by alexey on 03.05.16.
 */
public interface InNeedEntity {
    int getID();

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    List<String> getTags();

    void getTags(List<String> tags);

    List<String> getAssignedCategories();

    void setAssignedCategories(List<String> assignedCategories);
}
