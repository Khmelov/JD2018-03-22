package by.it.poprugo.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskA {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql1.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(
              "jdbc:mysql://127.0.0.1:2016/poprugo",
              "root", "")) {

            Statement statement = connection.createStatement();
            /*statement.executeUpdate("");
            вставляем строки из generate БЕЗ ;


            */
            /* было сначала*/
            ResultSet resultSet = statement.executeQuery("select * from users");
            while (resultSet.next()) {
                String txt = resultSet.getString("login") + ":" +
                        resultSet.getNString("email");
                System.out.println(txt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
