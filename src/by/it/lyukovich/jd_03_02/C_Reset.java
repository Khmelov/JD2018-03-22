package by.it.lyukovich.jd_03_02;

import by.it.lyukovich.jd_03_01.C_Init;

import java.sql.*;

public class C_Reset {

    public static void main(String[] args) {
        resetDB();
    }

    public static void resetDB(){

        try (Connection connection =ConnectionCreator.getConnection()){
            Statement statement = connection.createStatement();
            statement.execute("SET foreign_key_checks = 0");
            ResultSet resultSet = statement.executeQuery("SELECT *\n" +
                    "FROM information_schema.tables\n" +
                    "WHERE table_schema='"+C_Init.DB+"'");
            while (resultSet.next()){
                Statement del = connection.createStatement();
                del.execute("DROP TABLE IF EXISTS "+resultSet.getString(3)+"");
                System.out.println("Таблица - " + resultSet.getString(3) + " удалена.");
            }
            statement.execute("SET foreign_key_checks = 1");
            System.out.println("Удаление базы завершено");
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении базы" + e.toString());
        }
    }


}
