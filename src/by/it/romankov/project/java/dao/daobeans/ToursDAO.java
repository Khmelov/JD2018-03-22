package by.it.romankov.project.java.dao.daobeans;


import by.it.romankov.project.java.beans.Tours;
import by.it.romankov.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ToursDAO extends AbstactDAO<Tours> {

    @Override
    public boolean create(Tours tour) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `tours`" +
                        "(`target`, `transport`, `country`, `city`, " +
                        "`days`, `price`, `people_id`) " +
                        "VALUES " +
                        "('%s','%s','%s','%s',%d,%d,%d)",
                tour.getTarget(),tour.getTransport(),tour.getCountry(),
                tour.getCity(),tour.getDays(),tour.getPrice(),tour.getPeople_id());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            tour.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Tours tour) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `tours` WHERE `id`=%d", tour.getId());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public boolean update(Tours tour) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `tours` SET " +
                        "`target`='%s',`transport`='%s'," +
                        "`country`='%s',`city`='%s',`price`=%d,`days`=%d," +
                        "`people_id`=%d " +
                        "WHERE `id`=%d",
                tour.getTarget(),tour.getTransport(),tour.getCountry(),
                tour.getCity(),tour.getDays(),tour.getPrice(),tour.getPeople_id(),tour.getId());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public Tours read(int id) throws SQLException {
        List<Tours> list=getAll("WHERE `id`="+id);
        if (list.size()==1)
            return list.get(0);
        return null;
    }

    @Override
    public List<Tours> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `tours` " + where);
        List <Tours> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Tours(
                        resultSet.getInt("id"),
                        resultSet.getString("target"),
                        resultSet.getString("transport"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getInt("days"),
                        resultSet.getInt("price"),
                        resultSet.getInt("people_id")
                ));
            }
        }
        return list;

    }
}
