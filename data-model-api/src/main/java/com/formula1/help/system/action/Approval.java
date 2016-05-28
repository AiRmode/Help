package com.formula1.help.system.action;

/**
 * Created by alexey on 14.05.16.
 */
public interface Approval {

    void getID();

    void approve();

    void reject();

    void requestMoreInformation();

    ApprovalStatus getStatus();
}
