package by.it.kirova.jd03_03.dao.daobeans;

import by.it.kirova.jd03_03.beans.Room;
import by.it.kirova.jd03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RoomDAO extends AbstractDAO<Room> {

    @Override
    public boolean create(Room room) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `room`(`room_name`, `room_fact_number`, " +
                "`people_amount`, `description`, `cost`, `hotel_hotel_id`) " +
                "VALUES ('%s','%s',%d,'%s',%f,%d)", room.getRoom_name(), room.getRoom_fact_number(),
                room.getPeople_amount(), room.getDescription(), room.getCost(), room.getHotel_hotel_id());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            room.setRoom_id(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Room room) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `room` SET `room_name`='%s',`room_fact_number`='%s'," +
                "`people_amount`=%d,`description`='%s',`cost`=%f,`hotel_hotel_id`=%d WHERE `room_id` = %d",
                room.getRoom_name(), room.getRoom_fact_number(), room.getPeople_amount(), room.getDescription(),
                room.getCost(), room.getHotel_hotel_id(), room.getRoom_id());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public boolean delete(Room room) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `room` WHERE `room_id` = %d", room.getRoom_id());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public Room read(int room_id) throws SQLException {
        List<Room> list = getAll("WHERE `room_id`=" + room_id);
        if (list.size() == 1)
            return list.get(0);
        return null;
    }

    @Override
    public List<Room> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `room` " + where);
        List<Room> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Room(
                        resultSet.getInt("room_id"),
                        resultSet.getString("room_name"),
                        resultSet.getString("room_fact_number"),
                        resultSet.getInt("people_amount"),
                        resultSet.getString("description"),
                        resultSet.getDouble("cost"),
                        resultSet.getInt("hotel_hotel_id")
                ));
            }
        }
        return list;
    }
}
