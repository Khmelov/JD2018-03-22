package by.it.kirova.jd03_01;

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


        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/",
                             "root",
                             "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("USE kirova");
            //добавление 2х пользователей + еще 2 sql запросами в отдельных файлах
            statement.executeUpdate("INSERT INTO kirova.users " +
                    "(user_id, email, password, first_name, last_name, middle_name, residence_country, phone_number) " +
                    "VALUES (default, 'abc@gmail.com', 'abc123', 'John', 'Smith', NULL, 'UK', '+447874564567')");
            statement.executeUpdate("INSERT INTO kirova.users " +
                    "(user_id, email, password, first_name, last_name, middle_name, residence_country, phone_number) " +
                    "VALUES (default, 'def@gmail.com', 'def123', 'Jacob', 'Irwin', NULL, 'Poland', '+485291111111')");

            //проверка
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                String txt =
                        resultSet.getString("user_id") + "\t" +
                                resultSet.getString("email") + "\t" +
                                resultSet.getString("password") + "\t" +
                                resultSet.getString("first_name") + "\t" +
                                resultSet.getString("last_name") + "\t" +
                                resultSet.getString("middle_name") + "\t" +
                                resultSet.getString("residence_country") + "\t" +
                                resultSet.getString("phone_number");
                System.out.println(txt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

