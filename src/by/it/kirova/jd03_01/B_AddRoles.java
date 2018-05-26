package by.it.kirova.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class B_AddRoles {
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


        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/",
                             "root",
                             "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS kirova");
            statement.executeUpdate("USE kirova");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS kirova.role (" +
                    "role_id INT NOT NULL AUTO_INCREMENT," +
                    "role_name VARCHAR(60) NOT NULL," +
                    "PRIMARY KEY (role_id)," +
                    "UNIQUE INDEX role_name_UNIQUE (role_name ASC))");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS kirova.role_has_users (\n" +
                    "  role_role_id INT NOT NULL," +
                    "  users_user_id INT NOT NULL," +
                    "  PRIMARY KEY (role_role_id, users_user_id)," +
                    "  INDEX fk_role_has_users_users1_idx (users_user_id ASC)," +
                    "  INDEX fk_role_has_users_role1_idx (role_role_id ASC)," +
                    "  CONSTRAINT fk_role_has_users_role1" +
                    "    FOREIGN KEY (role_role_id)" +
                    "    REFERENCES kirova.role (role_id)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT," +
                    "  CONSTRAINT fk_role_has_users_users1" +
                    "    FOREIGN KEY (users_user_id)" +
                    "    REFERENCES kirova.users (user_id)" +
                    "    ON DELETE RESTRICT" +
                    "    ON UPDATE RESTRICT)");
            statement.executeUpdate("INSERT INTO kirova.role (role_id, role_name) VALUES (default, 'admin')");
            statement.executeUpdate("INSERT INTO kirova.role (role_id, role_name) VALUES (default, 'user')");
            statement.executeUpdate("INSERT INTO kirova.role (role_id, role_name) VALUES (default, 'guest')");
            statement.executeUpdate("INSERT INTO kirova.role_has_users (role_role_id, users_user_id) VALUES (1, 1)");
            statement.executeUpdate("INSERT INTO kirova.role_has_users (role_role_id, users_user_id) VALUES (2, 1)");
            statement.executeUpdate("INSERT INTO kirova.role_has_users (role_role_id, users_user_id) VALUES (2, 2)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}