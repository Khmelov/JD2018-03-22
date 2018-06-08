package by.it.kirova.project.java.controller;


import by.it.kirova.project.java.dao.connect.ConnectionCreator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

public class CmdIndex extends Cmd {
    static ArrayList<ArrayList> searchResult = new ArrayList<>();

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            if (req.getParameter("search") != null) {
                String destination = req.getParameter("destination");
                String checkindate = req.getParameter("checkindate");
                String checkoutdate = req.getParameter("checkoutdate");
                String peopleamount = req.getParameter("peopleamount");
                Long checkin = DateConverter.dateToMil(checkindate);
                Long checkout = DateConverter.dateToMil(checkoutdate);
                if (Parser.validator(destination, "city") ||
                        Parser.validator(checkindate, "date") ||
                        Parser.validator(checkoutdate, "date") ||
                        Parser.validator(peopleamount, "peopleamount") ||
                        checkin > checkout) {
                    return null;
                }
                String sql = String.format(Locale.US, "SELECT hotel.hotel_name, hotel.star_rating, " +
                        "hotel.hotel_type, hotel.street, hotel.house_number, room.room_name, room.people_amount, " +
                        "room.description, room.cost " +
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
                    searchResult.clear();
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
                        int days = (int)(checkout - checkin)/(1000*60*60*24);
                        double total_cost = cost * days;
                        list.add(String.valueOf(total_cost));
                        searchResult.add(list);
                    }
                }
                return Actions.SEARCH.command;

            }

        }
        return null;

    }
}

