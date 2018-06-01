
package by.it.danilevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskA {
    public static void printUser() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("use " + CN.NAME_DB);
            ResultSet resultSet = statement.executeQuery("select * from users");
            System.out.println("Table Users");
            while (resultSet.next()) {
                String adress = resultSet.getString("address");
                String name = resultSet.getString("name");
                //    String login = resultSet.getString("login");
                String tel = resultSet.getString("telephone");
                System.out.printf("%-25s%-20s%-16s%n", name, adress, tel);
            }
        }
    }

    public static void printUserRole() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("use " + CN.NAME_DB);
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
    }
}
