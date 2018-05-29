package by.it.romankov.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskA {
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
                             "jdbc:mysql://127.0.0.1:2016/romankov",
                             "root",
                             "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into people (name,email,telephone,age,roles_id)"+"values('Ilya','ikiol@tut.by','2585254','28','2');");
            ResultSet resultSet = statement.executeQuery("select * from tours");

            while (resultSet.next()) {
                String txt =
                        resultSet.getString("city") + ":" +
                                resultSet.getString("price");
                System.out.println(txt);
            }
        }



        catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
