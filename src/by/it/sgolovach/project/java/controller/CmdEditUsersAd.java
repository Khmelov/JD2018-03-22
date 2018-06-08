package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.Ad;
import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdEditUsersAd extends CmdAbstract {
    @Override
    CmdAbstract execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null) {
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (req.getParameter("Update") != null || req.getParameter("Delete") != null) {
                    DAO dao = DAO.getInstance();
                    int id = Integer.parseInt(req.getParameter("id"));
                    Ad ourAd = dao.ad.read(id);
                    String description = req.getParameter("description");
                    int rooms = Integer.parseInt(req.getParameter("rooms"));
                    double price = Double.parseDouble(req.getParameter("price"));
                    double area = Double.parseDouble(req.getParameter("area"));
                    int flat = Integer.parseInt(req.getParameter("flat"));
                    int flats = Integer.parseInt(req.getParameter("flats"));
                    String adress = req.getParameter("adress");
                    int users_id = ourAd.getUsers_id();
                    Ad editad = new Ad(id, description, rooms, price, area, flat, flats, adress, users_id);
                    if (req.getParameter("Update") != null) {
                        dao.ad.update(editad);
                        return Action.EDITUSERSAD.comand;
                    } else if (req.getParameter("Delete") != null) {
                        dao.ad.delete(editad);
                        return Action.EDITUSERSAD.comand;
                    }
                }

            } else {
                String login = user.getLogin();
                String pass = user.getPassword();
                Cookie cookie = new Cookie(login, pass);
                cookie.setMaxAge(60);
                resp.addCookie(cookie);
                List<Ad> listAds = DAO.getInstance().ad.getAll("");
                req.getSession().setAttribute("listAds", listAds);

            }
            return null;
        }
        return Action.LOGIN.comand;
    }
}
