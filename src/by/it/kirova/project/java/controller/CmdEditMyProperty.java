package by.it.kirova.project.java.controller;


import by.it.kirova.project.java.beans.Hotel;
import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditMyProperty extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user == null)
            return Actions.LOGIN.command;
        if (user != null) {
                DAO dao = DAO.getInstanceDAO();
                List<Hotel> hotels = dao.hotel.getAll("WHERE user_user_id=" + user.getUser_id());
                req.getSession().setAttribute("hotels", hotels);

                int hotel_id = Integer.parseInt(req.getParameter("id"));
                String hotel_name = req.getParameter("hotel_name");
                String hotel_type = req.getParameter("hotel_type");
                int star_rating = Integer.parseInt(req.getParameter("star_rating"));
                String country = req.getParameter("country");
                String city = req.getParameter("city");
                String street = req.getParameter("street");
                String house_number = req.getParameter("house_number");
                String contact_email = req.getParameter("contact_email");
                String contact_phone_number = req.getParameter("contact_phone_number");
                Hotel editHotel = new Hotel(hotel_id, hotel_name, hotel_type, star_rating, country, city, street,
                        house_number, contact_email, contact_phone_number, user.getUser_id());
                if (req.getParameter("update") != null) {
                    dao.hotel.update(editHotel);
                }
                if (req.getParameter("delete") != null) {
                    dao.hotel.delete(editHotel);
                }
                return null;
            }

        return null;
        }
    }


