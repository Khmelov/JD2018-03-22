package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.Ad;
import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.util.List;

public class CmdProfile extends CmdAbstract {

    @Override
    CmdAbstract execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null) {
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (req.getParameter("logout") != null)
                    req.getSession().invalidate();
                return Action.LOGIN.comand;
            } else {
                String login = user.getLogin();
                String pass = user.getPassword();
                Cookie cookie = new Cookie(login, pass);
                cookie.setMaxAge(60);
                resp.addCookie(cookie);
//                String listCookies = "";
//                Cookie[] myCook = req.getCookies();
//                for (int i = 0; i < myCook.length; i++) {
//                    Cookie cookie1 = myCook[i];
//                    listCookies = cookie1.getName() + "=" + cookie1.getValue();
//                }
//                req.getSession().setAttribute("listCookies", listCookies);
                List<Ad> listAdsUser = DAO.getInstance().ad.getAll("WHERE users_id=" + user.getId());
                req.getSession().setAttribute("listAdsUser", listAdsUser);

            }
            return null;
        }
        return Action.LOGIN.comand;
    }
}
