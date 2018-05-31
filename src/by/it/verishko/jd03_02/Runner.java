package by.it.verishko.jd03_02;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

        System.out.println("Create + Read + Delete Role");
        Role role = new Role(-1, "testRole");
        RoleCRUD.create(role);
        role.setRole("testRoleForDelete");
        RoleCRUD.update(role);
        RoleCRUD.delete(role);
        System.out.println(role);
        role = RoleCRUD.read(1);
        System.out.println(role + "\n");

        System.out.println("Create + Read + Delete User");
        User user = new User(-1, "testUser", "testUserPass", "testUserEmail", 2);
        UserCRUD.create(user);
        user.setLogin("testUserForDelete");
        UserCRUD.update(user);
        UserCRUD.delete(user);
        System.out.println(user);
        user = UserCRUD.read(1);
        System.out.println(user + "\n");

        System.out.println("Create + Read + Delete Product");
        Product product = new Product(
                -1,
                "Valera",
                "neighbour",
                777,
                2
        );
        ProductCRUD.create(product);
        product.setDescription("testAdForDelete");
        ProductCRUD.update(product);
        ProductCRUD.delete(product);
        System.out.println(product);
        product = ProductCRUD.read(1);
        System.out.println(product + "\n");
    }
}
