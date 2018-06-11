package by.it.lyukovich.jd_03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class С_Delete {
    public static void main(String[] args) {
        deleteDataRows();
    }

    /**
     * Deletes all rows in all tables and sets Auto Increment to 1
     */
    public static void deleteDataRows(){
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
                             "jdbc:mysql://127.0.0.1:2016/"+C_Init.DB+"",
                             "root",
                             "")) {
            Statement statement = connection.createStatement();
            String s1="SET foreign_key_checks = 0";
            statement.addBatch(s1);
            String[] tables= {"books", "bookscount", "buyinfo", "category", "currentorders", "pendingorders", "roles",
                    "users", "authors"};
            for (String t: tables) {
                String str="DELETE FROM " + t;
                statement.addBatch(str);
                statement.addBatch("ALTER TABLE "+t+" AUTO_INCREMENT = 1"); //Sets auto increment to 1
            }
            String s2="SET foreign_key_checks = 1";
            statement.addBatch(s2);;
            statement.executeBatch();
            connection.close();
            System.out.println("Удаление данных завершено");
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении данных " + e.toString());
        }
    }
}
