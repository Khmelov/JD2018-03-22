package by.it.sgolovach.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskA_AddUser {
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

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/sgolovach", "root", "")) {
            if (!connection.isClosed()) System.out.println("Соединение с базой установлено");
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'administrator', 'adm@mail.ru', 'administrator', 1)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user', 'user@mail.ru', 'user', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user2', 'user2@mail.ru', 'user2', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user3', 'user3@mail.ru', 'user3', 2)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'guest', 'guest3@mail.ru', 'user3', 3)");
            statement.executeUpdate("INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'director', 'director@mail.ru', 'user3', 4)");
            connection.close();
            if (connection.isClosed()) System.out.println("Соединение с базой прервано");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
