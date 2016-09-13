package com.provectus.prodobro.controller;

import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import com.provectus.prodobro.actor.user.UserStatus;
import com.provectus.prodobro.auth.AuthChecker;
import com.provectus.prodobro.service.actor.UserService;
import com.provectus.prodobro.shared.status.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
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
            return new ResponseEntity<User>(
//					userService.getByToken(token),	//// TODO: implement getter and persistance of token
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


    @RequestMapping(value = "/getByEmailPass",    //TODO: email-pass, phone-pass, name-pass
            method = RequestMethod.GET,
            produces = "application/json")
    public ResponseEntity<User> getUserByEmailPass(@RequestParam String email,
                                                   @RequestParam String passHash) {
        System.out.println("email: " + email + "; passHash: " + passHash);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

//		Optional<User> user = userService.getByEmailAndPass(email, passHash);	//TODO please implement and return optional

		/*
        User user = userService.getByEmail(email);    //@return the single result or <tt>null</tt>
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
		*/
    }


    /**
     * {
     * "name": "Vasya",
     * "email": "1@1.2",
     * "passHash": "ewfrhrga4t54ju5t4kj46",
     * "phoneNumber": "+380(97)777-77-77"
     * }
     *
     * @param wrapper
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<User> createUser(@RequestBody UserImplWrapper wrapper) {
        User user = wrapper.getNewlyCreatedUser();
        /*Long id = */
        userService.save(user);    //TODO: save() should return Long (id)(необязательно, id сетается)
//		user.setId(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    private static class UserImplWrapper {
        private String name;
        private String email;
        private String passHash;
        private String phoneNumber;

/*
		public UserImplWrapper(String name, String email,
							   String passHash, String phoneNumber) {
			this.name = name;
			this.email = email;
			this.passHash = passHash;
			this.phoneNumber = phoneNumber;
		}
*/

        public UserImplWrapper() {
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPassHash(String passHash) {
            this.passHash = passHash;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public User getNewlyCreatedUser() {
            User user = new UserImpl(name, email, passHash, phoneNumber);
            user.setStatus(new UserStatus(StatusEnum.NOT_VERIFIED));
            user.setCreatedDate(new Timestamp(new Date().getTime()));
            user.setLastModifiedDate(new Timestamp(new Date().getTime()));

            return user;
        }

    }        //non-static not work

    private class Loginator {
        int type;    // 1 - email-pass, 2 - phone-pass, 3 - name-pass
        String login;
        String pass;
    }

}
