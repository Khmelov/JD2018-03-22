package by.it.fando.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class C_Reset {

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
            String deleteDataBase = "DROP DATABASE `fando`";
            statement.executeUpdate(deleteDataBase);
            System.out.println("Database deleted");
            connection.close();
            if (connection.isClosed()) System.out.println("Соединение с базой прервано");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
