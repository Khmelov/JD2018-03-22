-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema asdas
-- -----------------------------------------------------
SHOW WARNINGS;
-- -----------------------------------------------------
-- Schema danilevich
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `danilevich` ;

-- -----------------------------------------------------
-- Schema danilevich
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `danilevich` DEFAULT CHARACTER SET utf8 ;
SHOW WARNINGS;
USE `danilevich` ;

-- -----------------------------------------------------
-- Table `danilevich`.`kind_of_work`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `danilevich`.`kind_of_work` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `danilevich`.`kind_of_work` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `price` DECIMAL(6,0) NOT NULL,
  `time_norm` DECIMAL(6,0) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `unit` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `danilevich`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `danilevich`.`role` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `danilevich`.`role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `danilevich`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `danilevich`.`user` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `danilevich`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `role_id` INT(11) NULL DEFAULT NULL,
  `address` VARCHAR(60) NULL DEFAULT NULL,
  `telephone` VARCHAR(25) NULL DEFAULT NULL,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Users_Role_idx` (`role_id` ASC),
  CONSTRAINT `fk_Users_Role`
    FOREIGN KEY (`role_id`)
    REFERENCES `danilevich`.`role` (`id`)
    ON DELETE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `danilevich`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `danilevich`.`order` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `danilevich`.`order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `date_order` DATE NULL DEFAULT NULL,
  `client_id` INT(11) NULL DEFAULT NULL,
  `kind_of_work_id` INT(11) NULL DEFAULT NULL,
  `executor_id` INT(11) NULL DEFAULT NULL,
  `admin_id` INT(11) NULL DEFAULT NULL,
  `begin_work` DATE NULL DEFAULT NULL,
  `plan_end_work` DATE NULL DEFAULT NULL,
  `end_work` DATE NULL DEFAULT NULL,
  `amount` INT(11) NULL DEFAULT NULL,
  `total_money` DECIMAL(6,0) NULL DEFAULT NULL,
  `total_time` DECIMAL(6,0) NULL DEFAULT NULL,
  `status` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Order_kindOfWork_idx` (`kind_of_work_id` ASC),
  INDEX `fk_id_executor_idx` (`executor_id` ASC),
  INDEX `fk_id_admin_idx` (`admin_id` ASC),
  INDEX `fk_id_client_idx` (`client_id` ASC),
  CONSTRAINT `fk_Order_kindOfWork`
    FOREIGN KEY (`kind_of_work_id`)
    REFERENCES `danilevich`.`kind_of_work` (`id`),
  CONSTRAINT `fk_id_admin`
    FOREIGN KEY (`admin_id`)
    REFERENCES `danilevich`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_client`
    FOREIGN KEY (`client_id`)
    REFERENCES `danilevich`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_executor`
    FOREIGN KEY (`executor_id`)
    REFERENCES `danilevich`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
