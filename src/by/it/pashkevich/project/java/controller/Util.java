package by.it.pashkevich.project.java.controller;

import by.it.pashkevich.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;

public class Util {
    static User getUserFromSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if (objUser != null) {
            return (User) objUser;
        }
        return null;
    }

//    static boolean getUserFromCookie (HttpServletRequest req){
//        Cookie[] cookie = req.getCookies();
//        boolean user = cookie.equals("user");
//        return user;
//    }

    static String getString(String value, String regxp) throws ParseException {
        return value == null ? null : (value.matches(regxp) ? value : null);
    }

    static boolean isPost(HttpServletRequest req){
        return req.getMethod().equalsIgnoreCase("post");
    }
}