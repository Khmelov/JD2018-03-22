package by.it.desykevich.project.java.controller;


import by.it.desykevich.project.java.beans.Ad;
import by.it.desykevich.project.java.beans.Category;
import by.it.desykevich.project.java.beans.User;
import by.it.desykevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CmdCreateAd extends CmdAbstract {

    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o != null) {
            user = (User) o;
        } else
            return Actions.LOGIN.command;
        List<Category> categories = DAO.getInstanse().categoryDAO.getAll("");
        req.setAttribute("categories",categories);
        if (!FormUtil.isPost(req)) {
            return null;
        }
        try {
            Ad ad = new Ad(0,
                    FormUtil.getString(req, "Title", ".+"),
                    FormUtil.getString(req, "Description", ".+"),
                    FormUtil.getInt(req, "Price"),
                    user.getID(),
                    FormUtil.getInt(req,"category_ID")
            );
            DAO dao = DAO.getInstanse();
            dao.adDAO.create(ad);
            if (ad.getId() > 0) {
                req.setAttribute(Msg.MESSAGE, "Ad created.");
                return Actions.MYADS.command;
            } else {
                req.setAttribute(Msg.MESSAGE, "Can't create ad.");
                return Actions.CREATEAD.command;
            }
        } catch (ParseException e) {
            req.setAttribute(Msg.MESSAGE, "Check your inputs.");
            return Actions.CREATEAD.command;
        }
    }
}
