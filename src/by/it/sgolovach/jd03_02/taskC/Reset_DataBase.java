package by.it.sgolovach.jd03_02.taskC;

import by.it.sgolovach.jd03_02.ConnectionCreator;

import java.sql.*;

public class Reset_DataBase {
    public static void main(String[] args) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String delTableAds = "DROP TABLE IF EXISTS `ads`";
            String delTableUsers = "DROP TABLE IF EXISTS `users`";
            String delTableRoles = "DROP TABLE IF EXISTS `roles`";
            String delDataBase = "DROP DATABASE `sgolovach`";

            statement.executeUpdate(delTableAds);
            statement.executeUpdate(delTableUsers);
            statement.executeUpdate(delTableRoles);
            statement.executeUpdate(delDataBase);

            System.out.println("База данных удалена!!!");
        }
    }
}
