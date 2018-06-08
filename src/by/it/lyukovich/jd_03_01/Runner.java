package by.it.lyukovich.jd_03_01;

import java.util.Calendar;

public class Runner {
    public static void main(String[] args) {
        C_Reset.resetDB();
        C_Init.initDB();
        B_AddRoles.addRoles();
        A_AddUser.addUser("admin@skylib.by", "admin", "admin", "Admin", "Adminovich", 1);
        A_AddUser.addUser("moderator@skylib.by", "moderator", "moderator", "moderator", "moderatorovich", 2);
        A_AddUser.addUser("user@skylib.by", "user", "user", "User", "Userovich", 3);
        A_AddData.addAuthor("Shildt Herbert");
        A_AddData.addAuthor("Joshua Bloch");
        A_AddData.addCategory(0, "Programming", "Books for devs");
        A_AddData.addBook(1, getCurrentTimeStamp(), "Java The Complete Reference Ninth Edition",
                "English", "1", "USA", "This edition of the book contains"+
                        "a substantial amount of new material"+
                        "because Java SE 8 adds several new features to the Java language.",
                "PDF", "books/1.zip","books/images/1.jpg", 1);
        A_AddData.addBook(1, getCurrentTimeStamp(), "Effective Java (3rd Edition)",
                "English", "2", "USA", "Java has changed dramatically since the previous edition of Effective Java was published shortly after the release of Java 6. This Jolt award-winning classic has now been thoroughly updated to take full advantage of the latest language and library features. The support in modern Java for multiple paradigms increases the need for specific best-practices advice, and this book delivers.",
                "PDF", "books/2.zip","books/images/2.jpg", 1);
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {
        return new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    }
}
