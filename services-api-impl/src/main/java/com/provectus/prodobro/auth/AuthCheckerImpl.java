package com.provectus.prodobro.auth;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

@Service("authChecker")
public class AuthCheckerImpl implements AuthChecker {
    private String cookieName;

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    @Override
    public boolean isAllow(HttpServletRequest req) {
        return false;
    }

    @Override
    public Optional<Cookie> getToken(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();

        if (cookies == null) {
            return Optional.ofNullable(null);
        }

        return Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals(cookieName))
                .limit(1)
                .findFirst();
    }
}
