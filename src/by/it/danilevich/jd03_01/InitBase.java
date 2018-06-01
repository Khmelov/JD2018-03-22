package by.it.danilevich.jd03_01;

import java.sql.*;

class InitBase {

    static String deleteSchema = "DROP SCHEMA IF EXISTS `danilevich`";
    static String createSchema = "CREATE SCHEMA IF NOT EXISTS `danilevich` DEFAULT CHARACTER SET utf8" ;
    static String createCategory =" CREATE TABLE IF NOT EXISTS `danilevich`.`category_work` " +
            "(`id` INT NULL AUTO_INCREMENT," +
            " `name` VARCHAR(45) NULL," +
            "PRIMARY KEY (`id`), UNIQUE INDEX `name_UNIQUE` (`name` ASC))";
    static String createUnits= "CREATE TABLE IF NOT EXISTS `danilevich`.`units` (" +
            "`id` INT NULL AUTO_INCREMENT," +
            "`name` VARCHAR(45) NOT NULL," +
            "PRIMARY KEY (`id`))";
    static String createCurrency = "CREATE TABLE IF NOT EXISTS `danilevich`.`currency` (`id` INT NOT NULL AUTO_INCREMENT,`name` VARCHAR(45) NULL,PRIMARY KEY (`id`),UNIQUE INDEX `name_UNIQUE` (`name` ASC))";
    static String createKindofWork= "CREATE TABLE IF NOT EXISTS `danilevich`.`kind_of_work` (" +
            "`id` INT NULL AUTO_INCREMENT," +
            "`name` VARCHAR(45) NULL," +
            "`price` DECIMAL(6) NOT NULL," +
            "`time_norm` DECIMAL(6) NOT NULL, " +
            "`category_work_id` INT NOT NULL," +
            "`unit_id` INT NOT NULL," +
            "`currency_id` INT NOT NULL," +
             "INDEX `fk_kindOfWork_categoryWork_idx` (`category_work_id` ASC)," +
            "INDEX `fk_kindOfWork_Units_idx` (`unit_id` ASC)," +
            "INDEX `fk_kindOfWork_Currency_idx` (`currency_id` ASC)," +
            "PRIMARY KEY (`id`)," +
            "CONSTRAINT `fk_kindOfWork_categoryWork`" +
            "FOREIGN KEY (`category_work_id`)" +
            "REFERENCES `danilevich`.`category_work` (`id`)" +
            "ON DELETE NO ACTION " +
            "ON UPDATE NO ACTION, " +
            "CONSTRAINT `fk_kindOfWork_Units`" +
            "FOREIGN KEY (`unit_id`)" +
            "REFERENCES `danilevich`.`units` (`id`) " +
            "ON DELETE NO ACTION " +
            "ON UPDATE NO ACTION," +
            "CONSTRAINT `fk_kindOfWork_Currency` " +
            "FOREIGN KEY (`currency_id`) " +
            "REFERENCES `danilevich`.`currency` (`id`) " +
            "ON DELETE NO ACTION " +
            "ON UPDATE NO ACTION)";
    static String createRoles= "CREATE TABLE IF NOT EXISTS `danilevich`.`roles` (" +
            "`id` INT NULL AUTO_INCREMENT," +
            "`name` VARCHAR(45) NULL," +
            "PRIMARY KEY (`id`)," +
            "UNIQUE INDEX `name_UNIQUE` (`name` ASC))";
    static String createUsers ="CREATE TABLE IF NOT EXISTS `danilevich`.`users` (" +
            "`id` INT NULL AUTO_INCREMENT," +
            "`name` VARCHAR(45) NULL," +
            "`roles_id` INT NOT NULL," +
            "`address` VARCHAR(60) NULL," +
            "`telephone` VARCHAR(25) NULL," +
            "`login` VARCHAR(45) NULL," +
            "`password` VARCHAR(45) NULL," +
            "PRIMARY KEY (`id`)," +
            "INDEX `fk_Users_Roles1_idx` (`roles_id` ASC)," +
            "CONSTRAINT `fk_Users_Roles1` " +
            "FOREIGN KEY (`roles_id`) " +
            "REFERENCES `danilevich`.`roles` (`id`) " +
            "ON DELETE NO ACTION " +
            "ON UPDATE NO ACTION)";
    static String createStatusWork ="CREATE TABLE IF NOT EXISTS `danilevich`.`status_of_work` (" +
            "`id` INT NOT NULL AUTO_INCREMENT," +
            "`namel` VARCHAR(45) NULL," +
            "PRIMARY KEY (`id`)," +
            "UNIQUE INDEX `namel_UNIQUE` (`namel` ASC))";
    static String createOrder= "CREATE TABLE IF NOT EXISTS `danilevich`.`order` (" +
            "`id` INT NULL AUTO_INCREMENT," +
            "`date_order` DATE NULL," +
            "`client_id` INT NULL," +
            "`kind_of_work_id` INT NULL, " +
            "`executor_id` INT NULL," +
            "`admin_id` INT NULL," +
            "`begin_work` DATE NULL," +
            "`plan_end_work` DATE NULL," +
            "`end_work` DATE NULL," +
            "`amount` INT NULL," +
            "`total_money` DECIMAL(6) NULL," +
            "`total_time` DECIMAL(6) NULL, " +
            "`status_of_work_id` INT NOT NULL, " +
            "PRIMARY KEY (`id`), " +
            "INDEX `fk_Order_kindOfWork_idx` (`kind_of_work_id` ASC), " +
            "INDEX `fk_id_executor_idx` (`executor_id` ASC), " +
            "INDEX `fk_id_admin_idx` (`admin_id` ASC), " +
            "INDEX `fk_id_client_idx` (`client_id` ASC), " +
            "INDEX `fk_order_status_of_work1_idx` (`status_of_work_id` ASC), " +
            "CONSTRAINT `fk_Order_kindOfWork`" +
            "FOREIGN KEY (`kind_of_work_id`)" +
            " REFERENCES `danilevich`.`kind_of_work` (`id`)" +
            "ON DELETE RESTRICT " +
            "ON UPDATE RESTRICT," +
            "CONSTRAINT `fk_id_executor`" +
            "FOREIGN KEY (`executor_id`) REFERENCES `danilevich`.`users` (`id`) " +
            " ON DELETE NO ACTION ON UPDATE NO ACTION, " +
            " CONSTRAINT `fk_id_admin` FOREIGN KEY (`admin_id`) " +
            " REFERENCES `danilevich`.`users` (`id`) " +
            " ON DELETE NO ACTION" +
            " ON UPDATE NO ACTION, " +
            " CONSTRAINT `fk_id_client` " +
            " FOREIGN KEY (`client_id`) " +
            "REFERENCES `danilevich`.`users` (`id`) " +
            " ON DELETE NO ACTION " +
            " ON UPDATE NO ACTION, CONSTRAINT `fk_order_status_of_work` " +
            "FOREIGN KEY (`status_of_work_id`) " +
            " REFERENCES `danilevich`.`status_of_work` (`id`) " +
            "ON DELETE NO ACTION ON UPDATE NO ACTION)";
    static String insertCategory= "INSERT INTO `danilevich`.`category_work` (`name`) VALUES ('Electro'), ('Repairs'), ('Water pipes')";
    static String insertUnits = "INSERT INTO `danilevich`.`units` (`name`) VALUES ('m'), ('m2'), ('thing')";
    static String insertCurrency= "INSERT INTO `danilevich`.`currency` (`name`) VALUES ('BYB'),('USD'),('EUR'),('RUR')";
    static String insertKindOfWork= "INSERT INTO `danilevich`.`kind_of_work` (`name`, `price`, `time_norm`, `category_work_id`, `unit_id`, `currency_id`) VALUES " +
            "('Change pipes in bath', 5.23, 0.25, 3, 1, 1)," +
            "('painting walls', 4, 0.78, 2, 2, 1), " +
            "('Change lamp', 9.5, 1, 1, 3, 1)," +
            "('Change pipes in kitchen', 3.8, 0.25, 3, 1, 1)," +
            "('painting roof', 8, 0.25, 2, 2, 1)";
    static String insertRoles= "INSERT INTO `danilevich`.`roles` (`name`) VALUES ('Client'), ('Executor'), ('Admin')";
    static String insertUsers= " INSERT INTO `danilevich`.`users` (`name`, `roles_id`, `address`, `telephone`, `login`, `password`) VALUES " +
            "('Ivanova Maria', 1, 'Moskovskaja, 25-9', '29-254-98-76', 'maria', '123')," +
            "('Petr Sergeevich', 1, 'Odojevskogo,13-8', '33-123-00-78', 'serg', '123')," +
            "('Mihail Alekseevich', 1, 'Pobeditelej,1-78', '29-123-45-78', 'mikl', '123')," +
            "('Angelina Nikolajevna', 1, 'Brestskaja, 34-1', '29-450-90-90', 'angel', '123')," +
            "('Mechanic Jone', 2, NULL, NULL, NULL, NULL)," +
            "('Electric Alex', 2, NULL, NULL, NULL, NULL),"+
            "('Plumber Niokalaj', 2, NULL, NULL, NULL, NULL)," +
            "('Admin', 3, NULL, NULL, 'admin', 'admin')";
    static String insertStatus = "INSERT INTO `danilevich`.`status_of_work` (`namel`) VALUES ('in process'), ('waiting'), ('close')";
    static String insertOrder = "INSERT INTO `danilevich`.`order` (`date_order`, `client_id`, `kind_of_work_id`, `executor_id`, `admin_id`, `begin_work`, `plan_end_work`, `end_work`, `amount`, `total_money`, `total_time`, `status_of_work_id`) " +
            " VALUES ('01.01.17', 1, 1, 5, 6, '01.02.17', '01.02.17', '01.02.17', 1, 15, 1, 3)," +
            " ('01.01.17', 2, 2, 5, 6, '02.04.17', '02.04.17', '02.04.17', 1, 25, 1, 3)";


}



