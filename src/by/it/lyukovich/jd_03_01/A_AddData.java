package by.it.lyukovich.jd_03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.Calendar;

public class A_AddData {
    public static void main(String[] args) {
        addAuthor("Shildt Herbert");
        addAuthor("Joshua Bloch");
        addCategory(0, "Programming", "Books for devs");
        addBook(1, getCurrentTimeStamp(), "Java The Complete Reference Ninth Edition",
                "English", "1", "USA", "This edition of the book contains"+
                        "a substantial amount of new material"+
                        "because Java SE 8 adds several new features to the Java language.",
                "PDF", "books/1.zip","books/images/1.jpg", 1);
        addBook(1, getCurrentTimeStamp(), "Effective Java (3rd Edition)",
                "English", "2", "USA", "Java has changed dramatically since the previous edition of Effective Java was published shortly after the release of Java 6. This Jolt award-winning classic has now been thoroughly updated to take full advantage of the latest language and library features. The support in modern Java for multiple paradigms increases the need for specific best-practices advice, and this book delivers.",
                "PDF", "books/2.zip","books/images/2.jpg", 1);
    }

    public static void addBook(Integer categoryid, Timestamp bookdateadded, String bookname, String booklang,
                               String bookauthors, String bookcountry, String bookdescription,
                               String bookformat, String bookfilename, String bookimgname,
                               Integer uploadedbyuser){
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
                             "jdbc:mysql://127.0.0.1:2016/"+C_Init.DB+"",
                             "root",
                             "")) {
            String INSERT_USER = "insert into books(bookid, categoryid, bookdateadded, bookname, booklang, bookauthors, bookcountry," +
                    " bookdescription, bookformat, bookfilename, bookimgname, uploadedbyuser) values(DEFAULT,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setInt(1, categoryid);
            preparedStatement.setTimestamp(2, bookdateadded);
            preparedStatement.setString(3, bookname);
            preparedStatement.setString(4, booklang);
            preparedStatement.setString(5, bookauthors);
            preparedStatement.setString(6, bookcountry);
            preparedStatement.setString(7, bookdescription);
            preparedStatement.setString(8, bookformat);
            preparedStatement.setString(9, bookfilename);
            preparedStatement.setString(10, bookimgname);
            preparedStatement.setInt(11, uploadedbyuser);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.println("Создание книги " + bookname + " выполнено");
        } catch (SQLException e) {
            if (e.toString().contains("Duplicate entry")){System.out.println("Книга " + bookname + " уже существует");}
            else System.out.println("При создании книги возникла ошибка" + e.toString());
        }
    }

    public static void addCategory(Integer categorysubid, String categoryname, String categorydescription){
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
                             "jdbc:mysql://127.0.0.1:2016/"+C_Init.DB+"",
                             "root",
                             "")) {
            String INSERT_USER = "insert into category(categoryid, categorysubid, categoryname,categorydescription) values(DEFAULT,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setInt(1, categorysubid);
            preparedStatement.setString(2, categoryname);
            preparedStatement.setString(3, categorydescription);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.println("Создание категории " + categoryname + " выполнено");
        } catch (SQLException e) {
            if (e.toString().contains("Duplicate entry")){System.out.println("Категория " + categoryname + " уже существует");}
            else System.out.println("При создании категории возникла ошибка" + e.toString());
        }
    }

    public static void addAuthor(String authorname){
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
                             "jdbc:mysql://127.0.0.1:2016/"+C_Init.DB+"",
                             "root",
                             "")) {
            String INSERT_USER = "insert into authors(authorid, authorname) values(DEFAULT,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, authorname);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.println("Создание автора " + authorname + " выполнено");
        } catch (SQLException e) {
            if (e.toString().contains("Duplicate entry")){System.out.println("Автор " + authorname + " уже существует");}
            else System.out.println("При создании автора возникла ошибка" + e.toString());
        }
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {
        return new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    }
}
