-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema desykevich
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `desykevich` ;

-- -----------------------------------------------------
-- Schema desykevich
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `desykevich` DEFAULT CHARACTER SET utf8 ;
USE `desykevich` ;

-- -----------------------------------------------------
-- Table `desykevich`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desykevich`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desykevich`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desykevich`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `phonenumber` VARCHAR(45) NOT NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `desykevich`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desykevich`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desykevich`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `desykevich`.`ads`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `desykevich`.`ads` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(2000) NOT NULL,
  `price` DECIMAL NOT NULL,
  `users_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_ads_users1_idx` (`users_id` ASC),
  INDEX `fk_ads_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `desykevich`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_ads_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `desykevich`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `desykevich`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `desykevich`;
INSERT INTO `desykevich`.`roles` (`id`, `role`) VALUES (1, 'admin');
INSERT INTO `desykevich`.`roles` (`id`, `role`) VALUES (2, 'user');
INSERT INTO `desykevich`.`roles` (`id`, `role`) VALUES (3, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `desykevich`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `desykevich`;
INSERT INTO `desykevich`.`users` (`id`, `login`, `password`, `email`, `nickname`, `phonenumber`, `roles_id`) VALUES (1, 'admin', '1234', 'admin@tut.by', 'administrator', DEFAULT, 1);
INSERT INTO `desykevich`.`users` (`id`, `login`, `password`, `email`, `nickname`, `phonenumber`, `roles_id`) VALUES (2, 'user', 'user', 'user01@mail.com', 'sergei', DEFAULT, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `desykevich`.`category`
-- -----------------------------------------------------
START TRANSACTION;
USE `desykevich`;
INSERT INTO `desykevich`.`category` (`id`, `name`) VALUES (1, 'phone');
INSERT INTO `desykevich`.`category` (`id`, `name`) VALUES (2, 'laptop');
INSERT INTO `desykevich`.`category` (`id`, `name`) VALUES (3, 'backpack');
INSERT INTO `desykevich`.`category` (`id`, `name`) VALUES (4, 'smart bracelet');

COMMIT;


-- -----------------------------------------------------
-- Data for table `desykevich`.`ads`
-- -----------------------------------------------------
START TRANSACTION;
USE `desykevich`;
INSERT INTO `desykevich`.`ads` (`id`, `title`, `description`, `price`, `users_id`, `category_id`) VALUES (1, 'Samsung Galaxy S9', 'Android, экран 5.8\" AMOLED (1440x2960), Exynos 9810, ОЗУ 4 ГБ, флэш-память 64 ГБ, карты памяти, камера 12 Мп, аккумулятор 3000 мАч, 2 SIM, цвет черный', 1650, 1, 1);
INSERT INTO `desykevich`.`ads` (`id`, `title`, `description`, `price`, `users_id`, `category_id`) VALUES (2, 'Huawei P20 Lite ', 'Android, экран 5.84\" IPS (1080x2280), HiSilicon Kirin 659, ОЗУ 4 ГБ, флэш-память 64 ГБ, карты памяти, камера 16 Мп, аккумулятор 3000 мАч, 2 SIM, цвет черный', 650, 2, 2);

COMMIT;

