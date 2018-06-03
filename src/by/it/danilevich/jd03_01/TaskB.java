package by.it.danilevich.jd03_01;

import java.sql.*;

public class TaskB {
    public static void addRoles() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("use " + CN.NAME_DB);
            // "INSERT INTO `danilevich`.`roles` (`id`, `name`) VALUES (3, 'Admin');
            statement.executeUpdate("insert into roles(name) values ('Director')");
            ResultSet resultSet = statement.executeQuery("select * from roles");
            System.out.println("Table Role");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String id = resultSet.getString("id");
                System.out.printf("%-25s%-20s%n", id, name);
            }
        }
    }
}
