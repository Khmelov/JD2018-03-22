package by.it.lyukovich.jd_03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class C_Reset {

    public static void main(String[] args) {
        resetDB();
    }

    public static void resetDB(){
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
                             "jdbc:mysql://127.0.0.1:2016/",
                             "root",
                             "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP DATABASE IF EXISTS "+C_Init.DB+"");
            System.out.println("Удаление базы завершено");
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении базы" + e.toString());
        }
    }


}
