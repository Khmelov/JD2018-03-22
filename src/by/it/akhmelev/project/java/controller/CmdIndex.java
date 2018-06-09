package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstance();
        int countAd = dao.ad.getAll("").size();
        int stepAd = 10;
        String startIndex = req.getParameter("startIndex");
        if (startIndex == null) startIndex = "0";
        req.setAttribute("countAd", countAd);
        req.setAttribute("stepAd", stepAd);
        String where = String.format(" LIMIT %s, %d", startIndex, stepAd);
        List<Ad> ads = dao.ad.getAll(where);
        req.setAttribute("ads", ads);
        return null;
    }
}
