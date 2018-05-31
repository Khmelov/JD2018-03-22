package by.it.desykevich.jd03_03;

import by.it.desykevich.jd03_03.beans.Role;
import by.it.desykevich.jd03_03.beans.User;
import by.it.desykevich.jd03_03.dao.DAO;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao=DAO.getInstanse();
        dao.reset();

        System.out.println("\n=== Проверим DAO для бина Role");
        System.out.println(dao.roleDAO.getAll(""));
        Role role = new Role(-1, "testRole");
        dao.roleDAO.create(role);
        System.out.println(dao.roleDAO.getAll(""));
        role.setRole("testRoleForDelete");
        dao.roleDAO.update(role);
        System.out.println(dao.roleDAO.getAll(""));
        dao.roleDAO.delete(role);
        System.out.println(dao.roleDAO.getAll(""));

//        System.out.println("\n=== Проверим DAO для бина User");
//        System.out.println(dao.userDAO.getAll(""));
//        User user = new User(-1, "testUser", "testUserEmail","testUserPass","testUserNickName","testUserPhone", 2);
//        dao.userDAO.create(user);
//        System.out.println(dao.userDAO.getAll(""));
//        user.setLogin("testUserForDelete");
//        dao.userDAO.update(user);
//        System.out.println(dao.userDAO.getAll(""));
//        dao.userDAO.delete(user);
//        System.out.println(dao.userDAO.getAll(""));
    }
}
