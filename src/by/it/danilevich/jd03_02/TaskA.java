
package by.it.danilevich.jd03_02;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA {
    public static void printUser(String addStr) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("use " + CN.NAME_DB);
            ResultSet resultSet = statement.executeQuery("select * from "+"`"+CN.NAME_DB+"`."+"`user`");
            System.out.println("Table Users "+ addStr);
            while (resultSet.next()) {
                String adress = resultSet.getString("address");
                String name = resultSet.getString("name");
                //    String login = resultSet.getString("login");
                String tel = resultSet.getString("telephone");
                System.out.printf("%-25s%-20s%-16s%n", name, adress, tel);
            }
        }
    }

    public static void printUserRole(String addStr) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("use " + CN.NAME_DB);
            ResultSet resultSet = statement.executeQuery("select `user`.`name` as `name`, `role`.`name` as `role` from `user`,`role` where `user`.`role_id`=`role`.`id`");
            System.out.println("Table User and Role "+addStr);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String role = resultSet.getString("role");
                System.out.printf("%-25s%-20s%n", name, role);
            }
        }
    }
    public static void printRole(String addStr) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("use " + CN.NAME_DB);
            ResultSet resultSet = statement.executeQuery("select * from `role`");
            System.out.println("Table Role "+addStr);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.printf("%-6s%-10s%n", id, name);
            }
        }
    }

    public static void printKindOfWork(String addStr) throws SQLException{
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("use " + CN.NAME_DB);
            ResultSet resultSet = statement.executeQuery("select * from `kind_of_work`");
            System.out.println("Table kind_of_work "+addStr);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Double price = resultSet.getDouble("price");
                System.out.printf("%-6s%-40s%-10.2f BYB%n", id, name,price);
            }
        }

    }

    public static void printOrder(String addStr) throws SQLException{
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("use " + CN.NAME_DB);
            ResultSet resultSet = statement.executeQuery("select * from `order` ");
            System.out.println("Table order "+addStr);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("status");
                Double price = resultSet.getDouble("total_money");
                System.out.printf("%-6s%-40s%-10.2f BYB%n", id, name,price);
            }
        }

    }

}
