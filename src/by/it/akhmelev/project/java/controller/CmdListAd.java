package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdListAd extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        DAO dao=DAO.getInstance();
        List<Ad> listAd = dao.ad.getAll("");
        req.setAttribute("listAd",listAd);
        return null;
    }
}
