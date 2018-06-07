package by.it.romankov.project.java.controller;

import by.it.romankov.project.java.beans.Tours;
import by.it.romankov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdListTours extends CmdAbstract {
    @Override
    CmdAbstract execute(HttpServletRequest req) throws Exception {
        DAO dao=DAO.getInstance();
        List<Tours> listTours = dao.tour.getAll("");
        req.setAttribute("listTours",listTours);
        return null;
    }
}
