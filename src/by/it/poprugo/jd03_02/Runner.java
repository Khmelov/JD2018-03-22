package by.it.poprugo.jd03_02;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        User user = new User(-1, "lll", "ppp", "eee", 2);
        CRUD.createUser(user);
        user.setLogin("www");
        /*CRUD.updateUser(user);
        CRUD.deleteUser(user);
        user=CRUD.readUser(1);
        System.out.println(user);*/
    }
}
