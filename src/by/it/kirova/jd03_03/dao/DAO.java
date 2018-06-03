package by.it.kirova.jd03_03.dao;

import by.it.kirova.jd03_03.dao.daobeans.*;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DAO {

    private static DAO dao;

    private DAO() {
        role = new RoleDAO();
        user = new UserDAO();
        hotel = new HotelDAO();
        room = new RoomDAO();
        reservation = new ReservationDAO();
    }

    public RoleDAO role;
    public UserDAO user;
    public HotelDAO hotel;
    public RoomDAO room;
    public ReservationDAO reservation;


    public static DAO getInstanceDAO() {
        if (dao == null)
            synchronized (DAO.class) {
                if (dao == null)
                    dao = new DAO();
            }
        return dao;
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
            statement.executeUpdate("DROP DATABASE kirova");

            statement.executeUpdate("CREATE DATABASE kirova");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `kirova`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `kirova` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kirova`.`role` (\n" +
                    "  `role_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role_name` VARCHAR(60) NOT NULL,\n" +
                    "  PRIMARY KEY (`role_id`),\n" +
                    "  UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `kirova`.`user` (\n" +
                    "  `user_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `email` VARCHAR(70) NOT NULL,\n" +
                    "  `password` VARCHAR(30) NOT NULL,\n" +
                    "  `first_name` VARCHAR(45) NOT NULL,\n" +
                    "  `last_name` VARCHAR(45) NOT NULL,\n" +
                    "  `middle_name` VARCHAR(45) NULL,\n" +
                    "  `residence_country` VARCHAR(45) NOT NULL,\n" +
                    "  `phone_number` VARCHAR(45) NOT NULL,\n" +
                    "  `role_role_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`user_id`),\n" +
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC),\n" +
                    "  INDEX `fk_users_role1_idx` (`role_role_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_role1`\n" +
                    "    FOREIGN KEY (`role_role_id`)\n" +
                    "    REFERENCES `kirova`.`role` (`role_id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
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
                    "    REFERENCES `kirova`.`user` (`user_id`)\n" +
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
                    "ENGINE = InnoDB;\n");
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
                    "    REFERENCES `kirova`.`user` (`user_id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `kirova`.`role` (`role_id`, `role_name`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `kirova`.`role` (`role_id`, `role_name`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `kirova`.`role` (`role_id`, `role_name`) VALUES (DEFAULT, 'owner');");
            statement.executeUpdate("INSERT INTO `kirova`.`role` (`role_id`, `role_name`) VALUES (DEFAULT, 'guest');");

            statement.executeUpdate("INSERT INTO `kirova`.`user` (`user_id`, `email`, `password`, `first_name`, `last_name`, `middle_name`, `residence_country`, `phone_number`, `role_role_id`) VALUES (DEFAULT, 'abc@gmail.com', 'abc123', 'John', 'Smith', NULL, 'UK', '+447874564567',1);");
            statement.executeUpdate("INSERT INTO `kirova`.`user` (`user_id`, `email`, `password`, `first_name`, `last_name`, `middle_name`, `residence_country`, `phone_number`, `role_role_id`) VALUES (DEFAULT, 'def@gmail.com', 'def123', 'Jacob', 'Irwin', NULL, 'Poland', '+485291111111',2);");
            statement.executeUpdate("INSERT INTO `kirova`.`user` (`user_id`, `email`, `password`, `first_name`, `last_name`, `middle_name`, `residence_country`, `phone_number`, `role_role_id`) VALUES (DEFAULT, 'hij@gmail.com', 'hij123', 'Aleksandr', 'Aleksandrov', 'Aleksandrovich', 'Belarus', '+375291111111',3);");
            statement.executeUpdate("INSERT INTO `kirova`.`user` (`user_id`, `email`, `password`, `first_name`, `last_name`, `middle_name`, `residence_country`, `phone_number`, `role_role_id`) VALUES (DEFAULT, 'klm@gmail.com', 'klm123', 'John', 'Smith', NULL, 'Austria', '+437874589567',3);");
            statement.executeUpdate("INSERT INTO `kirova`.`user` (`user_id`, `email`, `password`, `first_name`, `last_name`, `middle_name`, `residence_country`, `phone_number`, `role_role_id`) VALUES (DEFAULT, 'rst@gmail.com', 'rst123', 'Petr', 'Petrov', 'Petrovich', 'Belarus', '+375292222222',2);");
            statement.executeUpdate("INSERT INTO `kirova`.`user` (`user_id`, `email`, `password`, `first_name`, `last_name`, `middle_name`, `residence_country`, `phone_number`, `role_role_id`) VALUES (DEFAULT, 'nop@gmail.com', 'nop123', 'Ivan', 'Ivanov', 'Ivanovich', 'Russia', '+749597556983',2);");

            statement.executeUpdate("INSERT INTO `kirova`.`hotel` (`hotel_id`, `hotel_name`, `hotel_type`, `star_rating`, `country`, `city`, `street`, `house_number`, `contact_email`, `contact_phone_number`, `user_user_id`) VALUES (DEFAULT, 'Resort Spa', 'Hotel', 5, 'Russia', 'Moscow', 'Horkogo', '82', 'spa@gmail.com', '+7395975339983', 3);");
            statement.executeUpdate("INSERT INTO `kirova`.`hotel` (`hotel_id`, `hotel_name`, `hotel_type`, `star_rating`, `country`, `city`, `street`, `house_number`, `contact_email`, `contact_phone_number`, `user_user_id`) VALUES (DEFAULT, 'Resort Appartment', 'Appartment', NULL, 'Austria', 'Vienna', 'Bahgasse', '4', 'weinapart@gmail.com', '+4395975339983', 4);");
            statement.executeUpdate("INSERT INTO `kirova`.`hotel` (`hotel_id`, `hotel_name`, `hotel_type`, `star_rating`, `country`, `city`, `street`, `house_number`, `contact_email`, `contact_phone_number`, `user_user_id`) VALUES (DEFAULT, 'Spa Appartment', 'Appartment', NULL, 'Austria', 'Vienna', 'Johann-Hoffmann Platz', '16', 'weinapart@gmail.com', '+4395975339983', 4);");

            statement.executeUpdate("INSERT INTO `kirova`.`room` (`room_id`, `room_name`, `room_fact_number`, `people_amount`, `description`, `cost`, `hotel_hotel_id`) VALUES (DEFAULT, 'Room with a single bed', '100', 1, 'breakfast included', 50, 1);");
            statement.executeUpdate("INSERT INTO `kirova`.`room` (`room_id`, `room_name`, `room_fact_number`, `people_amount`, `description`, `cost`, `hotel_hotel_id`) VALUES (DEFAULT, 'Room with 2 double beds', '200', 4, NULL, 110, 1);");
            statement.executeUpdate("INSERT INTO `kirova`.`room` (`room_id`, `room_name`, `room_fact_number`, `people_amount`, `description`, `cost`, `hotel_hotel_id`) VALUES (DEFAULT, 'Apartment with terrace', NULL, 2, 'Apartment in heart of Vienna with terrace, double bed and kitchen', 90, 2);");
            statement.executeUpdate("INSERT INTO `kirova`.`room` (`room_id`, `room_name`, `room_fact_number`, `people_amount`, `description`, `cost`, `hotel_hotel_id`) VALUES (DEFAULT, 'Two-Bedroom apartment', NULL, 4, 'Apartment in heart of Vienna with 2 double beds and kitchen', 150, 2);");

            statement.executeUpdate("INSERT INTO `kirova`.`reservation` (`reservation_id`, `reservation_date`, `check_in_date`, `check_out_date`, `total_cost`, `room_room_id`, `user_user_id`) VALUES (DEFAULT, 61481855662587, 61492914887284, 61493174113533, 270, 3, 2);");
            statement.executeUpdate("INSERT INTO `kirova`.`reservation` (`reservation_id`, `reservation_date`, `check_in_date`, `check_out_date`, `total_cost`, `room_room_id`, `user_user_id`) VALUES (DEFAULT, 61484793462731, 61493606288358, 61493692701377, 90, 2, 5);");
            statement.executeUpdate("INSERT INTO `kirova`.`reservation` (`reservation_id`, `reservation_date`, `check_in_date`, `check_out_date`, `total_cost`, `room_room_id`, `user_user_id`) VALUES (DEFAULT, 61486867235416, 61493260856405, 61493347273586, 50, 1, 2);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

