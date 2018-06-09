package by.it.romankov.project.java.controller;

import by.it.romankov.project.java.beans.Tours;
import by.it.romankov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends CmdAbstract {
    @Override
    public CmdIndex execute(HttpServletRequest req) throws Exception {
        List<Tours> ListTours = DAO.getInstance().tour.getAll("");
        req.setAttribute("ListTours",ListTours);
        return null;
    }
}