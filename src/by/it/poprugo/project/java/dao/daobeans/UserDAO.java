package by.it.poprugo.project.java.dao.daobeans;

import by.it.poprugo.project.java.beans.User;
import by.it.poprugo.project.java.dao.UniversalDAO;

public class UserDAO extends UniversalDAO<User> {
    public UserDAO() {
        super(new User(), "users");
    }
}
