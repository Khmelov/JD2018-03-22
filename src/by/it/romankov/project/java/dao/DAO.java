package by.it.romankov.project.java.dao;


import by.it.romankov.project.java.dao.daobeans.PeopleDAO;
import by.it.romankov.project.java.dao.daobeans.RolesDAO;
import by.it.romankov.project.java.dao.daobeans.ToursDAO;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DAO {

    private static DAO dao;


    private DAO() {
        role= new RolesDAO();
        people = new PeopleDAO();
        tour = new ToursDAO();
    }

    public RolesDAO role;
    public PeopleDAO people;
    public ToursDAO tour;


    public static DAO getInstance(){
        if (dao==null){
            synchronized (DAO.class){
            if (dao==null)
                dao=new DAO();
            }
        }
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


        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/",
                             "root",
                             "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `romankov` ");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `romankov` DEFAULT CHARACTER SET utf8 ");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `romankov`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `romankov`.`people` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(45) NOT NULL,\n" +
                    "  `email` VARCHAR(45) NOT NULL,\n" +
                    "  `login` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `telephone` INT NOT NULL,\n" +
                    "  `age` INT NOT NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles1_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles1`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `romankov`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `romankov`.`tours` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `target` VARCHAR(45) NOT NULL,\n" +
                    "  `country` VARCHAR(45) NOT NULL,\n" +
                    "  `city` VARCHAR(45) NOT NULL,\n" +
                    "  `days` INT NOT NULL,\n" +
                    "  `transport` VARCHAR(45) NOT NULL,\n" +
                    "  `price` INT NOT NULL,\n" +
                    "  `people_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_ads_users1_idx` (`people_id` ASC),\n" +
                    "  CONSTRAINT `fk_ads_users1`\n" +
                    "    FOREIGN KEY (`people_id`)\n" +
                    "    REFERENCES `romankov`.`people` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `romankov`.`roles` (`id`, `role`) VALUES (1, 'agent');");
            statement.executeUpdate("INSERT INTO `romankov`.`roles` (`id`, `role`) VALUES (2, 'client');");
            statement.executeUpdate("INSERT INTO `romankov`.`roles` (`id`, `role`) VALUES (3, 'director');");
            statement.executeUpdate("INSERT INTO `romankov`.`roles` (`id`, `role`) VALUES (4, 'reapeted_client');");
            statement.executeUpdate("INSERT INTO `romankov`.`people` (`id`, `name`, `email`,`login`,`password`, `telephone`, `age`, `roles_id`) VALUES (3, 'Anya','anna@tut.by','Annn','Anya123', 2346564, 30, 2);");
            statement.executeUpdate("INSERT INTO `romankov`.`people` (`id`, `name`, `email`,`login`,`password`, `telephone`, `age`, `roles_id`) VALUES (4, 'Nikita','nikita@tut.by', 'Nik','Nik123', 7452135, 30, 2);");
            statement.executeUpdate("INSERT INTO `romankov`.`people` (`id`, `name`, `email`,`login`,`password`, `telephone`, `age`, `roles_id`) VALUES (1, 'Dima','dima@tut.by','Dimon','Dima123',  7865453, 29, 3);");
            statement.executeUpdate("INSERT INTO `romankov`.`people` (`id`, `name`, `email`,`login`,`password`, `telephone`, `age`, `roles_id`) VALUES (2, 'Alisa','alisa@tut.by','Alis','Alisa123',  2345543, 30, 1);");

            statement.executeUpdate("INSERT INTO `romankov`.`tours` (`id`, `target`, `country`, `city`, `days`, `transport`, `price`, `people_id`) VALUES (1, 'shopping', 'poland', 'belostok', 1, 'bus', 500, 1)" );
            statement.executeUpdate("INSERT INTO `romankov`.`tours` (`id`, `target`, `country`, `city`, `days`, `transport`, `price`, `people_id`) VALUES (2, 'rest', 'spain', 'barselona', 12, 'airplane', 1500, 1);");
            statement.executeUpdate("INSERT INTO `romankov`.`tours` (`id`, `target`, `country`, `city`, `days`, `transport`, `price`, `people_id`) VALUES (3, 'excursion', 'ukraine', 'kiev', 3, 'bus', 130, 3);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        dao.reset();
    }

}
