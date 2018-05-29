
package by.it.danilevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskA {
    public static void printUser(){
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
                             CN.URL_DB,
                             CN.USER_DB,
                             CN.PASSWORD_DB)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            System.out.println("Table Users");
            while (resultSet.next()) {
                String adress = resultSet.getString("address");
                String name = resultSet.getString("name");
                //    String login = resultSet.getString("login");
                String tel =  resultSet.getString("telephone");
                System.out.printf("%-25s%-20s%-16s%n",name,adress,tel);
            }
         }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public static void printUserRole() {
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
                             CN.URL_DB,
                             CN.USER_DB,
                             CN.PASSWORD_DB)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select users.name as name," +
                    " roles.name as role from `users`, `roles`" +
                    "where users.roles_id=roles.id");
            System.out.println("Table User and Role");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                System.out.printf("%-25s%-20s%n", name, role);
            }
        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
