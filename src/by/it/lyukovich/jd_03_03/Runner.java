package by.it.lyukovich.jd_03_03;

import by.it.lyukovich.jd_03_03.dao.connect.ConnectionCreator;
import by.it.lyukovich.jd_03_03.beans.*;
import by.it.lyukovich.jd_03_03.dao.DAO;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        dao.initDB();

        System.out.println("\nПроверка DAO для бина Role");
        System.out.println(dao.role.getAll(""));
        Role role = new Role(-1, "testRole");
        dao.role.create(role);
        System.out.println(dao.role.getAll(""));
        role.setRole("testRoleForDelete");
        dao.role.update(role);
        System.out.println(dao.role.getAll(""));
        //dao.role.delete(role);
        System.out.println(dao.role.getAll(""));

        System.out.println("\nПроверка DAO для бина User");
        System.out.println(dao.user.getAll(""));
        User user = new User(-1,"admin@skylib.by", "admin", "admin",
                ConnectionCreator.getCurrentTimeStamp(), "Admin", "Adminovich", 1);
        dao.user.create(user);
        System.out.println(dao.user.getAll(""));
        user.setUsername("admin");
        dao.user.update(user);
        System.out.println(dao.user.getAll(""));
        //dao.user.delete(user);
        System.out.println(dao.user.getAll(""));

        System.out.println("\nПроверка DAO для бина Author");
        System.out.println(dao.author.getAll(""));
        Author author = new Author(-1, "testAuthor");
        dao.author.create(author);
        System.out.println(dao.author.getAll(""));
        author.setAuthorname("testAuthornew");
        dao.author.update(author);
        System.out.println(dao.author.getAll(""));
        //dao.author.delete(author);
        System.out.println(dao.author.getAll(""));

        System.out.println("\nПроверка DAO для бина Category");
        System.out.println(dao.category.getAll(""));
        Category category = new Category(-1, 0, "testCategory", "description");
        dao.category.create(category);
        System.out.println(dao.category.getAll(""));
        category.setCategoryname("testNewcategory");
        dao.category.update(category);
        System.out.println(dao.category.getAll(""));
        //dao.category.delete(category);
        System.out.println(dao.category.getAll(""));

        System.out.println("\nПроверка DAO для бина Book");
        System.out.println(dao.category.getAll(""));
        Book book = new Book(-1, 1, ConnectionCreator.getCurrentTimeStamp(), "Java The Complete Reference Ninth Edition",
                "English", "1", "USA", "This edition of the book contains a substantial amount of new material " +
                "because Java SE 8 adds several new features to the Java language.", "PDF", "books/1.zip",
                "books/images/1.jpg", 1);
        dao.book.create(book);
        System.out.println(dao.book.getAll(""));
        book.setBookname("Java");
        dao.book.update(book);
        System.out.println(dao.book.getAll(""));
        //dao.book.delete(book);
        System.out.println(dao.book.getAll(""));
    }
}
