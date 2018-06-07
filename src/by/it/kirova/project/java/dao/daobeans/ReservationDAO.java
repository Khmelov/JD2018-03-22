package by.it.kirova.project.java.dao.daobeans;

import by.it.kirova.project.java.beans.Reservation;
import by.it.kirova.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReservationDAO extends AbstractDAO<Reservation> {
    @Override
    public boolean create(Reservation reservation) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `reservation`(`reservation_date`, `check_in_date`, " +
                "`check_out_date`, `total_cost`, `room_room_id`, `user_user_id`) " +
                "VALUES (%d,%d,%d,%f,%d,%d)", reservation.getReservation_date(), reservation.getCheck_in_date(),
                reservation.getCheck_out_date(),reservation.getTotal_cost(), reservation.getRoom_room_id(),
                reservation.getUser_user_id());
        int id = executeUpdate(sql, true);
        if (id>0) {
            reservation.setReservation_id(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Reservation reservation) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `reservation` SET `reservation_date`=%d," +
                "`check_in_date`=%d,`check_out_date`=%d,`total_cost`=%f,`room_room_id`=%d,`user_user_id`=%d " +
                "WHERE `reservation_id` = %d",
                reservation.getReservation_date(), reservation.getCheck_in_date(), reservation.getCheck_out_date(),
                reservation.getTotal_cost(), reservation.getRoom_room_id(), reservation.getUser_user_id(),
                reservation.getReservation_id());
        return executeUpdate(sql, false)==1;
    }

    @Override
    public boolean delete(Reservation reservation) throws SQLException {
        String sql = String.format(Locale.US,"DELETE FROM `reservation` WHERE `reservation_id` = %d",
                reservation.getReservation_id());
        return executeUpdate(sql, false)==1;
    }

    @Override
    public Reservation read(int reservation_id) throws SQLException {
        List<Reservation> list=getAll("WHERE `reservation_id`="+reservation_id);
        if (list.size()==1)
            return list.get(0);
        return null;
    }

    @Override
    public List<Reservation> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US,"SELECT * FROM `reservation` " + where);
        List<Reservation> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add( new Reservation(
                        resultSet.getInt("reservation_id"),
                        resultSet.getLong("reservation_date"),
                        resultSet.getLong("check_in_date"),
                        resultSet.getLong("check_out_date"),
                        resultSet.getDouble("total_cost"),
                        resultSet.getInt("room_room_id"),
                        resultSet.getInt("user_user_id")
                ));
            }
        }
        return list;
    }
}
