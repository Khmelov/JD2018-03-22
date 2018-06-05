package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.Ad;
import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends CmdAbstract {
    @Override
    CmdAbstract execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null){
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (req.getParameter("logout") != null)
                    req.getSession().invalidate();
                return Action.LOGIN.comand;
            } else {
                List<Ad> listAdsUser = DAO.getInstance().ad.getAll("WHERE users_id=" + user.getId());
                req.getSession().setAttribute("listAdsUser",listAdsUser);
            }
        return null;
    }
    return Action.LOGIN.comand;
    }
}
