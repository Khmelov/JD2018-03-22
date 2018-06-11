package by.it.kirova.project.java.controller;


import by.it.kirova.project.java.beans.Reservation;
import by.it.kirova.project.java.beans.Room;
import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.DAO;
import by.it.kirova.project.java.dao.connect.ConnectionCreator;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CmdSearch extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String destination = (String) req.getSession().getAttribute("destination");
        Long checkin = (Long) req.getSession().getAttribute("checkin");
        Long checkout = (Long) req.getSession().getAttribute("checkout");
        String peopleamount = (String) req.getSession().getAttribute("peopleamount");
//        Long checkin = DateConverter.dateToMil(checkindate);
//        Long checkout = DateConverter.dateToMil(checkoutdate);
        if (req.getMethod().equalsIgnoreCase("get")) {
            ArrayList<ArrayList> searchResult = new ArrayList<>();
            String sql = String.format(Locale.US, "SELECT hotel.hotel_name, hotel.star_rating, " +
                    "hotel.hotel_type, hotel.street, hotel.house_number, room.room_name, room.people_amount, " +
                    "room.description, room.cost, room.room_id " +
                    "FROM hotel " +
                    "LEFT JOIN room ON hotel.hotel_id = room.hotel_hotel_id " +
                    "LEFT JOIN reservation ON room.room_id = reservation.room_room_id " +
                    "WHERE hotel.city LIKE '" + destination + "' AND room.people_amount >= " + peopleamount +
                    " AND (reservation.check_in_date >= " + checkout +
                    " OR reservation.check_out_date <= " + checkin + " OR" +
                    " reservation.check_in_date is null OR reservation.check_out_date is null ) " +
                    " ORDER BY hotel.hotel_name");
            try (Connection connection = ConnectionCreator.getConnection();
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(resultSet.getString("hotel.hotel_name"));
                    list.add(String.valueOf(resultSet.getInt("hotel.star_rating")));
                    list.add(resultSet.getString("hotel.hotel_type"));
                    list.add(resultSet.getString("hotel.street"));
                    list.add(resultSet.getString("hotel.house_number"));
                    list.add(resultSet.getString("room.room_name"));
                    list.add(String.valueOf(resultSet.getInt("room.people_amount")));
                    list.add(resultSet.getString("room.description"));
                    double cost = resultSet.getDouble("room.cost");
                    int days = (int) (checkout - checkin) / (1000 * 60 * 60 * 24);
                    double total_cost = cost * days;
                    list.add(String.valueOf(total_cost));
                    list.add(resultSet.getString("room.room_id"));
                    searchResult.add(list);
                }
            }

            req.setAttribute("searchResult", searchResult);
        }
        if (req.getParameter("booking") != null) {
            User user = Util.getUserFromSession(req);
            if (user == null) {
                return Actions.LOGIN.command;
            } else {
                DAO dao = DAO.getInstanceDAO();
                Date date = new Date();
                Long reservation_date = DateConverter.dateFormatToLong(date);
                double cost = Double.parseDouble(req.getParameter("room.cost"));
                int room_id = Integer.parseInt(req.getParameter("room_id"));
                int days = (int) (checkout - checkin) / (1000 * 60 * 60 * 24);
                double total_cost = cost * days;

                Reservation reservation = new Reservation(0, reservation_date, checkin, checkout, total_cost, room_id, user.getUser_id());
                dao.reservation.create(reservation);
                return Actions.MYRESERVATIONS.command;
            }
        }

        return null;
    }
}
