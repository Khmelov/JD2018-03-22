package by.it.romankov.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class ToursCRUD {
    static boolean create(Tours tours) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `tours`" +
                        "(`target`, `transport`, `country`, `city`, " +
                        "`days`, `price`, `people_id`) " +
                        "VALUES " +
                        "('%s','%s','%s','%s',%d,%d,%d)",
                tours.getTarget(),tours.getTransport(),tours.getCountry(),
                        tours.getCity(),tours.getDays(),tours.getPrice(),tours.getPeople_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    tours.setId(id);
                }
            }
            return result;
        }
    }


    static boolean update(Tours tours) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `tours` SET " +
                        "`target`='%s',`transport`='%s'," +
                        "`country`='%s',`city`='%s',`days`=%d," +
                        "`price`=%d,`people_id`=%d " +
                        "WHERE `id`=%d",
                tours.getTarget(),tours.getTransport(),tours.getCountry(),
                tours.getCity(),tours.getDays(),tours.getPrice(),tours.getPeople_id(),tours.getId());

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static boolean delete(Tours tours) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `tours` WHERE `id`=%d", tours.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static Tours read(int id) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `tours` WHERE `id`=%d", id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Tours(
                        resultSet.getInt("id"),
                        resultSet.getString("target"),
                        resultSet.getString("transport"),
                        resultSet.getString("country"),
                        resultSet.getString("city"),
                        resultSet.getInt("days"),
                        resultSet.getInt("price"),
                        resultSet.getInt("people_id")
                );
            }
        }
        return null;
    }
}
