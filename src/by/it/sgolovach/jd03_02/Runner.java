package by.it.sgolovach.jd03_02;

import by.it.sgolovach.jd03_02.beans.Ad;
import by.it.sgolovach.jd03_02.beans.Role;
import by.it.sgolovach.jd03_02.beans.User;
import by.it.sgolovach.jd03_02.crud.AdCRUD;
import by.it.sgolovach.jd03_02.crud.RolesCRUD;
import by.it.sgolovach.jd03_02.crud.UsersCRUD;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {


        Role role = new Role(-1, "testRole");
        RolesCRUD.create(role);
        role.setRole("testRoleForDelete");
        RolesCRUD.update(role);
        RolesCRUD.delete(role);
        System.out.println(role);
        role = RolesCRUD.read(1);
        System.out.println(role + "\n");

        User user = new User(-1, "testUser", "testUserEmail", "testUserPass", 2);
        UsersCRUD.create(user);
        user.setLogin("testUserForDelete");
        UsersCRUD.update(user);
        UsersCRUD.delete(user);
        System.out.println(user);
        user = UsersCRUD.read(1);
        System.out.println(user + "\n");

        Ad ad = new Ad(-1,"хорошая квартира",3,25635.0,36.5,5,9,"Минск 25-6",2);
        AdCRUD.create(ad);
        ad.setDescription("testAdForDelete");
        AdCRUD.update(ad);
        AdCRUD.delete(ad);
        System.out.println(ad);
        ad = AdCRUD.read(1);
        System.out.println(ad+"\n");

    }
}
