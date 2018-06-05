package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdCreateAd extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user=Util.getUserFromSession(req);
        if (user!=null){
            if (req.getMethod().equalsIgnoreCase("post")){
                Ad ad=new Ad();
                ad.setAddress(req.getParameter("address"));
                ad.setDescription(req.getParameter("description"));
                ad.setRooms(Integer.parseInt(req.getParameter("rooms")));
                ad.setFlat(Integer.parseInt(req.getParameter("flat")));
                ad.setFlats(Integer.parseInt(req.getParameter("flats")));
                ad.setArea(Double.parseDouble(req.getParameter("area")));
                ad.setPrice(Double.parseDouble(req.getParameter("price")));
                ad.setUsers_id(user.getId());
                DAO.getInstance().ad.create(ad);
            }
            else
                return null;
        }
        return Actions.LOGIN.command;
    }
}
