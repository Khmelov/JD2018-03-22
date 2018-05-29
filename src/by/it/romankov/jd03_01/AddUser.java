package by.it.romankov.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class AddUser {
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

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/romankov", "root", "")) {
            if (!connection.isClosed()) System.out.println("Соединение с базой установлено");
            Statement statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO `people`(`id`, `name`, `email`, `telephone`, `age`, `roles_id`) VALUES (DEFAULT,'Dima','dima@tut.by',5467822,29,1)");
            statement.executeUpdate("INSERT INTO `people`(`id`, `name`, `email`, `telephone`, `age`, `roles_id`) VALUES (DEFAULT,'Alisa','alisa@tut.by',45464524,29,1)");
            statement.executeUpdate("INSERT INTO `people`(`id`, `name`, `email`, `telephone`, `age`, `roles_id`) VALUES (DEFAULT,'Nikita','nikita@tut.by',74123809,29,2)");
            statement.executeUpdate("INSERT INTO `people`(`id`, `name`, `email`, `telephone`, `age`, `roles_id`) VALUES (DEFAULT,'Anya','anuta@tut.by',8523014,29,2)");
            statement.executeUpdate("INSERT INTO `people`(`id`, `name`, `email`, `telephone`, `age`, `roles_id`) VALUES (DEFAULT,'Ilya','ilya@tut.by',13132501,32,2)");


            if (connection.isClosed()) System.out.println("Соединение с базой прервано");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
