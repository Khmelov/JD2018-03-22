package by.it.poprugo.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class TaskC_Init {
    public static void main(String[] args) {
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
                "jdbc:mysql://127.0.0.1:2016",
                "root",
                "")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DROP SCHEMA IF EXISTS `poprugo_pro`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `poprugo_pro` DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `poprugo_pro`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `poprugo_pro`.`users` (\n" +
                    "  `idus` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `email` VARCHAR(45) NOT NULL,\n" +
                    "  `user` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`idus`),\n" +
                    "  INDEX `fk_users_roles_idx` (`roles_id` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `poprugo_pro`.`roles` (`id`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `poprugo_pro`.`models` (\n" +
                    "  `idcon` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `model` VARCHAR(45) NOT NULL DEFAULT 'noname',\n" +
                    "  `name` VARCHAR(45) NOT NULL DEFAULT 'noname',\n" +
                    "  `address` VARCHAR(45) NOT NULL DEFAULT 'noname',\n" +
                    "  `phone` VARCHAR(45) NOT NULL DEFAULT 'noname',\n" +
                    "  `number` VARCHAR(45) NOT NULL DEFAULT 'noname',\n" +
                    "  `datacontr` VARCHAR(45) NOT NULL DEFAULT 'noname',\n" +
                    "  `price` INT NOT NULL DEFAULT 0,\n" +
                    "  `keymoney` INT NOT NULL DEFAULT 0,\n" +
                    "  `users_idus` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`idcon`),\n" +
                    "  INDEX `fk_orders_users1_idx` (`users_idus` ASC),\n" +
                    "  CONSTRAINT `fk_orders_users1`\n" +
                    "    FOREIGN KEY (`users_idus`)\n" +
                    "    REFERENCES `poprugo_pro`.`users` (`idus`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `poprugo_pro`.`orders` (\n" +
                    "  `idord` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `measuse` VARCHAR(45) NOT NULL DEFAULT 'noname',\n" +
                    "  `inproduction` VARCHAR(45) NOT NULL DEFAULT 'noname',\n" +
                    "  `getmaterials` VARCHAR(45) NOT NULL DEFAULT 'noname',\n" +
                    "  `fitting` VARCHAR(45) NOT NULL DEFAULT 'noname',\n" +
                    "  `refund` INT NOT NULL DEFAULT 0,\n" +
                    "  `models_idcon` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`idord`),\n" +
                    "  INDEX `fk_orders_models1_idx` (`models_idcon` ASC),\n" +
                    "  CONSTRAINT `fk_orders_models1`\n" +
                    "    FOREIGN KEY (`models_idcon`)\n" +
                    "    REFERENCES `poprugo_pro`.`models` (`idcon`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("INSERT INTO `poprugo_pro`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin')");
            statement.executeUpdate("INSERT INTO `poprugo_pro`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user')");
            statement.executeUpdate("INSERT INTO `poprugo_pro`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest')\"");
            statement.executeUpdate("INSERT INTO `users`(`idus`, `email`, `user`, `password`, `roles_id`) " +
                    "VALUES (DEFAULT,'adm@mail.ru','adminitrator','adminitrator',1)");
            statement.executeUpdate("INSERT INTO `users`(`idus`, `email`, `user`, `password`, `roles_id`) " +
                    "VALUES (DEFAULT,'test123@mail.ru','Test123','111',2)");
            statement.executeUpdate("INSERT INTO `users`(`idus`, `email`, `user`, `password`, `roles_id`) " +
                    "VALUES (DEFAULT,'test321@mail.ru','Test321','222',2)");
            statement.executeUpdate("INSERT INTO `models`(`idcon`, `model`, `name`, `address`, `phone`, `number`, `datacontr`, `price`, `keymoney`, `users_idus`) " +
                    "VALUES (DEFAULT,'wardrobe_1250_600_BS_V350','Ivan','Minsk, Kolasa, 8-35','33-525-33','W_18_05_18_1','2018 may 18','620','350','2')");
            statement.executeUpdate("INSERT INTO `models`(`idcon`, `model`, `name`, `address`, `phone`, `number`, `datacontr`, `price`, `keymoney`, `users_idus`) " +
                    "VALUES (DEFAULT,'wardrobe_900_550_BI','Petr','Minsk, Philimonovd, 89-359','35-525-53','W_18_05_18_2','2018 may 18','350','170','3')");
            statement.executeUpdate("INSERT INTO `models`(`idcon`, `model`, `name`, `address`, `phone`, `number`, `datacontr`, `price`, `keymoney`, `users_idus`) " +
                    "VALUES (DEFAULT,'wardrobe_1700_600_BS_V350','Petr','Minsk, Philimonovd, 89-359','35-525-53','W_18_05_18_2','2018 may 18','710','350','3')");
            statement.executeUpdate("INSERT INTO `models`(`idcon`, `model`, `name`, `address`, `phone`, `number`, `datacontr`, `price`, `keymoney`, `users_idus`) " +
                    "VALUES (DEFAULT,'kitchen_2600_600_Blume_inb','Petr','Minsk, Philimonovd, 89-359','35-525-53','W_28_05_18_1','2018 may 28','3500','1700','3')");
            statement.executeUpdate("INSERT INTO `models`(`idcon`, `model`, `name`, `address`, `phone`, `number`, `datacontr`, `price`, `keymoney`, `users_idus`) " +
                    "VALUES (DEFAULT,'dresser_akacia_700','Ivan','Minsk, Kolasa, 8-35','33-525-33','W_18_05_18_1_add','2018 may 28','80','0','2')");
            statement.executeUpdate("INSERT INTO `models`(`idcon`, `model`, `name`, `address`, `phone`, `number`, `datacontr`, `price`, `keymoney`, `users_idus`) " +
                    "VALUES (DEFAULT,'kitchen_2510_500_Hettiche_stand','Ivan','Minsk, Kolasa, 8-35','33-525-33','W_18_05_29_1','2018 may 29','1700','800','2')");
            statement.executeUpdate("");

            //statement.executeUpdate("DELETE `roles`");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
