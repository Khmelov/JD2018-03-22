CREATE TABLE IF NOT EXISTS `danilevich`.`order`(
  `id` VARCHAR(15) NOT NULL,
  `date_order` DATE NULL,
  `client_id` INT NULL,
  `kind_of_work_id` INT NULL,
  `executor_id` INT NULL,
  `admin_id` INT NULL,
  `begin_work` DATE NULL,
  `plan_end_work` DATE NULL,
  `end_work` DATE NULL,
  `amount` INT NULL,
  `total_money` DECIMAL(6) NULL,
  `total_time` DECIMAL(6) NULL,
  `status_of_work_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Order_kindOfWork_idx` (`kind_of_work_id` ASC),
  INDEX `fk_id_executor_idx` (`executor_id` ASC),
  INDEX `fk_id_admin_idx` (`admin_id` ASC),
  INDEX `fk_id_client_idx` (`client_id` ASC),
  INDEX `fk_order_status_of_work1_idx` (`status_of_work_id` ASC),
  CONSTRAINT `fk_Order_kindOfWork`
    FOREIGN KEY (`kind_of_work_id`)
    REFERENCES `danilevich`.`kind_of_work` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_executor`
    FOREIGN KEY (`executor_id`)
    REFERENCES `danilevich`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_admin`
    FOREIGN KEY (`admin_id`)
    REFERENCES `danilevich`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_client`
    FOREIGN KEY (`client_id`)
    REFERENCES `danilevich`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_status_of_work`
    FOREIGN KEY (`status_of_work_id`)
    REFERENCES `danilevich`.`status_of_work` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)