package by.it.kirova.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class RoleCRUD {


    static boolean create(Role role) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `role` (`role_name`) VALUES ('%s')",
               role.getRole_name());

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    role.setRole_id(id);
                }

            }
            return result;
        }
    }


    static boolean update(Role role) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `role` SET `role_name`='%s' WHERE `role_id` = %d",
                        role.getRole_name(), role.getRole_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static boolean delete(Role role) throws SQLException {
        String sql = String.format(Locale.US,"DELETE FROM `role` WHERE `role_id` = %d", role.getRole_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static Role read(int role_id) throws SQLException {
        String sql = String.format(Locale.US,"SELECT * FROM `role` WHERE `role_id` = %d", role_id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Role(
                        resultSet.getInt("role_id"),
                        resultSet.getString("role_name")
                );
            }
        }
        return null;
    }


    static int findIdRole(String role_name) throws SQLException {
        String sql = String.format("SELECT * FROM `role` WHERE `role_name`='%s'", role_name);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return resultSet.getInt("role_id");
            }
        }
        return -1;
    }

}
