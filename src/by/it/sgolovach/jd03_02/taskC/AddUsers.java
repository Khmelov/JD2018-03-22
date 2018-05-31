package by.it.sgolovach.jd03_02.taskC;

import by.it.sgolovach.jd03_02.beans.User;
import by.it.sgolovach.jd03_02.crud.UsersCRUD;

import java.sql.SQLException;

public class AddUsers {
    public static void main(String[] args) throws SQLException {

        User user = new User(-1, "administrator", "administrator", "adm@mail.ru", 1);
        UsersCRUD.create(user);
        user = new User(-1, "user", "user", "user@mail.ru", 2);
        UsersCRUD.create(user);
        user = new User(-1, "user2", "user2", "user2@mail.ru", 2);
        UsersCRUD.create(user);
        user = new User(-1, "user3", "user3", "user3@mail.ru", 2);
        UsersCRUD.create(user);
        user = new User(-1, "guest", "guest", "guest3@mail.ru", 3);
        UsersCRUD.create(user);
        user = new User(-1, "director", "director", "director@mail.ru", 4);
        UsersCRUD.create(user);

    }
}
