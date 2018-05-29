package by.it.kirova.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class UserCRUD {

    static boolean create(User user) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `users`" +
                        "(`email`, `password`, `first_name`, `last_name`, `middle_name`, `residence_country`, `phone_number`)" +
                        "VALUES ('%s','%s','%s','%s','%s','%s','%s')",
                user.getEmail(), user.getPassword(), user.getFirst_name(), user.getLast_name(), user.getMiddle_name(),
                user.getResidence_country(), user.getPhone_number());

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    user.setUser_id(id);
                }

            }
            return result;
        }
    }

    static boolean update(User user) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `users` SET " +
                        "`email`='%s',`password`='%s',`first_name`='%s',`last_name`='%s',`middle_name`='%s',`residence_country`='%s'," +
                        "`phone_number`='%s' WHERE `user_id` = %d",
                        user.getEmail(), user.getPassword(), user.getFirst_name(), user.getLast_name(), user.getMiddle_name(),
                user.getResidence_country(), user.getPhone_number(), user.getUser_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.US,"DELETE FROM `users` WHERE `user_id` = %d", user.getUser_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static User read(int user_id) throws SQLException {
        String sql = String.format(Locale.US,"SELECT * FROM `users` WHERE `user_id` = %d", user_id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getString("residence_country"),
                        resultSet.getString("phone_number")
                );
            }

        }
        return null;
    }

}
