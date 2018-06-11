package by.it.lyukovich.jd_03_03.dao;

import by.it.lyukovich.jd_03_03.dao.connect.*;
import by.it.lyukovich.jd_03_03.dao.daobeans.*;

import java.sql.*;

public class DAO {

    private static DAO dao;


    private DAO() {
        role=new RoleDAO();
        user=new UserDAO();
        author=new AuthorDAO();
        category=new CategoryDAO();
        book=new BookDAO();
    }

    public RoleDAO role;
    public UserDAO user;
    public AuthorDAO author;
    public CategoryDAO category;
    public BookDAO book;

    public static DAO getInstance(){
        if (dao==null){
            synchronized (DAO.class){
            if (dao==null)
                dao=new DAO();
            }
        }
        return dao;
    }

    public void initDB() throws SQLException {
        String DB = Config.DB;

        try (Connection connection = ConnectionCreator.getConnection()) {
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
                    "  `regdate` LONG NOT NULL,\n" +
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
                    "  `bookdateadded` LONG NOT NULL,\n" +
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
                    "  `orderdate` LONG NULL,\n" +
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
                    "  `orderdate` LONG NOT NULL,\n" +
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
