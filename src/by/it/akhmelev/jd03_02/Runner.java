package by.it.akhmelev.jd03_02;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        //проверим CRUD для бина User
        User user = new User(-1, "testUser", "testUserPass", "testUserEmail", 2);
        UserCRUD.create(user);
        user.setLogin("testUserForDelete");
        UserCRUD.update(user);
        UserCRUD.delete(user);
        System.out.println(user);
        user = UserCRUD.read(1);
        System.out.println(user+"\n");

        //проверим CRUD для бина Ad
        Ad ad = new Ad(
                -1,
                "testAd",
                2,
                66666.0,
                48.0,
                3,
                5,
                "пр. Мулявина 3, кв. 33 ",
                2
        );
        AdCRUD.create(ad);
        ad.setDescription("testAdForDelete");
        AdCRUD.update(ad);
        AdCRUD.delete(ad);
        System.out.println(ad);
        ad = AdCRUD.read(1);
        System.out.println(ad+"\n");

        //проверим CRUD для бина Role
        Role role=new Role(-1,"testRole");
        RoleCRUD.create(role);
        role.setRole("testRoleForDelete");
        RoleCRUD.update(role);
        RoleCRUD.delete(role);
        System.out.println(role);
        role = RoleCRUD.read(1);
        System.out.println(role+"\n");

        
    }
}
