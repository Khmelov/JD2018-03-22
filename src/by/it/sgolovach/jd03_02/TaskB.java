package by.it.sgolovach.jd03_02;

import java.sql.*;

public class TaskB {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            int countUsers = 0;
            int countRoles = 0;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users INNER JOIN roles ON users.roles_id=roles.id");
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
//                int columnCount = resultSetMetaData.getColumnCount();
                System.out.print(resultSetMetaData.getColumnLabel(2) + "=" + resultSet.getString(2) + "\t");
                System.out.print(resultSetMetaData.getColumnLabel(7) + "=" + resultSet.getString(7));
                countUsers++;
//                for (int i = 1; i < columnCount+1; i++) {
//                    System.out.print(resultSetMetaData.getColumnLabel(i) + "="+ resultSet.getString(i)+"\t");
//                }
                System.out.println();
            }
            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM roles ");
            while (resultSet1.next()) {
                countRoles++;
            }

            System.out.println("Количество пользователей = " + countUsers + "\n" + "Количество ролей = " + countRoles);

        }

    }
}
