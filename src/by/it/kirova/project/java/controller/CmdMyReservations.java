package by.it.kirova.project.java.controller;

import by.it.kirova.project.java.beans.Reservation;
import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdMyReservations extends Cmd {


    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null) {
            DAO dao = DAO.getInstanceDAO();
            List<Reservation> listUserReservations = dao.reservation.getAll("WHERE user_user_id=" + user.getUser_id());
            req.getSession().setAttribute("listUserReservations", listUserReservations);
            return null;
        }
        return null;
    }

}
