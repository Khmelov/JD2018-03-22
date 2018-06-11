package by.it.fando.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class C_Init {

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
            statement.executeUpdate("DROP SCHEMA IF EXISTS `fando`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `fando` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `fando`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `fando`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NOT NULL,\n" +
                    "  `email` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `fando`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `fando`.`ads` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `description` VARCHAR(2000) NULL,\n" +
                    "  `rooms` INT NULL,\n" +
                    "  `price` DECIMAL NULL,\n" +
                    "  `area` DECIMAL NULL,\n" +
                    "  `flat` INT NULL,\n" +
                    "  `flats` INT NULL,\n" +
                    "  `address` VARCHAR(200) NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_ads_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_ads_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `fando`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `fando`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `fando`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user')");
            statement.executeUpdate("INSERT INTO `fando`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest')");
            statement.executeUpdate("INSERT INTO `fando`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'admin', 'adm@mail.ru', 'admin', 1)");
            statement.executeUpdate("INSERT INTO `fando`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user', 'user@mail.ru', 'user', 2)");
            statement.executeUpdate("INSERT INTO `fando`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `address`, `users_id`) VALUES (DEFAULT, '10th floor', 1, 20000, 50, 1, 1, 'Pushkin, 1', 2)");
            statement.executeUpdate("INSERT INTO `fando`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `address`, `users_id`) VALUES (DEFAULT, '5th floor', 1, 30000, 60, 1, 1, 'Lermontov, 2', 2)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
