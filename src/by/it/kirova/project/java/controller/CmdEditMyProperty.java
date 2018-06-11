package by.it.kirova.project.java.controller;


import by.it.kirova.project.java.beans.Hotel;
import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdEditMyProperty extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user == null)
            return Actions.LOGIN.command;
        if (user != null) {
            DAO dao = DAO.getInstanceDAO();
            List<Hotel> hotels = dao.hotel.getAll("WHERE user_user_id=" + user.getUser_id());
            req.getSession().setAttribute("hotels", hotels);
            if (req.getMethod().equalsIgnoreCase("post")) {
                int hotel_id = Integer.parseInt(req.getParameter("hotel_id"));
                String hotel_name = req.getParameter("hotel_name");
                String hotel_type = req.getParameter("hotel_type");
                int star_rating = Integer.parseInt(req.getParameter("star_rating"));
                String country = req.getParameter("country");
                String city = req.getParameter("city");
                String street = req.getParameter("street");
                String house_number = req.getParameter("house_number");
                String contact_email = req.getParameter("contact_email");
                String contact_phone_number = req.getParameter("contact_phone_number");
                if (Parser.validator(hotel_name, "hotelname") ||
                        Parser.validator(hotel_type, "hoteltype") ||
                        Parser.validator(String.valueOf(star_rating), "starrating") ||
                        Parser.validator(country, "country") ||
                        Parser.validator(city, "city") ||
                        Parser.validator(street, "street") ||
                        Parser.validator(house_number, "housenumber") ||
                        Parser.validator(contact_email, "email") ||
                        Parser.validator(contact_phone_number, "contactphone")) {
                    return null;
                }
                Hotel editHotel = new Hotel(hotel_id, hotel_name, hotel_type, star_rating, country, city, street,
                        house_number, contact_email, contact_phone_number, user.getUser_id());
                if (req.getParameter("update") != null) {
                    dao.hotel.update(editHotel);
                    return Actions.EDITMYPROPERTY.command;
                } else if (req.getParameter("delete") != null) {
                    dao.hotel.delete(editHotel);
                    return Actions.EDITMYPROPERTY.command;
                }
            }
        }
        return null;
    }
}


