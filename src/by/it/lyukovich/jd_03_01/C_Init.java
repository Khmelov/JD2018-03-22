package by.it.lyukovich.jd_03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class C_Init {
    /**
     * Global parameter for DB name
     */
    public static final String DB="skylib";

    public static void main(String[] args) {
        initDB();
    }

    public static void initDB() {
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
            statement.executeUpdate("DROP SCHEMA IF EXISTS "+DB+"");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS "+DB+" DEFAULT CHARACTER SET utf8");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `skylib`.`roles` (\n" +
                    "  `roleid` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `rolename` VARCHAR(45) NOT NULL DEFAULT 'user',\n" +
                    "  PRIMARY KEY (`roleid`),\n" +
                    "  UNIQUE INDEX `roleid_UNIQUE` (`roleid` ASC),\n" +
                    "  UNIQUE INDEX `rolename_UNIQUE` (`rolename` ASC))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS "+DB+".`users` (\n" +
                    "  `userid` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `email` VARCHAR(100) NOT NULL,\n" +
                    "  `username` VARCHAR(45) NOT NULL,\n" +
                    "  `password` VARCHAR(45) NOT NULL,\n" +
                    "  `regdate` DATETIME(6) NOT NULL,\n" +
                    "  `firstname` VARCHAR(45) NOT NULL,\n" +
                    "  `secondname` VARCHAR(45) NOT NULL,\n" +
                    "  `roleid` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`userid`),\n" +
                    "  UNIQUE INDEX `userid_UNIQUE` (`userid` ASC),\n" +
                    "  UNIQUE INDEX `username_UNIQUE` (`username` ASC),\n" +
                    "  INDEX `fk_users_roles_idx` (`roleid` ASC),\n" +
                    "  UNIQUE INDEX `email_UNIQUE` (`email` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roleid`)\n" +
                    "    REFERENCES "+DB+".`roles` (`roleid`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS "+DB+".`category` (\n" +
                    "  `categoryid` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `categorysubid` INT NULL,\n" +
                    "  `categoryname` VARCHAR(70) NULL,\n" +
                    "  `categorydescription` VARCHAR(300) NULL,\n" +
                    "  PRIMARY KEY (`categoryid`),\n" +
                    "  UNIQUE INDEX `categoryid_UNIQUE` (`categoryid` ASC))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS "+DB+".`books` (\n" +
                    "  `bookid` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `categoryid` INT NOT NULL,\n" +
                    "  `bookdateadded` DATETIME(6) NOT NULL,\n" +
                    "  `bookname` VARCHAR(300) NOT NULL,\n" +
                    "  `booklang` VARCHAR(45) NULL,\n" +
                    "  `bookauthors` VARCHAR(500) NULL,\n" +
                    "  `bookcountry` VARCHAR(50) NULL,\n" +
                    "  `bookdescription` VARCHAR(2000) NULL,\n" +
                    "  `bookformat` VARCHAR(45) NULL,\n" +
                    "  `bookfilename` VARCHAR(100) NULL,\n" +
                    "  `bookimgname` VARCHAR(100) NULL,\n" +
                    "  `uploadedbyuser` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`bookid`, `categoryid`),\n" +
                    "  UNIQUE INDEX `bookid_UNIQUE` (`bookid` ASC),\n" +
                    "  INDEX `fk_books_category1_idx` (`categoryid` ASC),\n" +
                    "  INDEX `fk_books_users1_idx` (`uploadedbyuser` ASC),\n" +
                    "  CONSTRAINT `fk_books_category1`\n" +
                    "    FOREIGN KEY (`categoryid`)\n" +
                    "    REFERENCES "+DB+".`category` (`categoryid`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_books_users1`\n" +
                    "    FOREIGN KEY (`uploadedbyuser`)\n" +
                    "    REFERENCES "+DB+".`users` (`userid`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS "+DB+".`bookscount` (\n" +
                    "  `bookid` INT NOT NULL,\n" +
                    "  `bookcount` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`bookid`),\n" +
                    "  UNIQUE INDEX `bookid_UNIQUE` (`bookid` ASC))\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS "+DB+".`currentorders` (\n" +
                    "  `userid` INT NOT NULL,\n" +
                    "  `bookid` INT NOT NULL,\n" +
                    "  `orderdate` DATETIME(6) NULL,\n" +
                    "  INDEX `fk_currentorders_bookscount1_idx` (`bookid` ASC),\n" +
                    "  CONSTRAINT `fk_currentorders_users1`\n" +
                    "    FOREIGN KEY (`userid`)\n" +
                    "    REFERENCES "+DB+".`users` (`userid`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_currentorders_bookscount1`\n" +
                    "    FOREIGN KEY (`bookid`)\n" +
                    "    REFERENCES "+DB+".`bookscount` (`bookid`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS "+DB+".`buyinfo` (\n" +
                    "  `bookid` INT NOT NULL,\n" +
                    "  `buylink` VARCHAR(1000) NULL,\n" +
                    "  `buyprice` DOUBLE NULL,\n" +
                    "  INDEX `fk_buyinfo_books1_idx` (`bookid` ASC),\n" +
                    "  CONSTRAINT `fk_buyinfo_books1`\n" +
                    "    FOREIGN KEY (`bookid`)\n" +
                    "    REFERENCES "+DB+".`books` (`bookid`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS "+DB+".`pendingorders` (\n" +
                    "  `userid` INT NOT NULL,\n" +
                    "  `bookid` INT NOT NULL,\n" +
                    "  `orderdate` DATETIME(6) NOT NULL,\n" +
                    "  INDEX `fk_pendingorders_users1_idx` (`userid` ASC),\n" +
                    "  INDEX `fk_pendingorders_bookscount1_idx` (`bookid` ASC),\n" +
                    "  CONSTRAINT `fk_pendingorders_users1`\n" +
                    "    FOREIGN KEY (`userid`)\n" +
                    "    REFERENCES "+DB+".`users` (`userid`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_pendingorders_bookscount1`\n" +
                    "    FOREIGN KEY (`bookid`)\n" +
                    "    REFERENCES "+DB+".`bookscount` (`bookid`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS "+DB+".`authors` (\n" +
                    "  `authorid` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `authorname` VARCHAR(500) NULL,\n" +
                    "  PRIMARY KEY (`authorid`),\n" +
                    "  UNIQUE INDEX `authorid_UNIQUE` (`authorid` ASC))\n" +
                    "ENGINE = InnoDB");
            System.out.println("Создание базы выполнено");
        } catch (SQLException e) {
            System.out.println("При создании базы возникла ошибка" + e.toString());
        }
    }


}
