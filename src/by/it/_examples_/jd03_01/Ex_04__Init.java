package by.it._examples_.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Ex_04__Init {


    public static void main(String[] args) {
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            //пересоздание базы целиком
            statement.executeUpdate("DROP SCHEMA IF EXISTS `akhmelev` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `akhmelev` DEFAULT CHARACTER SET utf8 ;");
            //удаление всех таблиц (если работает удаление схемы то это лишнее)
            statement.executeUpdate("DROP TABLE IF EXISTS `akhmelev`.`ads`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `akhmelev`.`users`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `akhmelev`.`roles`;");
            //генерация всех таблиц
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` (\n" +
                            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `Role` VARCHAR(45) NULL DEFAULT NULL,\n" +
                            "  PRIMARY KEY (`ID`))\n" +
                            "ENGINE = InnoDB\n" +
                            "AUTO_INCREMENT = 1\n" +
                            "DEFAULT CHARACTER SET = utf8;\n"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `akhmelev`.`users` (\n" +
                            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `Login` VARCHAR(45) NULL DEFAULT NULL,\n" +
                            "  `Password` VARCHAR(45) NULL DEFAULT NULL,\n" +
                            "  `Email` VARCHAR(45) NULL DEFAULT NULL,\n" +
                            "  `FK_roles` INT(11) NOT NULL,\n" +
                            "  PRIMARY KEY (`ID`),\n" +
                            "  INDEX `fk_users_FK_rolesx` (`FK_roles` ASC),\n" +
                            "  CONSTRAINT `fk_users_roles`\n" +
                            "    FOREIGN KEY (`FK_roles`)\n" +
                            "    REFERENCES `akhmelev`.`roles` (`ID`))\n" +
                            "ENGINE = InnoDB\n" +
                            "AUTO_INCREMENT = 1\n" +
                            "DEFAULT CHARACTER SET = utf8;\n"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `akhmelev`.`ads` (\n" +
                            "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                            "  `RoomCount` INT(11) NULL DEFAULT NULL,\n" +
                            "  `Floor` INT(11) NULL DEFAULT NULL,\n" +
                            "  `Floors` INT(11) NULL DEFAULT NULL,\n" +
                            "  `Price` DOUBLE NULL DEFAULT NULL,\n" +
                            "  `Area` DOUBLE NULL DEFAULT NULL,\n" +
                            "  `Description` VARCHAR(5000) NULL DEFAULT NULL,\n" +
                            "  `Address` VARCHAR(200) NULL DEFAULT NULL,\n" +
                            "  `FK_users` INT(11) NOT NULL,\n" +
                            "  PRIMARY KEY (`ID`),\n" +
                            "  INDEX `fk_ads_users1_idx` (`FK_users` ASC),\n" +
                            "  CONSTRAINT `fk_ads_users1`\n" +
                            "    FOREIGN KEY (`FK_users`)\n" +
                            "    REFERENCES `akhmelev`.`users` (`ID`)\n" +
                            "    ON DELETE CASCADE\n" +
                            "    ON UPDATE CASCADE)\n" +
                            "ENGINE = InnoDB\n" +
                            "AUTO_INCREMENT = 17\n" +
                            "DEFAULT CHARACTER SET = utf8;\n"
            );
            //заполнение строками
            statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Admin');\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'Admin', 'admin', 'adm@it.by', 1);\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'User', 'user', 'user@it.by', 2);\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`ads` (`ID`, `RoomCount`, `Floor`, `Floors`, `Price`, `Area`, `Description`, `Address`, `FK_users`) VALUES (DEFAULT, 1, 2, 5, 55555, 50, 'Тестовое объявление', 'Кнорина 9', 2);\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
