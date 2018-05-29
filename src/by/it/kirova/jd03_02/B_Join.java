package by.it.kirova.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class B_Join {
    public static void main(String[] args) throws SQLException {

        //Перед запуском сделать reset базы данных и заполнить базу значениями из С_Init из Task 03_01

        String sql = String.format(Locale.US,
                "SELECT users.user_id, users.first_name, users.last_name, role.role_name " +
                        "FROM users " +
                        "LEFT JOIN role_has_users ON users.user_id = role_has_users.users_user_id " +
                        "JOIN role ON role.role_id = role_has_users.role_role_id " +
                        "ORDER BY users.user_id");
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String txt = "id " +
                        resultSet.getString("users.user_id") + "\t" +
                        resultSet.getString("users.first_name") + " " +
                        resultSet.getString("users.last_name") + " : " +
                        resultSet.getString("role.role_name");
                System.out.println(txt);

            }

        }
    }

}
