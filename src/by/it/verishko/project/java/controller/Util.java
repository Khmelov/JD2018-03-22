package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.beans.User;

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

//    static String getString(String value, String regxp) throws ParseException {
//        if (value.equals(regxp)) return value;
//        else throw new ParseException("Input error", 1);
//    }

    static String getString(String value, String regxp) {
        if (value == null) return null;
        else if (value.matches(regxp)) return value;
        else return null;
    }

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("post");
    }
}