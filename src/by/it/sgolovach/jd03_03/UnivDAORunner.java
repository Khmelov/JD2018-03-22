package by.it.sgolovach.jd03_03;

import by.it.sgolovach.jd03_03.beans.Ad;
import by.it.sgolovach.jd03_03.beans.Role;
import by.it.sgolovach.jd03_03.beans.User;
import by.it.sgolovach.jd03_03.dao.DAO;
import by.it.sgolovach.jd03_03.dao.UniversalDAO;

import java.sql.SQLException;

public class UnivDAORunner {
    public static void main(String[] args) throws SQLException {

        DAO dao = DAO.getInstance();
        dao.reset();

        // читаем все роли и по id
        UniversalDAO<Role> roleUniversalDAO = new UniversalDAO<>(new Role(), "roles");
        roleUniversalDAO.create(new Role(-1, "roleDirector"));
        System.out.println(roleUniversalDAO.read(5));
        roleUniversalDAO.update(new Role(5, "updateRoleDirector"));
        System.out.println(roleUniversalDAO.getAll(""));
        System.out.println(roleUniversalDAO.read(5));
        roleUniversalDAO.delete(roleUniversalDAO.read(5));
        System.out.println(roleUniversalDAO.read(1));
        System.out.println(roleUniversalDAO.read(2));
        System.out.println(roleUniversalDAO.read(3));
        System.out.println(roleUniversalDAO.read(4));
        System.out.println(roleUniversalDAO.read(5));


        // читаем все users и по id
        UniversalDAO<User> userUniversalDAO = new UniversalDAO<>(new User(), "users");
        System.out.println(userUniversalDAO.getAll(""));
        System.out.println(userUniversalDAO.read(1));
        System.out.println(userUniversalDAO.read(3));
        System.out.println(userUniversalDAO.read(2));
        System.out.println(userUniversalDAO.read(6));
        System.out.println(userUniversalDAO.read(1));

        // читаем все ads и по id
        UniversalDAO<Ad> adUniversalDAO = new UniversalDAO<>(new Ad(), "ads");
        System.out.println(adUniversalDAO.getAll(""));
        System.out.println(adUniversalDAO.read(1));
        System.out.println(adUniversalDAO.read(3));
        System.out.println(adUniversalDAO.read(7));
        System.out.println(adUniversalDAO.read(5));
        System.out.println(adUniversalDAO.read(2));
        System.out.println(adUniversalDAO.read(4));
        System.out.println(adUniversalDAO.read(8));


    }
}
