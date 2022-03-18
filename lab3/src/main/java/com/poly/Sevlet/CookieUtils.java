package com.poly.Sevlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtils {
    public static Cookie add(String name, String value, int hours, HttpServletResponse response) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(hours * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
        return cookie;
    }

    public static String get(String name, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if(c.getName().equalsIgnoreCase(name)){
                    return  c.getValue();
                }
            }
        }
        return "";
    }
}
