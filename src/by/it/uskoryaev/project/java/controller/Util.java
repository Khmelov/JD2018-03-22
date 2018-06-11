package by.it.uskoryaev.project.java.controller;

import by.it.uskoryaev.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {
    static User getUserFormSession(HttpServletRequest req){
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("user");
        if (obj != null){
            return (User) obj;
        }
        return null;
    }

}
