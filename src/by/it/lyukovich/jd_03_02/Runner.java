package by.it.lyukovich.jd_03_02;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

        //DB Drop Tables
        C_Reset.resetDB();
        System.out.println("Таблицы удалены");

        //DB creation
        C_Init.initDB();
        System.out.println("Таблицы созданы");

        //Roles creation
        Role role = new Role(-1, "admin");
        RoleCRUD.create(role);
        role.setRole("moderator");
        RoleCRUD.create(role);
        System.out.println("Роль "+ role.getRole() + "создана");
        role.setRole("user");
        RoleCRUD.create(role);
        System.out.println("Роль "+ role.getRole() + "создана");
        role.setRole("test");
        RoleCRUD.create(role);
        System.out.println("Роль "+ role.getRole() + "создана");
        String tmpstr = role.getRole();
        role.setRole("testnew");
        RoleCRUD.update(role);
        System.out.println("Роль "+ tmpstr + "переименована в " + role.getRole());
        RoleCRUD.delete(role);
        System.out.println("Роль "+ role.getRole() + "удалена");

        //Users creation

        User user = new User(-1,"admin@skylib.by", "admin", "admin",
                ConnectionCreator.getCurrentTimeStamp(), "Admin", "Adminovich", 1);
        UserCRUD.create(user);
        System.out.println("Пользователь " +user+ " создан");

        user.setEmail("user@skylib.by"); user.setUsername("user"); user.setFirstname("User");
        user.setSecondname("Userovich"); user.setPassword("user"); user.setRoleid(2);
        UserCRUD.create(user);
        System.out.println("Пользователь " +user+ " создан");
        tmpstr = user.getUsername();
        user.setUsername("moder");
        UserCRUD.update(user);
        System.out.println("Пользователь " +tmpstr+ " переименован в " + user.getUsername());
        UserCRUD.read(2);
        UserCRUD.delete(user);
        System.out.println("Пользователь " +user+ " удален");

        //Category creation
        Category category = new Category(-1, 0, "Development", "For Soft Devs");
        CategoryCRUD.create(category);
        System.out.println("Категория " + category.getCategoryname() + " создана");
        tmpstr = category.getCategoryname();
        category.setCategoryname("SoftDev");
        CategoryCRUD.update(category);
        System.out.println("Категория " + tmpstr + "переименован в " + category.getCategoryname());
        CategoryCRUD.delete(category);
        System.out.println("Категория " + category.getCategoryname() + " удалена");
        CategoryCRUD.create(category);
        System.out.println("Категория " + category.getCategoryname() + " создана");
        CategoryCRUD.read(1);
        System.out.println("1-я Категория - " + category);

        //Author creations
        Author author = new Author(-1, "Shildt");
        AuthorCRUD.create(author);
        System.out.println("Автор " + author.getAuthorname() + " создан");
        author.setAuthorname("Herbert Shildt");
        AuthorCRUD.update(author);
        System.out.println("Автор переименован в " + author.getAuthorname());
        AuthorCRUD.read(1);
        System.out.println("1-й Автор " + author);

        //Book creation
        Book book = new Book(-1, 2, ConnectionCreator.getCurrentTimeStamp(), "Java The Complete Reference Ninth Edition",
                "English", "1", "USA", "This edition of the book contains a substantial amount of new material " +
                "because Java SE 8 adds several new features to the Java language.", "PDF", "books/1.zip",
                "books/images/1.jpg", 1);
        BookCRUD.create(book);
        System.out.println("Книга " + book.getBookname() + " создана");
        tmpstr= book.getBookname();
        book.setBookname("Java The Complete Reference");
        BookCRUD.update(book);
        System.out.println("Книга переименована в " + book.getBookname());
        BookCRUD.read(1);
        System.out.println("Книга под 1 индексом" + book);
    }
}
