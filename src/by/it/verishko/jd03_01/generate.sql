-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema verishko
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `verishko` ;

-- -----------------------------------------------------
-- Schema verishko
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `verishko` DEFAULT CHARACTER SET utf8 ;
USE `verishko` ;

-- -----------------------------------------------------
-- Table `verishko`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `verishko`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `verishko`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `verishko`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `verishko`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `verishko`.`goods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `verishko`.`goods` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `description` VARCHAR(2000) NULL,
  `price` DECIMAL NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_goods_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_goods_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `verishko`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `verishko`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `verishko`;
INSERT INTO `verishko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `verishko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `verishko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `verishko`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `verishko`;
INSERT INTO `verishko`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'administrator', 'adm@mail.ru', 'administrator', 1);
INSERT INTO `verishko`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user', 'user@mail.ru', 'user', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `verishko`.`goods`
-- -----------------------------------------------------
START TRANSACTION;
USE `verishko`;
INSERT INTO `verishko`.`goods` (`id`, `name`, `description`, `price`, `users_id`) VALUES (DEFAULT, 'table', 'my description', 11, 2);

COMMIT;

