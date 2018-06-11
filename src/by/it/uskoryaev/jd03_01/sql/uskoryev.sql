-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema uskoryaev
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `uskoryaev` ;

-- -----------------------------------------------------
-- Schema uskoryaev
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `uskoryaev` DEFAULT CHARACTER SET utf8 ;
USE `uskoryaev` ;

-- -----------------------------------------------------
-- Table `uskoryaev`.`base_face`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `uskoryaev`.`base_face` ;

CREATE TABLE IF NOT EXISTS `uskoryaev`.`base_face` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `base_face` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uskoryaev`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `uskoryaev`.`user` ;

CREATE TABLE IF NOT EXISTS `uskoryaev`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `nick_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `middle_name` VARCHAR(45) NULL,
  `phone_number` INT NULL,
  `base_face_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_user_base_face1_idx` (`base_face_id` ASC),
  CONSTRAINT `fk_user_base_face1`
    FOREIGN KEY (`base_face_id`)
    REFERENCES `uskoryaev`.`base_face` (`user_id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `uskoryaev`.`car`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `uskoryaev`.`car` ;

CREATE TABLE IF NOT EXISTS `uskoryaev`.`car` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `serial_number` VARCHAR(45) NULL,
  `brand` VARCHAR(45) NULL,
  `model` VARCHAR(45) NULL,
  `body_car` VARCHAR(45) NULL,
  `year_release` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  `user_user_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  INDEX `fk_car_user_idx` (`user_user_id` ASC),
  CONSTRAINT `fk_car_user`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `uskoryaev`.`user` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `uskoryaev`.`base_face`
-- -----------------------------------------------------
START TRANSACTION;
USE `uskoryaev`;
INSERT INTO `uskoryaev`.`base_face` (`user_id`, `base_face`) VALUES (DEFAULT, 'admin');
INSERT INTO `uskoryaev`.`base_face` (`user_id`, `base_face`) VALUES (DEFAULT, 'user');
INSERT INTO `uskoryaev`.`base_face` (`user_id`, `base_face`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `uskoryaev`.`user`
-- -----------------------------------------------------
START TRANSACTION;
USE `uskoryaev`;
INSERT INTO `uskoryaev`.`user` (`user_id`, `nick_name`, `email`, `password`, `first_name`, `last_name`, `middle_name`, `phone_number`, `base_face_id`) VALUES (DEFAULT, 'user', 'alex@mail.ru', 'zzzxxxccc', 'alex', 'smolin', 'victorovich', 322343477744, 2);
INSERT INTO `uskoryaev`.`user` (`user_id`, `nick_name`, `email`, `password`, `first_name`, `last_name`, `middle_name`, `phone_number`, `base_face_id`) VALUES (DEFAULT, 'admin', 'amin@mail.ru', 'admin', 'admin', 'admin', 'admin', 3423424234242, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `uskoryaev`.`car`
-- -----------------------------------------------------
START TRANSACTION;
USE `uskoryaev`;
INSERT INTO `uskoryaev`.`car` (`user_id`, `serial_number`, `brand`, `model`, `body_car`, `year_release`, `color`, `user_user_id`) VALUES (DEFAULT, '34hjbch54c', 'mercdes', 'S-class', 'coupe', '2017', 'black', 2);

COMMIT;

