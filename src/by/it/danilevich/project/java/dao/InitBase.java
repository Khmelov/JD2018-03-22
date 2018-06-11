package by.it.danilevich.project.java.dao;

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
            "  `date_order` Long NULL DEFAULT NULL," +
            "  `client_id` INT(11) NULL DEFAULT NULL," +
            "  `kind_of_work_id` INT(11) NULL DEFAULT NULL," +
            "  `executor_id` INT(11) NULL DEFAULT NULL," +
            "  `admin_id` INT(11) NULL DEFAULT NULL," +
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
            "('Замена труб в ванной', 5.23, 0.25, 'Water pipes', 'm')," +
            "('Покраска стен', 4, 0.78, 'Repairs', 'm2'), " +
            "('Замена люстры', 9.5, 1, 'Electro', 'thing')," +
            "('Уборка подъезда', 3.8, 0.25, 'Repairs', 'thing')," +
            "('Покраска потолка', 8, 0.25, 'Repairs', 'm2')";
    static String insertRole= "INSERT INTO `danilevich`.`role` (`name`) VALUES ('Admin'), ('Executor'), ('Client')";
    static String insertUser= " INSERT INTO `danilevich`.`user` (`name`, `role_id`, `address`, `telephone`, `login`, `password`) VALUES " +
            "('Иванова Мария', 3, 'Московская, 25-9', '29-254-98-76', 'maria', '123')," +
            "('Петр Сергеевич', 3, 'Одоевского,13-8', '33-123-00-78', 'serg', '123')," +
            "('Михаил Алексеевич', 3, 'Победителей,1-78', '29-123-45-78', 'mikl', '123')," +
            "('Ангелина Николаевна', 3, 'Брестская, 34-1', '29-450-90-90', 'angel', '123')," +
            "('Механик Иван', 2, NULL, NULL, NULL, NULL)," +
            "('Электрик Алексей', 2, NULL, NULL, NULL, NULL),"+
            "('Водопроводчик Алексей', 2, NULL, NULL, NULL, NULL)," +
            "('Admin', 1, NULL, NULL, 'admin', 'admin')";
    static String insertOrder = "INSERT INTO `danilevich`.`order` ( `date_order`, `client_id`, `kind_of_work_id`, `executor_id`, `admin_id`, `amount`, `total_money`, `total_time`, `status`) " +
            "VALUES ('1528532698667', 1, 1, 1, 3, 1, 250, 1, 'close')," +
            " (1528663862230, 2, 2, 5, 6,  1, 25, 1, 'in process')";



}



