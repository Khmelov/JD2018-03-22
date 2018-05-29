CREATE TABLE IF NOT EXISTS `danilevich`.`kind_of_work` (
  `id` INT NULL,
  `name` VARCHAR(45) NULL,
  `price` DECIMAL(6) NULL,
  `time_norm` DECIMAL(6) NULL,
  `category_work_id` INT NOT NULL,
  `unit_id` INT NOT NULL,
  `currency_id` INT NOT NULL,
  INDEX `fk_kindOfWork_categoryWork1_idx` (`category_work_id` ASC),
  INDEX `fk_kindOfWork_Units1_idx` (`unit_id` ASC),
  INDEX `fk_kindOfWork_Currency1_idx` (`currency_id` ASC),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_kindOfWork_categoryWork`
    FOREIGN KEY (`category_work_id`)
    REFERENCES `danilevich`.`category_work` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_kindOfWork_Units`
    FOREIGN KEY (`unit_id`)
    REFERENCES `danilevich`.`units` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_kindOfWork_Currency`
    FOREIGN KEY (`currency_id`)
    REFERENCES `danilevich`.`currency` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
