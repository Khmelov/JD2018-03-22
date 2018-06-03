package by.it.desykevich.jd03_03;

import by.it.desykevich.jd03_03.beans.Ad;
import by.it.desykevich.jd03_03.beans.Category;
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

        System.out.println("\n=== Проверим DAO для бина User");
        System.out.println(dao.userDAO.getAll(""));
        User user = new User(-1, "testUser", "testUserEmail","testUserPass","testUserNickName","testUserPhone", 2);
        dao.userDAO.create(user);
        System.out.println(dao.userDAO.getAll(""));
        user.setLogin("testUserForDelete");
        dao.userDAO.update(user);
        System.out.println(dao.userDAO.getAll(""));
        dao.userDAO.delete(user);
        System.out.println(dao.userDAO.getAll(""));

        System.out.println("\n=== Проверим DAO для бина Ad");
        System.out.println(dao.adDAO.getAll(""));
        Ad ad = new Ad(-1, "testAd", "sww",500,2,2);
        dao.adDAO.create(ad);
        System.out.println(dao.adDAO.getAll(""));
        ad.setDescription("testAdForDelete");
        dao.adDAO.update(ad);
        System.out.println(dao.adDAO.getAll(""));
        dao.adDAO.delete(ad);
        System.out.println(dao.adDAO.getAll(""));


        System.out.println("\n=== Проверим DAO для бина Category");
        System.out.println(dao.categoryDAO.getAll(""));
        Category category = new Category(-1, "testCategory");
        dao.categoryDAO.create(category);
        System.out.println(dao.categoryDAO.getAll(""));
        category.setName("testCategoryForDelete");
        dao.categoryDAO.update(category);
        System.out.println(dao.categoryDAO.getAll(""));
        dao.categoryDAO.delete(category);
        System.out.println(dao.categoryDAO.getAll(""));
    }
}
