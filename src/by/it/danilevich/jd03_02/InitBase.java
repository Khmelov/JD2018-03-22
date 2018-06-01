package by.it.danilevich.jd03_02;

class InitBase {

    static String deleteSchema = "DROP SCHEMA IF EXISTS `danilevich`";
    static String createSchema = "CREATE SCHEMA IF NOT EXISTS `danilevich` DEFAULT CHARACTER SET utf8" ;
    static String createKindofWork=
            "CREATE TABLE IF NOT EXISTS `danilevich`.`kind_of_work` (" +
            "`id` INT NULL AUTO_INCREMENT," +
            "`name` VARCHAR(45) NULL," +
            "`price` DOUBLE NOT NULL," +
            "`time_norm` DOUBLE NOT NULL, " +
            "`category` VARCHAR(45) NOT NULL," +
            "`unit` VARCHAR(45) NOT NULL," +
            "PRIMARY KEY (`id`))";
    static String createRole= "CREATE TABLE IF NOT EXISTS `danilevich`.`role` (" +
            "`id` INT NULL AUTO_INCREMENT," +
            "`name` VARCHAR(45) NULL," +
            "PRIMARY KEY (`id`)," +
            "UNIQUE INDEX `name_UNIQUE` (`name` ASC))";
    static String createUser ="CREATE TABLE IF NOT EXISTS `danilevich`.`user` (\n" +
            "  `id` INT NULL AUTO_INCREMENT,\n" +
            "  `name` VARCHAR(45) NULL,\n" +
            "  `role_id` INT NULL,\n" +
            "  `address` VARCHAR(60) NULL,\n" +
            "  `telephone` VARCHAR(25) NULL,\n" +
            "  `login` VARCHAR(45) NULL,\n" +
            "  `password` VARCHAR(45) NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  INDEX `fk_Users_Role_idx` (`role_id` ASC),\n" +
            "  CONSTRAINT `fk_Users_Role`\n" +
            "    FOREIGN KEY (`role_id`)\n" +
            "    REFERENCES `danilevich`.`role` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE RESTRICT)";
    static String createOrder= "CREATE TABLE IF NOT EXISTS `danilevich`.`order` (\n" +
            "  `id` INT(11) NOT NULL AUTO_INCREMENT," +
            "  `date_order` int(11) NULL DEFAULT NULL," +
            "  `client_id` INT(11) NULL DEFAULT NULL," +
            "  `kind_of_work_id` INT(11) NULL DEFAULT NULL," +
            "  `executor_id` INT(11) NULL DEFAULT NULL," +
            "  `admin_id` INT(11) NULL DEFAULT NULL," +
            "  `begin_work` int(11) NULL DEFAULT NULL," +
            "  `plan_end_work` int(11) NULL DEFAULT NULL," +
            "  `end_work` int(11) NULL DEFAULT NULL," +
            "  `amount` INT(11) NULL DEFAULT NULL," +
            "  `total_money` DOUBLE NULL DEFAULT NULL," +
            "  `total_time` DOUBLE NULL DEFAULT NULL," +
            "  `status` VARCHAR(15) NOT NULL," +
            "  PRIMARY KEY (`id`)," +
            "  INDEX `fk_Order_kindOfWork_idx` (`kind_of_work_id` ASC)," +
            "  INDEX `fk_id_executor_idx` (`executor_id` ASC)," +
            "  INDEX `fk_id_admin_idx` (`admin_id` ASC)," +
            "  INDEX `fk_id_client_idx` (`client_id` ASC)," +
            "  CONSTRAINT `fk_Order_kindOfWork`" +
            "    FOREIGN KEY (`kind_of_work_id`)" +
            "    REFERENCES `danilevich`.`kind_of_work` (`id`)," +
            "  CONSTRAINT `fk_id_admin`" +
            "    FOREIGN KEY (`admin_id`)" +
            "    REFERENCES `danilevich`.`user` (`id`)" +
            "    ON DELETE NO ACTION" +
            "    ON UPDATE NO ACTION," +
            "  CONSTRAINT `fk_id_client`" +
            "    FOREIGN KEY (`client_id`)" +
            "    REFERENCES `danilevich`.`user` (`id`)" +
            "    ON DELETE NO ACTION" +
            "    ON UPDATE NO ACTION," +
            "  CONSTRAINT `fk_id_executor`" +
            "    FOREIGN KEY (`executor_id`)" +
            "    REFERENCES `danilevich`.`user` (`id`)" +
            "    ON DELETE NO ACTION" +
            "    ON UPDATE NO ACTION)";
     static String insertKindOfWork= "INSERT INTO `danilevich`.`kind_of_work` (`name`, `price`, `time_norm`, `category`, `unit`) VALUES " +
            "('Change pipes in bath', 5.23, 0.25, 'Water pipes', 'm')," +
            "('painting walls', 4, 0.78, 'repairs', 'm2'), " +
            "('Change lamp', 9.5, 1, 'electro', 'thing')," +
            "('Change pipes in kitchen', 3.8, 0.25, 'Water pipes', 'thing')," +
            "('painting roof', 8, 0.25, 'repairs', 'm2')";
    static String insertRole= "INSERT INTO `danilevich`.`role` (`name`) VALUES ('Client'), ('Executor'), ('Admin')";
    static String insertUser= " INSERT INTO `danilevich`.`user` (`name`, `role_id`, `address`, `telephone`, `login`, `password`) VALUES " +
            "('Ivanova Maria', 1, 'Moskovskaja, 25-9', '29-254-98-76', 'maria', '123')," +
            "('Petr Sergeevich', 1, 'Odojevskogo,13-8', '33-123-00-78', 'serg', '123')," +
            "('Mihail Alekseevich', 1, 'Pobeditelej,1-78', '29-123-45-78', 'mikl', '123')," +
            "('Angelina Nikolajevna', 1, 'Brestskaja, 34-1', '29-450-90-90', 'angel', '123')," +
            "('Mechanic Jone', 2, NULL, NULL, NULL, NULL)," +
            "('Electric Alex', 2, NULL, NULL, NULL, NULL),"+
            "('Plumber Niokalaj', 2, NULL, NULL, NULL, NULL)," +
            "('Admin', 3, NULL, NULL, 'admin', 'admin')";
    static String insertOrder = "INSERT INTO `danilevich`.`order` ( `date_order`, `client_id`, `kind_of_work_id`, `executor_id`, `admin_id`, `begin_work`, `plan_end_work`, `end_work`, `amount`, `total_money`, `total_time`, `status`) " +
            "VALUES ('3200', 1, 1, 1, 3, '3200', '3200', '3200', 1, 250, 1, 'in work')," +
            " (1000, 2, 2, 5, 6, 5000, 5000, 5000, 1, 25, 1, 'in process')";


}



