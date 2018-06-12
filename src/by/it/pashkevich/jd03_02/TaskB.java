package by.it.pashkevich.jd03_02;

import java.sql.*;

public class TaskB {

    private static int userCount = 0;

    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String query = "SELECT login, email, role FROM users INNER JOIN roles ON users.roles_ID=roles.ID;";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                userCount++;
                ResultSetMetaData meta = result.getMetaData();
                int cols = meta.getColumnCount();
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%s: %-20s\t", meta.getColumnLabel(i), result.getString(i));
                }
                System.out.println();
            }
            System.out.println("Total users: " + userCount);
            result = statement.executeQuery("SELECT COUNT(ID) FROM roles;");
            if (result.next()) {
                System.out.printf("Number of possible roles: %d\n", result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}