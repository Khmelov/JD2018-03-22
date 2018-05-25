-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sgolovach
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sgolovach` ;

-- -----------------------------------------------------
-- Schema sgolovach
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sgolovach` DEFAULT CHARACTER SET utf8 ;
USE `sgolovach` ;

-- -----------------------------------------------------
-- Table `sgolovach`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgolovach`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sgolovach`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgolovach`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `sgolovach`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sgolovach`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sgolovach`.`ads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(2000) NULL,
  `rooms` INT NULL,
  `price` DECIMAL NULL,
  `area` DECIMAL NULL,
  `flat` INT NULL,
  `flats` INT NULL,
  `adress` VARCHAR(200) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ads_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `sgolovach`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `sgolovach`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `sgolovach`;
INSERT INTO `sgolovach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `sgolovach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `sgolovach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');
INSERT INTO `sgolovach`.`roles` (`id`, `role`) VALUES (DEFAULT, 'director');

COMMIT;


-- -----------------------------------------------------
-- Data for table `sgolovach`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `sgolovach`;
INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'administrator', 'adm@mail.ru', 'administrator', 1);
INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user', 'user@mail.ru', 'user', 2);
INSERT INTO `sgolovach`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'director', 'director@mail.ru', 'user', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `sgolovach`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `sgolovach`;
INSERT INTO `sgolovach`.`ads` (`id`, `description`, `rooms`, `price`, `area`, `flat`, `flats`, `adress`, `users_id`) VALUES (DEFAULT, 'good flat', 1, 12000, 15, 1, 2, 'minsk, Brikete 2', 2);

COMMIT;

