package com.provectus.prodobro.dao.actor;


import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.dao.GenericDAO;
import com.provectus.prodobro.shared.StatusEnumNew;

import java.util.List;

public interface UserDAO extends GenericDAO<User, Long> {

    List<User> getByName(String name);

    List<User> getByStatus(StatusEnumNew status);

    User getByPhoneNumber(String phoneNumber);

    User getByEmail(String email);

    User getByLoginAndPassword(String login, String password);
}
