package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null) {
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (req.getParameter("UpdateProfile") != null){
                    user.setPassword(req.getParameter("password"));
                    user.setLogin(req.getParameter("login"));
                    DAO dao = DAO.getInstance();
                    dao.user.update(user);
                    return null;
                }
                if (req.getParameter("logout") != null)
                    req.getSession().invalidate();
                return Actions.LOGIN.command;
            }
            else {
                DAO dao = DAO.getInstance();
                int countAd = dao.ad.getAll("").size();
                int stepAd = 5;
                String startIndex = req.getParameter("startIndex");
                if (startIndex == null) startIndex = "0";
                req.setAttribute("countAd", countAd);
                req.setAttribute("stepAd", stepAd);
                String where = String.format("WHERE users_id=%d LIMIT %s, %d", user.getId(), startIndex, stepAd);
                List<Ad> listAdsUser = dao.ad.getAll(where );
                req.getSession().setAttribute("ads",listAdsUser);
            }
            return null;
        }
        return Actions.LOGIN.command;
    }
}
