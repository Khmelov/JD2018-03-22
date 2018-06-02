package by.it.uskoryaev.project.java.dao.daobeans;

import by.it.uskoryaev.project.java.beans.User;
import by.it.uskoryaev.project.java.dao.UniversalDAO;

public class UserDAO extends UniversalDAO<User> {
    public UserDAO() {
        super(new User(), "user");
    }
}
