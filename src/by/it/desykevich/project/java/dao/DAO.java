package by.it.desykevich.project.java.dao;

import by.it.desykevich.project.java.dao.daobeans.AdDAO;
import by.it.desykevich.project.java.dao.daobeans.CategoryDAO;
import by.it.desykevich.project.java.dao.daobeans.RoleDAO;
import by.it.desykevich.project.java.dao.daobeans.UserDAO;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DAO {

    private static DAO dao;

    public DAO() {
        roleDAO = new RoleDAO();
        userDAO = new UserDAO();
        adDAO = new AdDAO();
        categoryDAO = new CategoryDAO();
    }

    public RoleDAO roleDAO;
    public UserDAO userDAO;
    public AdDAO adDAO;
    public CategoryDAO categoryDAO;


    public static DAO getInstanse(){
        if (dao==null){
            synchronized (DAO.class){
            if (dao==null)
            dao=new DAO();
        }}
        return dao;
    }

    public void reset(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/" +
                        "?useUnicode=true&characterEncoding=UTF-8",
                "root",
                "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `desykevich` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `desykevich` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("USE `desykevich` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `desykevich`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `desykevich`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `email` VARCHAR(45) NOT NULL,\n" +
                    "  `nickname` VARCHAR(45) NOT NULL,\n" +
                    "  `phonenumber` VARCHAR(45) NOT NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `desykevich`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `desykevich`.`category` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `desykevich`.`ads` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `title` VARCHAR(45) NOT NULL,\n" +
                    "  `description` VARCHAR(2000) NOT NULL,\n" +
                    "  `price` DECIMAL NOT NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  `category_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_ads_users1_idx` (`users_id` ASC),\n" +
                    "  INDEX `fk_ads_category1_idx` (`category_id` ASC),\n" +
                    "  CONSTRAINT `fk_ads_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `desykevich`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_ads_category1`\n" +
                    "    FOREIGN KEY (`category_id`)\n" +
                    "    REFERENCES `desykevich`.`category` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `desykevich`.`roles` (`id`, `role`) VALUES (1, 'admin');");
            statement.executeUpdate("INSERT INTO `desykevich`.`roles` (`id`, `role`) VALUES (2, 'user');");
            statement.executeUpdate("INSERT INTO `desykevich`.`roles` (`id`, `role`) VALUES (3, 'guest');");

            statement.executeUpdate("INSERT INTO `desykevich`.`users` (`id`, `login`, `password`, `email`, `nickname`, `phonenumber`, `roles_id`) VALUES (1, 'admin', '1234', 'admin@tut.by', 'administrator', '+375295674567', 1);");
            statement.executeUpdate("INSERT INTO `desykevich`.`users` (`id`, `login`, `password`, `email`, `nickname`, `phonenumber`, `roles_id`) VALUES (2, 'user', 'user', 'user01@mail.com', 'sergei', '+375298971278', 2);");

            statement.executeUpdate("INSERT INTO `desykevich`.`category` (`id`, `name`) VALUES (1, 'phone');");
            statement.executeUpdate("INSERT INTO `desykevich`.`category` (`id`, `name`) VALUES (2, 'laptop');");
            statement.executeUpdate("INSERT INTO `desykevich`.`category` (`id`, `name`) VALUES (3, 'backpack');");
            statement.executeUpdate("INSERT INTO `desykevich`.`category` (`id`, `name`) VALUES (4, 'smart bracelet');");

            statement.executeUpdate("INSERT INTO `desykevich`.`ads` (`id`, `title`, `description`, `price`, `users_id`, `category_id`) VALUES (1, 'Samsung Galaxy S9', 'Android, экран 5.8\\\" AMOLED (1440x2960), Exynos 9810, ОЗУ 4 ГБ, флэш-память 64 ГБ, карты памяти, камера 12 Мп, аккумулятор 3000 мАч, 2 SIM, цвет черный', 1650, 1, 1);");
            statement.executeUpdate("INSERT INTO `desykevich`.`ads` (`id`, `title`, `description`, `price`, `users_id`, `category_id`) VALUES (2, 'Huawei P20 Lite ', 'Android, экран 5.84\\\" IPS (1080x2280), HiSilicon Kirin 659, ОЗУ 4 ГБ, флэш-память 64 ГБ, карты памяти, камера 16 Мп, аккумулятор 3000 мАч, 2 SIM, цвет черный', 650, 2, 2);");

            System.out.println("Инициализация базы данных");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
