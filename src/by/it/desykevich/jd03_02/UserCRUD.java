package by.it.desykevich.jd03_02;

import by.it.desykevich.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class UserCRUD {

    static boolean create(User user) throws SQLException {
        String sql = String.format(Locale.US,
                "INSERT INTO `users` (`login`, `password`, `email`, `nickname`, `phonenumber`, `roles_id`) "  +
                        "VALUES ('%s', '%s', '%s', '%s', '%s', '%d');",
                user.getLogin(),user.getPassword(),user.getEmail(),user.getNickname(),user.getPhoneNumber(),user.getRoles_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    user.setID(id);
                }
            }
            return result;
        }
    }


    static boolean update(User user) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `users` SET login='%s', password='%s'," +
                "email='%s', nickname='%s', phonenumber='%s', roles_id='%d' WHERE users.id='%d';",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getNickname(),
                user.getPhoneNumber(), user.getRoles_id(), user.getID());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `users` WHERE `id`=%d", user.getID());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static User read(int id) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `users` WHERE `id`=%d", id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(sql);
            if (result.next()) {
                return new User(
                        result.getInt("id"),
                        result.getString("login"),
                        result.getString("password"),
                        result.getString("email"),
                        result.getString("nickname"),
                        result.getString("phonenumber"),
                        result.getInt("roles_id"));
            }
        }
        return null;
    }
}
