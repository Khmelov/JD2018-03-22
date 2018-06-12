package by.it.pashkevich.jd03_02;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskC_Reset {
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
                "jdbc:mysql://127.0.0.1:2016/",
                "root",
                "")) {
            if (!connection.isClosed()) System.out.println("Соединение с базой установлено");
            Statement statement = connection.createStatement();
            statement.executeUpdate("USE pashkevich");
            statement.executeUpdate("DROP TABLE IF EXISTS goods");
            statement.executeUpdate("DROP TABLE IF EXISTS users");
            statement.executeUpdate("DROP TABLE IF EXISTS roles");
            statement.executeUpdate("DROP DATABASE pashkevich");
            System.out.println("Database deleted successfully...");
            connection.close();
            if (connection.isClosed()) System.out.println("Соединение с базой прервано");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}