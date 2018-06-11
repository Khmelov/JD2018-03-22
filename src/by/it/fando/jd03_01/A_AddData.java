package by.it.fando.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class A_AddData {

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

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/fando",
                "root",
                "")) {
            if (!connection.isClosed()) System.out.println("Соединение с базой установлено");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `fando`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `address`, `users_id`) VALUES (DEFAULT, '10th floor', 1, 20000, 50, 1, 1, 'Pushkin, 1', 2)");
            statement.executeUpdate("INSERT INTO `fando`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `address`, `users_id`) VALUES (DEFAULT, '5th floor', 1, 30000, 60, 1, 1, 'Lermontov, 2', 2)");
            connection.close();
            if (connection.isClosed()) System.out.println("Соединение с базой прервано");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
