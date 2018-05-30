package by.it.romankov.jd03_03;

import by.it.romankov.jd03_03.beans.People;
import by.it.romankov.jd03_03.beans.Roles;
import by.it.romankov.jd03_03.beans.Tours;
import by.it.romankov.jd03_03.dao.DAO;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao =DAO.getInstance();
        dao.reset();

        System.out.println("проверим CRUD для бина Roles");
        System.out.println(dao.role.getAll(""));
        Roles role=new Roles("testRole",-1);
        dao.role.create(role);
        System.out.println(dao.role.getAll(""));
        role.setRole("testRoleForDelete");
        dao.role.update(role);
        System.out.println(dao.role.getAll(""));
        dao.role.delete(role);
        System.out.println(dao.role.getAll(""));

        System.out.println("проверим CRUD для бина People");
        System.out.println(dao.people.getAll(""));
        People people = new People(5,"Pasha","oleg@tut.by",56575859,37,3);
        dao.people.create(people);
        System.out.println(dao.people.getAll(""));
        people.setAge(40);
        dao.people.update(people);
        System.out.println(dao.people.getAll(""));
        dao.people.delete(people);
        System.out.println(dao.people.getAll(""));

        System.out.println("проверим CRUD для бина Tours");
        System.out.println(dao.tour.getAll(""));
        Tours tour = new Tours(-1,"rest","plane","France","Cannes",14,2500,4);
        dao.tour.create(tour);
        System.out.println(dao.tour.getAll(""));
        tour.setPrice(3500);
        dao.tour.update(tour);
        System.out.println(dao.tour.getAll(""));
        dao.tour.delete(tour);
        System.out.println(dao.tour.getAll(""));
}
}
