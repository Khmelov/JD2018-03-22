package by.it.romankov.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class RolesCRUD {

    static boolean create(Roles roles) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `roles`(`role`) VALUES ('%s')", roles.getRole());

        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    roles.setId(id);

                }
            }
            return result;
        }
    }

    static boolean update(Roles roles) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `roles` SET `role`='%s' " +
                "WHERE `id`=%d", roles.getRole(), roles.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
    static boolean delete(Roles roles) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `roles` WHERE `id`=%d", roles.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static Roles read(int id) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `roles` WHERE `id`=%d", id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Roles(
                        resultSet.getString("role"),
                        resultSet.getInt("id")
                                );
            }
        }
        return null;
    }
}