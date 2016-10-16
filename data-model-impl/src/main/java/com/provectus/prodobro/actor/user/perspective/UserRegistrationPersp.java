package com.provectus.prodobro.actor.user.perspective;

import com.provectus.prodobro.actor.user.User;
import com.provectus.prodobro.actor.user.UserImpl;
import com.provectus.prodobro.shared.StatusEnumNew;

import java.sql.Timestamp;
import java.util.Date;

public class UserRegistrationPersp {
	private String name;
	private String email;
	private String passHash;
	private String phoneNumber;

	public UserRegistrationPersp() {
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

	public User createUser() {
		User user = new UserImpl(name, email, passHash, phoneNumber);
		user.setStatus(StatusEnumNew.NOT_VERIFIED);
		user.setCreatedDate(new Timestamp(new Date().getTime()));
		user.setLastModifiedDate(new Timestamp(new Date().getTime()));

		return user;
	}


}
