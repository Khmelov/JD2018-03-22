package by.it.kirova.jd03_02;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class C_DBInitWithoutData {
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
            statement.executeUpdate("CREATE DATABASE kirova");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `kirova`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `kirova` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kirova`.`role` (\n" +
                    "  `role_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role_name` VARCHAR(60) NOT NULL,\n" +
                    "  PRIMARY KEY (`role_id`),\n" +
                    "  UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kirova`.`users` (\n" +
                    "  `user_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `email` VARCHAR(70) NOT NULL,\n" +
                    "  `password` VARCHAR(30) NOT NULL,\n" +
                    "  `first_name` VARCHAR(45) NOT NULL,\n" +
                    "  `last_name` VARCHAR(45) NOT NULL,\n" +
                    "  `middle_name` VARCHAR(45) NULL,\n" +
                    "  `residence_country` VARCHAR(45) NOT NULL,\n" +
                    "  `phone_number` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`user_id`),\n" +
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kirova`.`hotel` (\n" +
                    "  `hotel_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `hotel_name` VARCHAR(100) NOT NULL,\n" +
                    "  `hotel_type` VARCHAR(45) NOT NULL,\n" +
                    "  `star_rating` INT NULL,\n" +
                    "  `country` VARCHAR(45) NOT NULL,\n" +
                    "  `city` VARCHAR(45) NOT NULL,\n" +
                    "  `street` VARCHAR(100) NOT NULL,\n" +
                    "  `house_number` VARCHAR(45) NOT NULL,\n" +
                    "  `contact_email` VARCHAR(45) NOT NULL,\n" +
                    "  `contact_phone_number` VARCHAR(45) NOT NULL,\n" +
                    "  `user_user_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`hotel_id`),\n" +
                    "  INDEX `fk_hotel_user1_idx` (`user_user_id` ASC),\n" +
                    "  CONSTRAINT `fk_hotel_user1`\n" +
                    "    FOREIGN KEY (`user_user_id`)\n" +
                    "    REFERENCES `kirova`.`users` (`user_id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kirova`.`room` (\n" +
                    "  `room_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `room_name` VARCHAR(200) NOT NULL,\n" +
                    "  `room_fact_number` VARCHAR(10) NULL,\n" +
                    "  `people_amount` INT NOT NULL,\n" +
                    "  `description` VARCHAR(1000) NULL,\n" +
                    "  `cost` DECIMAL NOT NULL,\n" +
                    "  `hotel_hotel_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`room_id`),\n" +
                    "  INDEX `fk_room_hotel1_idx` (`hotel_hotel_id` ASC),\n" +
                    "  CONSTRAINT `fk_room_hotel1`\n" +
                    "    FOREIGN KEY (`hotel_hotel_id`)\n" +
                    "    REFERENCES `kirova`.`hotel` (`hotel_id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kirova`.`reservation` (\n" +
                    "  `reservation_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `reservation_date` LONG NOT NULL,\n" +
                    "  `check_in_date` LONG NOT NULL,\n" +
                    "  `check_out_date` LONG NOT NULL,\n" +
                    "  `total_cost` DECIMAL NOT NULL,\n" +
                    "  `room_room_id` INT NOT NULL,\n" +
                    "  `user_user_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`reservation_id`),\n" +
                    "  INDEX `fk_reservation_room1_idx` (`room_room_id` ASC),\n" +
                    "  INDEX `fk_reservation_user1_idx` (`user_user_id` ASC),\n" +
                    "  CONSTRAINT `fk_reservation_room1`\n" +
                    "    FOREIGN KEY (`room_room_id`)\n" +
                    "    REFERENCES `kirova`.`room` (`room_id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_reservation_user1`\n" +
                    "    FOREIGN KEY (`user_user_id`)\n" +
                    "    REFERENCES `kirova`.`users` (`user_id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kirova`.`role_has_users` (\n" +
                    "  `role_role_id` INT NOT NULL,\n" +
                    "  `users_user_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`role_role_id`, `users_user_id`),\n" +
                    "  INDEX `fk_role_has_users_users1_idx` (`users_user_id` ASC),\n" +
                    "  INDEX `fk_role_has_users_role1_idx` (`role_role_id` ASC),\n" +
                    "  CONSTRAINT `fk_role_has_users_role1`\n" +
                    "    FOREIGN KEY (`role_role_id`)\n" +
                    "    REFERENCES `kirova`.`role` (`role_id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_role_has_users_users1`\n" +
                    "    FOREIGN KEY (`users_user_id`)\n" +
                    "    REFERENCES `kirova`.`users` (`user_id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
