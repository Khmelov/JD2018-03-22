package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.Ad;
import by.it.sgolovach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdIndex extends CmdAbstract {
    @Override
    CmdAbstract execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Ad> ads = DAO.getInstance().ad.getAll("");
        req.setAttribute("ads",ads);
        return null;
    }
}
