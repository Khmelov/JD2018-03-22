package by.it.pashkevich.jd03_03;

import by.it.pashkevich.jd03_03.beans.Product;
import by.it.pashkevich.jd03_03.beans.Role;
import by.it.pashkevich.jd03_03.beans.User;
import by.it.pashkevich.jd03_03.dao.DAO;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        dao.reset();

        System.out.println("\n===== Проверим DAO для бина Role");
        System.out.println("\n=== Выведем все существующие роли");
        System.out.println(dao.role.getAll(""));
        Role role = new Role(-1, "testRole");
        dao.role.create(role);
        System.out.println("\n=== Создадим тестовую роль");
        System.out.println(dao.role.getAll(""));
        role.setRole("testRoleForDelete");
        dao.role.update(role);
        System.out.println("\n=== Обновим имя тестовой роли");
        System.out.println(dao.role.getAll(""));
        System.out.println("\n=== Удалим тестовую роль");
        dao.role.delete(role);
        System.out.println(dao.role.getAll(""));

        System.out.println("\n===== Проверим DAO для бина User");
        System.out.println("\n=== Выведем всех существующих юзеров");
        System.out.println(dao.user.getAll(""));
        User user = new User(-1, "testUser", "testUserPass", "testUserEmail", 2);
        dao.user.create(user);
        System.out.println("\n=== Создадим тестового юзера");
        System.out.println(dao.user.getAll(""));
        user.setLogin("testUserForDelete");
        System.out.println("\n=== Обновим тестового юзера");
        dao.user.update(user);
        System.out.println(dao.user.getAll(""));
        System.out.println("\n=== Удалим тестового юзера");
        dao.user.delete(user);
        System.out.println(dao.user.getAll(""));

        System.out.println("\n===== Проверим DAO для бина Product");
        System.out.println("\n=== Выведем все существующие товары");
        System.out.println(dao.product.getAll(""));
        Product product = new Product(-1, "Igor", "Evil", 888, 2);
        System.out.println("\n=== Создадим 'Badboy' Игоря");
        dao.product.create(product);
        System.out.println(dao.product.getAll(""));
        product.setDescription("Good");
        System.out.println("\n=== Сделаем Игоря хорошим");
        dao.product.update(product);
        System.out.println(dao.product.getAll(""));
        System.out.println("\n=== Удалим хорошего Игоря");
        dao.product.delete(product);
        System.out.println(dao.product.getAll(""));
    }
}