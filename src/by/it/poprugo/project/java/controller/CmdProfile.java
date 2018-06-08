package by.it.poprugo.project.java.controller;

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
                if (req.getParameter("logout") != null)
                    req.getSession().invalidate();
                return Actions.LOGIN.command;
            }
            else {
                DAO dao = DAO.getInstance();
                List<Ad> listAdsUser = dao.ad.getAll("WHERE users_id=" + user.getId());
                req.getSession().setAttribute("listAdsUser",listAdsUser);
            }
            return null;
        }
        return Actions.LOGIN.command;
    }
}
