package by.it.romankov.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class AddData {
    public static void main(String[] args) {


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

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/romankov", "root", "")) {
            if (!connection.isClosed()) System.out.println("Соединение с базой установлено");
            Statement statement = connection.createStatement();

          statement.executeUpdate("INSERT INTO `tours`(`id`, `target`, `country`, `city`, `days`, `transport`, `price`, `people_id`) VALUES (DEFAULT,'shopping','Litva','Vilnus',2,'bus',100,8)");
            statement.executeUpdate("INSERT INTO `tours`(`id`, `target`, `country`, `city`, `days`, `transport`, `price`, `people_id`) VALUES (DEFAULT,'shopping','Poland','Belostok',1,'bus',80,9)");
            statement.executeUpdate("INSERT INTO `tours`(`id`, `target`, `country`, `city`, `days`, `transport`, `price`, `people_id`) VALUES (DEFAULT,'excursion','Ukraine','Kiev',4,'bus',200,9)");
            statement.executeUpdate("INSERT INTO `tours`(`id`, `target`, `country`, `city`, `days`, `transport`, `price`, `people_id`) VALUES (DEFAULT,'beach','Spain','Barselona',12,'airplane',1500,12)");
            if (connection.isClosed()) System.out.println("Соединение с базой прервано");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
