package by.it.verishko.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskA_AddData {
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
                "jdbc:mysql://127.0.0.1:2016/verishko",
                "root",
                "")) {
            if (!connection.isClosed()) System.out.println("Соединение с базой установлено");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `verishko`.`goods` (`id`, `name`, `description`, `price`, `users_id`) VALUES (DEFAULT, 'table', 'tables description', 11, 2)");
            statement.executeUpdate("INSERT INTO `verishko`.`goods` (`id`, `name`, `description`, `price`, `users_id`) VALUES (DEFAULT, 'coffee grinder', 'coffee grinders description', 22, 2)");
            statement.executeUpdate("INSERT INTO `verishko`.`goods` (`id`, `name`, `description`, `price`, `users_id`) VALUES (DEFAULT, 'vacuum cleaner', 'vacuum cleaners description', 33, 2)");
            statement.executeUpdate("INSERT INTO `verishko`.`goods` (`id`, `name`, `description`, `price`, `users_id`) VALUES (DEFAULT, 'iron', 'irons description', 44, 2)");
            connection.close();
            if (connection.isClosed()) System.out.println("Соединение с базой прервано");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
