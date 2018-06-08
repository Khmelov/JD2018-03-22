package by.it.desykevich.project.java.controller;


import by.it.desykevich.project.java.beans.Ad;
import by.it.desykevich.project.java.beans.User;
import by.it.desykevich.project.java.dao.DAO;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProfile extends CmdAbstract {

    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null) {
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (req.getParameter("logout") != null)
                    req.getSession().invalidate();
                return Actions.LOGIN.command;
            }
            else {
                DAO dao = DAO.getInstanse();
                List<Ad> listAdsUser = dao.adDAO.getAll("WHERE users_id=" + user.getID());
                req.getSession().setAttribute("listAdsUser",listAdsUser);
            }
            return null;
        }
        return Actions.LOGIN.command;
    }
}
