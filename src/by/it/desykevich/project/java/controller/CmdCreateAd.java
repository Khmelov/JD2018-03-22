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
                    FormUtil.getString(req, "title", ".+"),
                    FormUtil.getString(req, "description", ".+"),
                    FormUtil.getInt(req, "price"),
                    user.getID(),
                    FormUtil.getInt(req,"category_id")
            );

            DAO dao = DAO.getInstanse();
            dao.adDAO.create(ad);

            if (ad.getId() > 0) {
                req.setAttribute(Msg.MESSAGE, "Ad created.");
                return Actions.PROFILE.command;
            } else {
                req.setAttribute(Msg.MESSAGE, "Can't create ad.");
                return Actions.CREATEAD.command;
            }
        }catch (ParseException e) {
            req.setAttribute(Msg.MESSAGE, "Check your inputs.");
            return Actions.CREATEAD.command;
        }
    }

//    @Override
//    public CmdAbstract execute(HttpServletRequest req) throws Exception {
//        User user=Util.getUserFromSession(req);
//        if (user!=null){
//            if (req.getMethod().equalsIgnoreCase("post")){
//                Ad ad=new Ad();
//                ad.setTitle(req.getParameter("title"));
//                ad.setDescription(req.getParameter("description"));
//                ad.setPrice(Double.parseDouble(req.getParameter("price")));
//                ad.setUsers_Id(user.getID());
//                ad.setCategory_Id(Integer.parseInt(req.getParameter("category")));
//                DAO.getInstanse().adDAO.create(ad);
//            }
//            else
//                return null;
//        }
//        return Actions.PROFILE.command;
//    }

}
