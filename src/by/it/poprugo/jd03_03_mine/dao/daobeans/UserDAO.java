package by.it.poprugo.jd03_03_mine.dao.daobeans;

import by.it.poprugo.jd03_03_mine.beans.User;
import by.it.poprugo.jd03_03_mine.dao.UniversalDAO;

public class UserDAO extends UniversalDAO<User> {

    public UserDAO() {
        super(new User(), "users"); // sqlTableName = "users"
    }
}
