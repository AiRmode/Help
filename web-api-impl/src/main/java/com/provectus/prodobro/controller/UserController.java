package com.provectus.prodobro.controller;

import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.perspective.UserRegistrationPersp;
import com.provectus.prodobro.service.actor.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
	private UserService userService;

	@Required
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/getById",
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<User> getUserById(HttpServletRequest req, @RequestParam Long id) {
		return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);    //TODO: error
	}


	/**
	 * Requirements:
	 * 		url - "host/user/getByEmailPass"
	 * 		method - GET
	 * 		Headers:
	 * 			Accept: application/json
	 *
	 * @param login - email or phone
	 * @param pass - password hash
	 * @return User + Code 200, or Code 417 if credentials are not found
	 */
	@RequestMapping(value = "/getByEmailPass",
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<User> getByLoginPassword(@RequestParam String login,
												   @RequestParam String pass) {
//		Optional<User> user = userService.getByLoginAndPassword(login, pass);
		User user = userService.getByLoginAndPassword(login, pass);

		if (user == null) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}


	/**
	 * Requirements:
	 * url - "host/user"
	 * method - POST
	 * Headers:
	 * Accept: application/json
	 * Content-Type: application/json
	 * Body with Json perspective
	 *
	 * @param perspective - expect JSON in Body like below
	 *                    {
	 *                    "name": "Firstname Lastnamovich",
	 *                    "email": "abc@mail.com",				//TODO implement validation
	 *                    "passHash": "rg5a65rg5ae5",
	 *                    "phoneNumber": "+380(97)777-77-77"	//TODO implement validation
	 *                    }
	 * @return NOT_VERIFIED User with actual id
	 */
	@RequestMapping(method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<User> createUser(@RequestBody UserRegistrationPersp perspective) {
		User user = perspective.createUser();
		userService.save(user);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}


}
