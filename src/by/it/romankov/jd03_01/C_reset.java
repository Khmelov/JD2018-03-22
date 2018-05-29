package by.it.romankov.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class C_reset {
    public static void main(String[] args) throws SQLException {

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

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/", "root", "")) {
            if (!connection.isClosed()) {
                System.out.println("Соединение с базой установлено");
            }
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP DATABASE `romankov`");
            System.out.println("База данных удалена");
        }
    }
}