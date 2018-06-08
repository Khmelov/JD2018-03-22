package by.it.kirova.project.java.controller;

import by.it.kirova.project.java.beans.Hotel;
import by.it.kirova.project.java.dao.DAO;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdListHotel extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstanceDAO();
        List<Hotel> listHotel = dao.hotel.getAll("");
        req.setAttribute("listHotel", listHotel);
        return null;
    }
}

