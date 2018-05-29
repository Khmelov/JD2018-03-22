package by.it.kirova.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class RHUCRUD {

    static boolean create(RHU role_has_users) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `role_has_users`" +
                "(`role_role_id`, `users_user_id`)" +
                "VALUES (%d,%d)",  role_has_users.getRole_role_id(), role_has_users.getUsers_user_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }


    static boolean update(RHU role_has_users) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `role_has_users` SET " +
                        "`role_role_id`=%d, `users_user_id`=%d",
                        role_has_users.getRole_role_id(), role_has_users.getUsers_user_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static boolean delete(RHU role_has_users) throws SQLException {
        String sql = String.format(Locale.US,"DELETE FROM `role_has_users` WHERE `users_user_id` = %d", role_has_users.getUsers_user_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static RHU read(int users_user_id) throws SQLException {
        String sql = String.format(Locale.US,"SELECT * FROM `role_has_users` WHERE `users_user_id` = %d", users_user_id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new RHU(
                        resultSet.getInt("role_role_id"),
                        resultSet.getInt("users_user_id")
                );
            }

        }
        return null;
    }

}
