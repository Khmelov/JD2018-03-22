package by.it.desykevich.jd03_02;

import by.it.desykevich.jd03_01.B_AddRoles;
import by.it.desykevich.jd03_01.C_Reset;
import by.it.desykevich.jd03_02.beans.Ad;
import by.it.desykevich.jd03_02.beans.User;
import by.it.desykevich.jd03_02.database.DataBaseInit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TaskA {


    private static UserCRUD userCRUD = new UserCRUD();
    private static AdCRUD adCRUD = new AdCRUD();
    private static User first = new User(0,"asd","asd@it.by","asdasd",
            "Asd123","+375253453213",2);
    private static User second = new User(0,"qwerty","qwerty@it.by","qwerty",
            "Qwerty123","+375447575832",2);
    private static Ad ad = new Ad(0,"Samsung", "Good",
             569, 2,3);

    public static void main(String[] args) throws SQLException {
        C_Reset.resetDB();
        DataBaseInit.initDB();
        B_AddRoles.addRoles();
        createRead();
        updateRead();
        deleteUser();
        System.out.println("--------------Roles--------------");
        System.out.println("Administrator ID: " + findRole("Administrator"));
        System.out.println("User ID: " + findRole("User"));
        System.out.println("Guest ID: " + findRole("Guest"));
    }

    private static void createRead() throws SQLException {
        adCRUD.create(ad);
        System.out.println(adCRUD.read(4));
        userCRUD.create(first);
        userCRUD.create(second);
        System.out.println(userCRUD.read(1));
        System.out.println(userCRUD.read(2));
        System.out.println(userCRUD.read(3));
        System.out.println(userCRUD.read(4));

    }

    private static void updateRead() throws SQLException{
        first.setNickname("Asd12345");
        userCRUD.update(first);
        System.out.println(userCRUD.read(3) + " updated.");
        second.setPhoneNumber("+375297578924");
        userCRUD.update(second);
        System.out.println(userCRUD.read(4) + " updated.");
    }

    private static void deleteUser() throws SQLException{
        if (userCRUD.delete(second))
            System.out.println(second + " deleted.");
        else
            System.out.println("Can't delete user: " + second);
    }

    private static int findRole(String Role) throws SQLException{
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            ResultSet resultSet = statement.executeQuery(String.format("SELECT ID FROM roles WHERE Role='%s'", Role));
            if (resultSet.next())
                return resultSet.getInt(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
