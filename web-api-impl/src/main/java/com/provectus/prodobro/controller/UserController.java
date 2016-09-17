package com.provectus.prodobro.controller;

import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.perspective.UserRegistrationPersp;
import com.provectus.prodobro.auth.AuthChecker;
import com.provectus.prodobro.service.actor.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	private AuthChecker authChecker;

	@Required
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Required
	@Autowired
	public void setAuthChecker(AuthChecker authChecker) {
		this.authChecker = authChecker;
	}


	@RequestMapping(value = "/getByToken",
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<User> getUserByToken(HttpServletRequest req) {
		Optional<Cookie> token = authChecker.getToken(req);
		if (token.isPresent()) {
			return new ResponseEntity<>(
//					userService.getByToken(token),
					HttpStatus.OK
			);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

	}

	@RequestMapping(value = "/getById",
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<User> getUserById(HttpServletRequest req, @RequestParam Long id) {
		Optional<Cookie> token = authChecker.getToken(req);
		if (token.isPresent()) {
			return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);    //TODO: error
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}


	@RequestMapping(value = "/getByEmailPass",
			method = RequestMethod.GET,
			produces = "application/json")
	public ResponseEntity<User> getUserByEmailPass(@RequestParam String email,
												   @RequestParam String passHash) {
		System.out.println("email: " + email + "; passHash: " + passHash);
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

//		Optional<User> user = userService.getByEmailAndPass(email, passHash);

		/*
		User user = userService.getByEmail(email);    //@return the single result or <tt>null</tt>
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
		*/
	}


	/**
	 * Requirements:
	 * 		url - host/user
	 * 		method - POST
	 *		Headers:
	 *			Accept: application/json
	 *			Content-Type: application/json
	 *		Body with Json perspective
	 *
	 * @param perspective - expect JSON in Body like below
	 *                    {
	 *                    "name": "Firstname Lastnamovich",
	 *                    "email": "abc@mail.com",
	 *                    "passHash": "rg5a65rg5ae5",
	 *                    "phoneNumber": "+380(97)777-77-77"
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
