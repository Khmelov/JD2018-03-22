package by.it.romankov.project.java.controller;

import by.it.romankov.project.java.beans.People;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {
    static People getPeopleFromSession(HttpServletRequest req){
        HttpSession httpSession = req.getSession();
        Object Objpeople = httpSession.getAttribute("people");
        if (Objpeople!=null)
            return (People) Objpeople;
        return null;

    }
}
