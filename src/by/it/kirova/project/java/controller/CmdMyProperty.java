package by.it.kirova.project.java.controller;


import by.it.kirova.project.java.beans.Hotel;
import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdMyProperty extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null) {
            if (req.getMethod().equalsIgnoreCase("post")) {
                String hotel_name = req.getParameter("hotelname");
                String hotel_type = req.getParameter("hoteltype");
                int star_rating = Integer.parseInt(req.getParameter("starrating"));
                String country = req.getParameter("country");
                String city = req.getParameter("city");
                String street = req.getParameter("street");
                String house_number = req.getParameter("housenumber");
                String contact_email = req.getParameter("email");
                String contact_phone_number = req.getParameter("contactphone");
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
                } else {
                    Hotel hotel = new Hotel(0, hotel_name, hotel_type, star_rating, country, city, street,
                            house_number, contact_email, contact_phone_number, user.getUser_id());
                    DAO dao = DAO.getInstanceDAO();
                    dao.hotel.create(hotel);

                    user.setRole_role_id(3);
                    dao.user.update(user);
                    return Actions.EDITMYPROPERTY.command;
                }
            }
            //todo проверить update

        }
        return null;

    }
}
