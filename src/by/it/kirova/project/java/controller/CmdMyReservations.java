package by.it.kirova.project.java.controller;

import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.connect.ConnectionCreator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

public class CmdMyReservations extends Cmd {



    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null) {
            ArrayList<ArrayList> reservations = new ArrayList<>();
            String sql = String.format(Locale.US, "SELECT reservation.reservation_date, room.room_name, " +
                    " reservation.check_in_date, reservation.check_out_date, reservation.total_cost " +
                    " FROM reservation JOIN room ON reservation.room_room_id = room.room_id" +
                    " WHERE reservation.user_user_id= " + user.getUser_id());
            try (Connection connection = ConnectionCreator.getConnection();
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                reservations.clear();
                while (resultSet.next()) {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(DateConverter.dateToString(resultSet.getLong("reservation.reservation_date")));
                    list.add(resultSet.getString("room.room_name"));
                    list.add(DateConverter.dateToString(resultSet.getLong("reservation.check_in_date")));
                    list.add(DateConverter.dateToString(resultSet.getLong("reservation.check_out_date")));
                    list.add(String.valueOf(resultSet.getInt("reservation.total_cost")));
                    reservations.add(list);
                }
            }
            req.getSession().setAttribute("reservations", reservations);
            return null;
        }
        return null;
    }

}
