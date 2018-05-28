package by.it.kirova.jd03_02;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class C_DBReset {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/",
                             "root",
                             "")) {
            Statement statement = connection.createStatement();
            //удаление таблиц из БД (по условию задания)
            statement.executeUpdate("USE kirova");
            statement.executeUpdate("DROP TABLE IF EXISTS reservation");
            statement.executeUpdate("DROP TABLE IF EXISTS room");
            statement.executeUpdate("DROP TABLE IF EXISTS hotel");
            statement.executeUpdate("DROP TABLE IF EXISTS role_has_users");
            statement.executeUpdate("DROP TABLE IF EXISTS users");
            statement.executeUpdate("DROP TABLE IF EXISTS role");
            // удаление всей БД сразу

            statement.executeUpdate("DROP DATABASE kirova");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
