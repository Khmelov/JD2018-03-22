package by.it.lyukovich.jd_03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class B_AddRoles {
    public static void main(String[] args) {
        addRoles();
    }

    public static void addRoles() {
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
            statement.executeUpdate("INSERT INTO `roles` (`roleid`, `rolename`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `roles` (`roleid`, `rolename`) VALUES (DEFAULT, 'moderator')");
            statement.executeUpdate("INSERT INTO `roles` (`roleid`, `rolename`) VALUES (DEFAULT, 'user')");
            connection.close();
            System.out.println("Создание ролей выполнено");
        } catch (SQLException e) {
            if (e.toString().contains("Duplicate entry")){System.out.println("Дублирование ролей");}
            else System.out.println("При создании ролей возникла ошибка" + e.toString());
        }
    }


}
