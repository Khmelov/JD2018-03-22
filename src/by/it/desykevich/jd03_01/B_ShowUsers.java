package by.it.desykevich.jd03_01;

import java.sql.*;

public class B_ShowUsers {

    public static void main(String[] args) {
        showUsers();
    }

    public static void showUsers() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = (Connection) DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:2016/desykevich?" +
                        "useUnicode=true&characterEncoding=UTF-8",
                "root",
                "")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("Login") + ", " + resultSet.getString("roles_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
