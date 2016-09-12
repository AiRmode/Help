package com.provectus.prodobro.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public interface AuthChecker {
	boolean isAllow(HttpServletRequest req);

	Optional<Cookie> getToken(HttpServletRequest req);
}
