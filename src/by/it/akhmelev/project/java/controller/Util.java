package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {
    static User getUserFromSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if (objUser != null) {
            return (User) objUser;
        }
        return null;
    }
}
