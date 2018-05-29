CREATE TABLE IF NOT EXISTS `danilevich`.`users` (
  `id` INT NULL,
  `name` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  `adress` VARCHAR(60) NULL,
  `telephone` VARCHAR(25) NULL,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Users_Roles1_idx` (`roles_id` ASC),
  CONSTRAINT `fk_Users_Roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `danilevich`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
