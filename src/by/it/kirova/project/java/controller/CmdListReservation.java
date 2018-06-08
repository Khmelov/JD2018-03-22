package by.it.kirova.project.java.controller;

import by.it.kirova.project.java.beans.Reservation;
import by.it.kirova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdListReservation extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstanceDAO();
        List<Reservation> listReservation = dao.reservation.getAll("");
        req.setAttribute("listReservation", listReservation);
        return null;
    }
}

