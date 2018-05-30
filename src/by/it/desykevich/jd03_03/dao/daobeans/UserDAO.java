package by.it.desykevich.jd03_03.dao.daobeans;


import by.it.desykevich.jd03_03.dao.UniversalDAO;

public class UserDAO  extends UniversalDAO<User>{

    public UserDAO() {
        super( new User(), "users");
    }
}
