package by.it.kirova.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class B_ShowUsers {
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


        HashMap<Integer, String> roles = new HashMap<>();
        HashMap<Integer, ArrayList<String>> res = new HashMap<>();


        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/",
                             "root",
                             "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("USE kirova");

            ResultSet resultSet = statement.executeQuery("SELECT role_id, role_name from role");
            while (resultSet.next()) {
                roles.put(resultSet.getInt("role_id"), resultSet.getString("role_name"));
            }
            ResultSet resultSet1 = statement.executeQuery("SELECT role_role_id, users_user_id from role_has_users");
            while (resultSet1.next()) {
                int roleId = resultSet1.getInt("role_role_id");
                int userId = resultSet1.getInt("users_user_id");
                ArrayList<String> list;
                if (res.containsKey(userId)) {
                    list = res.get(userId);
                } else {
                    list = new ArrayList<>();
                    res.put(userId, list);
                }
                String role = roles.get(roleId);
                list.add(role);
            }

            ResultSet resultSet3 = statement.executeQuery("SELECT user_id, first_name, last_name from users");
            while (resultSet3.next()) {
                int userId = resultSet3.getInt("user_id");
                String name = resultSet3.getString("first_name") + " " +
                        resultSet3.getString("last_name");
                ArrayList<String> userRoles = res.get(userId);
                System.out.println(name + " - " + String.join(", ", userRoles));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}