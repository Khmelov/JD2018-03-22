-- -----------------------------------------------------
-- Table `akhmelev`.`roles`
-- -----------------------------------------------------
--DROP TABLE IF EXISTS `akhmelev`.`ads` ;
--DROP TABLE IF EXISTS `akhmelev`.`users` ;
--DROP TABLE IF EXISTS `akhmelev`.`roles` ;

DROP SCHEMA IF EXISTS `akhmelev` ;

-- -----------------------------------------------------
-- Schema akhmelev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `akhmelev` DEFAULT CHARACTER SET utf8;

-- -----------------------------------------------------
-- Table `akhmelev`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `akhmelev`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`users` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL DEFAULT NULL,
  `Password` VARCHAR(45) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `FK_roles` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_FK_rolesx` (`FK_roles` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`FK_roles`)
    REFERENCES `akhmelev`.`roles` (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `akhmelev`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `akhmelev`.`ads` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `RoomCount` INT(11) NULL DEFAULT NULL,
  `Floor` INT(11) NULL DEFAULT NULL,
  `Floors` INT(11) NULL DEFAULT NULL,
  `Price` DOUBLE NULL DEFAULT NULL,
  `Area` DOUBLE NULL DEFAULT NULL,
  `Description` VARCHAR(5000) NULL DEFAULT NULL,
  `Address` VARCHAR(200) NULL DEFAULT NULL,
  `FK_users` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ads_users1_idx` (`FK_users` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`FK_users`)
    REFERENCES `akhmelev`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `akhmelev`;
INSERT INTO `akhmelev`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Admin');
INSERT INTO `akhmelev`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');
INSERT INTO `akhmelev`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `akhmelev`.`users`
-- -----------------------------------------------------
INSERT INTO `akhmelev`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'Admin', 'admin', 'adm@it.by', 1);
INSERT INTO `akhmelev`.`users` (`ID`, `Login`, `Password`, `Email`, `FK_roles`) VALUES (DEFAULT, 'User', 'user', 'user@it.by', 2);



-- -----------------------------------------------------
-- Data for table `akhmelev`.`ads`
-- -----------------------------------------------------
INSERT INTO `akhmelev`.`ads` (`ID`, `RoomCount`, `Floor`, `Floors`, `Price`, `Area`, `Description`, `Address`, `FK_users`) VALUES (DEFAULT, 1, 2, 5, 55555, 50, 'Тестовое объявление', 'Кнорина 9', 2);

