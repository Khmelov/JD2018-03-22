package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.Ad;
import by.it.sgolovach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdListad extends CmdAbstract {
    @Override
    CmdAbstract execute(HttpServletRequest req) throws Exception {
        DAO dao=DAO.getInstance();
        List<Ad> listAd = dao.ad.getAll("");
        req.setAttribute("listAd",listAd);
        return null;
    }
}
