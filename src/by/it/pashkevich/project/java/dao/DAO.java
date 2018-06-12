package by.it.pashkevich.project.java.dao;

import by.it.pashkevich.project.java.dao.daobeans.ProductDAO;
import by.it.pashkevich.project.java.dao.daobeans.RoleDAO;
import by.it.pashkevich.project.java.dao.daobeans.UserDAO;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DAO {

    private static DAO dao;

    private DAO() {
        role = new RoleDAO();
        user = new UserDAO();
        product = new ProductDAO();
    }

    public RoleDAO role;
    public UserDAO user;
    public ProductDAO product;

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null)
                    dao = new DAO();
            }
        }
        return dao;
    }

    //    TaskC_Init
    public void reset() {
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
            statement.executeUpdate("DROP SCHEMA IF EXISTS `pashkevich`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `pashkevich` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `pashkevich`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `pashkevich`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NOT NULL,\n" +
                    "  `email` VARCHAR(100) NOT NULL,\n" +
                    "  `password` VARCHAR(200) NOT NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `pashkevich`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `pashkevich`.`goods` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(100) NULL,\n" +
                    "  `description` VARCHAR(2000) NULL,\n" +
                    "  `price` DECIMAL NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_goods_users1_idx` (`users_id` ASC),\n" +
                    "  CONSTRAINT `fk_goods_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `pashkevich`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("INSERT INTO `pashkevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `pashkevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user')");
            statement.executeUpdate("INSERT INTO `pashkevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest')");
            statement.executeUpdate("INSERT INTO `pashkevich`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'valera', 'adm@mail.ru', '212dff73bce95e21871950e2168517c4ea2c4ca3c794f2ae2c03e506f5b07226', 1)");
            statement.executeUpdate("INSERT INTO `pashkevich`.`users` (`id`, `login`, `email`, `password`, `roles_id`) VALUES (DEFAULT, 'TestLogin', 'user@mail.ru', '58f1c23947bbbe685d343f2fcaf6da16d9e5e1a86178907bda829f95682932d7', 2)");
            statement.executeUpdate("INSERT INTO `pashkevich`.`goods` (`id`, `name`, `description`, `price`, `users_id`) VALUES (DEFAULT, 'table', 'my description', 11, 2)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        DAO.getInstance().reset();
    }
}
