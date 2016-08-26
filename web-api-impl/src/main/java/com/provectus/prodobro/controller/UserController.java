package com.provectus.prodobro.controller;

import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping(value = "/",
			method = RequestMethod.GET,
			produces = "application/json")
	public List<User> getAllUsers(){
		List<User> userList = initUsersList();
		return userList;
	}



	private List<User> initUsersList() {
		List<User> userList = new ArrayList<>();
		User first = new UserImpl();
		first.setId(1L);
		first.setName("Vasya");
		userList.add(first);

		User second = new UserImpl();
		second.setId(2L);
		second.setName("Petya");
		userList.add(second);
		return userList;
	}
}
