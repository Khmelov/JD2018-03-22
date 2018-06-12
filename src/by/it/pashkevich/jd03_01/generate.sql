-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema pashkevich
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pashkevich` ;

-- -----------------------------------------------------
-- Schema pashkevich
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pashkevich` DEFAULT CHARACTER SET utf8 ;
USE `pashkevich` ;

-- -----------------------------------------------------
-- Table `pashkevich`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pashkevich`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pashkevich`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pashkevich`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_users_roles_idx` (`roles_id` ASC),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `pashkevich`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pashkevich`.`goods`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pashkevich`.`goods` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `description` VARCHAR(2000) NULL,
  `price` DECIMAL NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_goods_users1_idx` (`users_id` ASC),
  CONSTRAINT `fk_goods_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `pashkevich`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `pashkevich`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `pashkevich`;
INSERT INTO `pashkevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `pashkevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `pashkevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `pashkevich`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `pashkevich`;
INSERT INTO `pashkevich`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'administrator', 'adm@mail.ru', 'administrator', 1);
INSERT INTO `pashkevich`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'user', 'user@mail.ru', 'user', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `pashkevich`.`goods`
-- -----------------------------------------------------
START TRANSACTION;
USE `pashkevich`;
INSERT INTO `pashkevich`.`goods` (`id`, `name`, `description`, `price`, `users_id`) VALUES (DEFAULT, 'table', 'my description', 11, 2);

COMMIT;

