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
            statement.executeUpdate("DROP SCHEMA IF EXISTS `uskoryaev`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `uskoryaev` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `uskoryaev`.`base_face` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `base_face` VARCHAR(100) NULL,\n" +
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
                    "  `phone_number` INT NOT NULL\n" +
                    "  `base_face_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`user_id`),\n" +
                    "  INDEX `fk_user_base_face1_idx` (`base_fase_id` ASC),\n" +
                    "  CONSTRAINT `fk_user_base_face`\n" +
                    "    FOREIGN KEY (`base_face_id`)\n" +
                    "    REFERENCES `uskoryaev`.`base_face` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `uskoryaev`.`car` (\n" +
                    "  `id_car` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `serial_number` VARCHAR(2000) NULL,\n" +
                    "  `brand` VARCHAR(2000) NULL,\n" +
                    "  `model` VARCHAR(2000) NULL,\n" +
                    "  `body_car` VARCHAR(2000) NULL,\n" +
                    "  `year_release` VARCHAR(2000) NULL,\n" +
                    "  `color` VARCHAR(2000) NULL,\n" +
                    "  `user_user_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id_car`),\n" +
                    "  INDEX `fk_car_user_idx` (`user_id` ASC),\n" +
                    "  CONSTRAINT `fk_car_user`\n" +
                    "    FOREIGN KEY (`user_id`)\n" +
                    "    REFERENCES `uskoryev`.`user` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`base_face` (`id`, `base_face`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`base_face` (`id`, `base_face`) VALUES (DEFAULT, 'user')");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`base_face` (`id`, `base_face`) VALUES (DEFAULT, 'guest')");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`user` (`id`, `nick_name`, `email`, `password`,`first_name`,`last_name`,`middle_name`,`phone_number`, `base_face_id`) " +
                    "                                             VALUES (DEFAULT, 'adminitrator', 'adm@mail.ru', 'administrator', '','','','3453554544',1)");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`user` (`id`, `nick_name`, `email`, `password`,`first_name`,`last_name`,`middle_name`,`phone_number`, `base_face_id`) " +
                    "                                             VALUES (DEFAULT, 'alex', 'alex@mail.ru', 'alex', 'alex','smolin','victorovich','444444444444',2)");
            statement.executeUpdate("INSERT INTO `uskoryaev`.`car` (`id`, `serial_number`, `brand`, `model`, `body_car`, `year_realese`, `color`,`user_user_id`) " +
                    "                                VALUES (DEFAULT, '5jh2g45h3g5', mercedes, S-class, coupe, 11.10.2017, black,2)");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
