package com.provectus.prodobro.dao.actor;


import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.dao.GenericDAO;
import com.provectus.prodobro.shared.status.StatusEnum;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {

    List<User> getByName(String name);

    List<User> getByStatus(String status);

    List<User> getByStatus(StatusEnum status);

    User getByPhoneNumber(String phoneNumber);

    User getByEmail(String email);
}
