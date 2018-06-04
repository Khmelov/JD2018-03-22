package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.Ad;
import by.it.sgolovach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateAd extends CmdAbstract {
    @Override
    CmdAbstract execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String description = req.getParameter("description");
            int rooms = Integer.parseInt(req.getParameter("rooms"));
            double price = Double.parseDouble(req.getParameter("price"));
            double area = Double.parseDouble(req.getParameter("area"));
            int flat = Integer.parseInt(req.getParameter("flat"));
            int flats = Integer.parseInt(req.getParameter("flats"));
            String adress = req.getParameter("adress");

            Ad ad = new Ad(0, description, rooms, price, area, flat, flats, adress, 2);
            DAO dao = DAO.getInstance();
            dao.ad.create(ad);
            return Action.PAGELOG.comand;
        }
        return null;
    }

}
