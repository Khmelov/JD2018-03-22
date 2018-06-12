package by.it.poprugo.jd03_03_mine;

import by.it.poprugo.jd03_03_mine.beans.Model;
import by.it.poprugo.jd03_03_mine.beans.Role;
import by.it.poprugo.jd03_03_mine.beans.User;
import by.it.poprugo.jd03_03_mine.dao.DAO;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        dao.reset();

        System.out.println("проверим CRUD для бина Role");
        System.out.println(dao.role.getAll(""));
        Role role=new Role(-1,"testRole");
        dao.role.create(role);
        System.out.println(dao.role.getAll(""));
        role.setRole("testRoleForDelete");
        dao.role.update(role);
        System.out.println(dao.role.getAll(""));
        dao.role.delete(role);
        System.out.println(dao.role.getAll(""));

        System.out.println("проверим CRUD для бина User");
        System.out.println(dao.user.getAll(""));
        User user = new User(-1, "testUser", "testUserPass", "testUserEmail", 2);
        dao.user.create(user);
        System.out.println(dao.user.getAll(""));
        user.setLogin("testUserForDelete");
        dao.user.update(user);
        System.out.println(dao.user.getAll(""));
        dao.user.delete(user);
        System.out.println(dao.user.getAll(""));

        System.out.println("проверим CRUD для бина Model");
        System.out.println(dao.model.getAll(""));
        Model modelTest = new Model(
                -1,
                "testModel",
                "Ivan",
                "ул.Я.Коласа 8, кв. 35 ",
                "3352533",
                "2018-may-26-1",
                "2018-may-26-1",
                800,
                350,
                2
        );
        dao.model.create(modelTest);
        System.out.println(dao.model.getAll(""));
        modelTest.setModel("testModelForDelete");
        dao.model.update(modelTest);
        System.out.println(dao.model.getAll(""));
        dao.model.delete(modelTest);
        System.out.println(dao.model.getAll(""));
    }
}
