package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.UserBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class Util {
    static UserBean getUserFromSession(HttpServletRequest req) {
        HttpSession session = req.getSession();
        Object objUser = session.getAttribute("user");
        if (objUser != null) {
            return (UserBean) objUser;
        }
        return null;
    }



    public static long getCurrentDate() {
        Date date = new Date();
        return date.getTime();

    }
}
