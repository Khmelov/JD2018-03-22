package by.it.akhmelev.jd03_02;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        User user=new User(-1,"llll","pppp","eeeee",2);
        CRUD.createUser(user);
        user.setLogin("wewwwww");
        CRUD.updateUser(user);
        CRUD.deleteUser(user);
        user=CRUD.readUser(1);
        System.out.println(user);
    }
}
