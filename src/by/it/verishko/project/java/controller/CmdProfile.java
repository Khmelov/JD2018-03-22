package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.beans.Product;
import by.it.verishko.project.java.beans.User;
import by.it.verishko.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user == null) {
            return Actions.LOGIN.command;
        }
        if (req.getMethod().equalsIgnoreCase("post")) {
            if (req.getParameter("UpdateProfile") != null){
                user.setPassword(req.getParameter("password"));
                user.setLogin(req.getParameter("login"));
                DAO dao = DAO.getInstance();
                dao.user.update(user);
                return null;
            }
            if (req.getParameter("logout") != null) {
                req.getSession().invalidate();
                return Actions.LOGIN.command;
            }
        }
//        String login = user.getLogin();
//        String pass = user.getPassword();
        Cookie cookie = new Cookie("login", "login");
        Cookie cookie1 = new Cookie("pass", "pass");
        cookie1.setMaxAge(60);
        cookie.setMaxAge(60);
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        DAO dao = DAO.getInstance();
        List<Product> listGoodsUser = dao.product.getAll("WHERE users_id=" + user.getId());
        req.getSession().setAttribute("goods", listGoodsUser);
        return null;
    }

}

