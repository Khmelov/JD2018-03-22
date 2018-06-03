package by.it.sgolovach.project.java.dao.daobeans;

import by.it.sgolovach.project.java.beans.Ad;
import by.it.sgolovach.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AdDAO extends AbstractDAO<Ad> {

    @Override
    public boolean create(Ad ad) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `ads`(`description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`)" +
                        " VALUES ('%s',%d,%f,%f,%d,%d,'%s',%d)", ad.getDescription(), ad.getRooms(), ad.getPrice(), ad.getArea(),
                ad.getFlat(), ad.getFlats(), ad.getAdress(), ad.getUsers_id());
        int id=executeUpdate(sql,true);
        if (id > 0) {
            ad.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Ad ad) throws SQLException {
        String sql = String.format(Locale.US,"UPDATE " +
                        "`ads` SET `description`='%s',`rooms`=%d,`price`=%f,`area`=%f," +
                        "`flat`=%d,`flats`=%d,`adress`='%s',`users_id`=%d" +
                        " WHERE `id`=%d", ad.getDescription(), ad.getRooms(), ad.getPrice(), ad.getArea(), ad.getFlat(), ad.getFlats(),
                ad.getAdress(), ad.getUsers_id(), ad.getId());
        return executeUpdate(sql,false)==1;
    }

    @Override
    public boolean delete(Ad ad) throws SQLException {
        String sql=String.format(Locale.US,"DELETE FROM `ads` WHERE `id`=%d",ad.getId());
        return executeUpdate(sql,false)==1;
    }

    @Override
    public Ad read(int id) throws SQLException {
        String sql=String.format(Locale.US,"SELECT * FROM `ads` WHERE `id`=%d",id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()) {
                return new Ad(
                        resultSet.getInt("id"),
                        resultSet.getString("description"),
                        resultSet.getInt("rooms"),
                        resultSet.getDouble("price"),
                        resultSet.getDouble("area"),
                        resultSet.getInt("flat"),
                        resultSet.getInt("flats"),
                        resultSet.getString("adress"),
                        resultSet.getInt("users_id")
                );
            }

        }
        return null;
    }

    @Override
    public List<Ad> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `ads` "+where);
        List<Ad> list =new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add( new Ad(
                        resultSet.getInt("id"),
                        resultSet.getString("description"),
                        resultSet.getInt("rooms"),
                        resultSet.getDouble("price"),
                        resultSet.getDouble("area"),
                        resultSet.getInt("flat"),
                        resultSet.getInt("flats"),
                        resultSet.getString("adress"),
                        resultSet.getInt("users_id")
                ));
            }
        }
        return list;
    }
}
