package by.it.kirova.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class A_AddUser {
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
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS kirova");
            statement.executeUpdate("USE kirova");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS kirova.users (\n" +
                    "user_id INT NOT NULL AUTO_INCREMENT," +
                    "email VARCHAR(70) NOT NULL," +
                    "password VARCHAR(30) NOT NULL," +
                    "first_name VARCHAR(45) NOT NULL," +
                    "last_name VARCHAR(45) NOT NULL," +
                    "middle_name VARCHAR(45) NULL," +
                    "residence_country VARCHAR(45) NOT NULL," +
                    "phone_number VARCHAR(45) NOT NULL," +
                    "PRIMARY KEY (user_id)," +
                    "UNIQUE INDEX email_UNIQUE (email ASC))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}