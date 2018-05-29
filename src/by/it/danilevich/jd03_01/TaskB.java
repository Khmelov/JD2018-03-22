package by.it.danilevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskB {
    public static void addRoles(){
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
           // "INSERT INTO `danilevich`.`roles` (`id`, `name`) VALUES (3, 'Admin');
            statement.executeUpdate("insert into roles(name) values ('Director23')");
            ResultSet resultSet = statement.executeQuery("select * from roles");
            System.out.println("Table Role");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String id = resultSet.getString("id");
                System.out.printf("%-25s%-20s%n", id, name);
            }
        }
        catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

}
