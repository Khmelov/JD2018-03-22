package by.it.uskoryaev.project.java.dao;

import by.it.uskoryaev.project.java.dao.daobeans.BaseFaceDAO;
import by.it.uskoryaev.project.java.dao.daobeans.CarDAO;
import by.it.uskoryaev.project.java.dao.daobeans.UserDAO;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DAO {

    private static DAO dao;

    public BaseFaceDAO baseFace;
    public UserDAO user;
    public CarDAO car;


    private DAO() {
        baseFace = new BaseFaceDAO();
        user = new UserDAO();
        car = new CarDAO();

    }

    public static DAO getInstanceDao() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null)
                    dao = new DAO();
            }
        }
        return dao;
    }

    public void reset() {
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
            statement.executeUpdate("DROP DATABASE uskoryev");

            statement.executeUpdate("CREATE DATABASE uskoryaev");
            statement.executeUpdate("DROP SCHEMA IF EXISTS `uskoryaev`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `uskoryaev` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `uskoryaev`.`base_face` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `base_face` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `uskoryaev`.`user` (\n" +
                    "  `user_id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `nick_name` VARCHAR(45) NOT NULL,\n" +
                    "  `email` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `first_name` VARCHAR(45) NOT NULL,\n" +
                    "  `last_name` VARCHAR(45) NOT NULL,\n" +
                    "  `middle_name` VARCHAR(45) NOT NULL,\n" +
                    "  `phone_number` VARCHAR(45) NOT NULL\n" +
                    "  `base_face_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`user_id`),\n" +
                    "  INDEX `fk_user_base_face1_idx` (`base_fase_id` ASC),\n" +
                    "  CONSTRAINT `fk_user_base_face1`\n" +
                    "    FOREIGN KEY (`base_face_id`)\n" +
                    "    REFERENCES `uskoryaev`.`base_face` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `uskoryaev`.`car` (\n" +
                    "  `id_car` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `serial_number` VARCHAR(45) NOT NULL,\n" +
                    "  `brand` VARCHAR(45) NOT NULL,\n" +
                    "  `model` VARCHAR(45) NOT NULL,\n" +
                    "  `body_car` VARCHAR(45) NOT NULL,\n" +
                    "  `year_release` VARCHAR(45) NOT NULL,\n" +
                    "  `color` VARCHAR(45) NOT NULL,\n" +
                    "  `user_user_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id_car`),\n" +
                    "  INDEX `fk_car_user_idx` (`id` ASC),\n" +
                    "  CONSTRAINT `fk_car_user`\n" +
                    "    FOREIGN KEY (`user_user_id`)\n" +
                    "    REFERENCES `uskoryev`.`user` (`user_id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`base_face` (`id`, `base_face`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`base_face` (`id`, `base_face`) VALUES (DEFAULT, 'user')");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`base_face` (`id`, `base_face`) VALUES (DEFAULT, 'guest')");

            statement.executeUpdate("INSERT INTO `uskoryaev`.`user` (`user_id`, `nick_name`, `email`, `password`,`first_name`,`last_name`,`middle_name`,`phone_number`, `base_face_id`) VALUES (DEFAULT, 'adm', 'adm@mail.ru', 'adm', 'adm','adm','adm','123',1)");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`user` (`user_id`, `nick_name`, `email`, `password`,`first_name`,`last_name`,`middle_name`,`phone_number`, `base_face_id`) VALUES (DEFAULT, 'user', 'user@mail.ru', 'user', 'user','user','user','456',2)");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`user` (`user_id`, `nick_name`, `email`, `password`,`first_name`,`last_name`,`middle_name`,`phone_number`, `base_face_id`) VALUES (DEFAULT, 'guest', 'guest@mail.ru', 'guest', 'guest','guest','guest','789',3)");

            statement.executeUpdate("INSERT INTO `uskoryaev`.`car` (`id_car`, `serial_number`, `brand`, `model`, `body_car`, `year_realese`, `color`,`user_user_id`) VALUES (DEFAULT, '5jh222223g5', 'mercedes', 'S-class', 'coupe', '11.10.2017', 'black',2)");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`car` (`id_car`, `serial_number`, `brand`, `model`, `body_car`, `year_realese`, `color`,`user_user_id`) VALUES (DEFAULT, '5jh000003g5', 'mercedes', 'c-class', 'coupe', '11.10.2017', 'red',2)");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`car` (`id_car`, `serial_number`, `brand`, `model`, `body_car`, `year_realese`, `color`,`user_user_id`) VALUES (DEFAULT, '5jh111113g5', 'mercedes', 'M-class', 'coupe', '11.10.2017', 'grey',2)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
