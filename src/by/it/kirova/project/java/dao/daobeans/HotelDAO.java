package by.it.kirova.project.java.dao.daobeans;

import by.it.kirova.project.java.beans.Hotel;
import by.it.kirova.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HotelDAO extends AbstractDAO<Hotel> {


    @Override
    public boolean create(Hotel hotel) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `hotel`(`hotel_name`, `hotel_type`, " +
                        "`star_rating`, `country`, `city`, `street`, `house_number`, `contact_email`, `contact_phone_number`, " +
                        "`user_user_id`) VALUES ('%s','%s', %d,'%s','%s','%s','%s','%s','%s',%d)",
                hotel.getHotel_name(), hotel.getHotel_type(), hotel.getStar_rating(), hotel.getCountry(), hotel.getCity(),
                hotel.getStreet(), hotel.getHouse_number(), hotel.getContact_email(), hotel.getContact_phone_number(),
                hotel.getUser_user_id());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            hotel.setHotel_id(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Hotel hotel) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `hotel` SET " +
                        "`hotel_name`='%s',`hotel_type`='%s',`star_rating`=%d,`country`='%s',`city`='%s'," +
                        "`street`='%s',`house_number`='%s',`contact_email`='%s',`contact_phone_number`='%s'," +
                        "`user_user_id`=%d WHERE `hotel_id` = %d", hotel.getHotel_name(), hotel.getHotel_type(),
                hotel.getStar_rating(), hotel.getCountry(), hotel.getCity(), hotel.getStreet(),
                hotel.getHouse_number(), hotel.getContact_email(), hotel.getContact_phone_number(),
                hotel.getUser_user_id(), hotel.getHotel_id());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public boolean delete(Hotel hotel) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `hotel` WHERE `hotel_id` = %d", hotel.getHotel_id());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public Hotel read(int hotel_id) throws SQLException {
        List<Hotel> list = getAll("WHERE `hotel_id` =" + hotel_id);
        if (list.size() == 1)
            return list.get(0);
        return null;
    }

    @Override
    public List<Hotel> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US,"SELECT * FROM `hotel` " + where);
        List<Hotel> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add( new Hotel(
                        resultSet.getInt("hotel_id"),
                        resultSet.getString("hotel_name"),
                        resultSet.getString("hotel_type"),
                        resultSet.getInt("star_rating"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getString("street"),
                        resultSet.getString("house_number"),
                        resultSet.getString("contact_email"),
                        resultSet.getString("contact_phone_number"),
                        resultSet.getInt("user_user_id")
                ));
            }
        }
        return list;
    }
}
