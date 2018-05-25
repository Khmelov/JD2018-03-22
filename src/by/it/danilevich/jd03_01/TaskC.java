package by.it.danilevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskC {
    public static void deleteDateBase(){

    }

    public static void createDateBase() {
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
                     DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB)) {
            Statement statement = connection.createStatement();
            //statement.executeUpdate("CREATE DATABASE IF NOT EXISTS danilevich");
            //statement.executeUpdate("DROP SCHEMA IF EXISTS `danilevich`");
            //statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `danilevich` DEFAULT CHARACTER SET utf8");

            //statement.executeUpdate("CREATE TABLE IF NOT EXISTS `category_work`(`id` INT not NULL AUTO_INCREMENT,`name` VARCHAR(45) NULL, PRIMARY KEY (`id`))");
            System.out.println("Add table category");

        }
        catch (SQLException e1) {

            e1.printStackTrace();
        }


    }
}
