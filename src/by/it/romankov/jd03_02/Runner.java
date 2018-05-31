package by.it.romankov.jd03_02;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Roles role = new Roles("testRole", -1);
        RolesCRUD.create(role);
        role.setRole("testRoleForDelete");
        RolesCRUD.update(role);
        RolesCRUD.delete(role);
        System.out.println(role);
        role = RolesCRUD.read(1);
        System.out.println(role + "\n");


        People people = new People(-1, "testName", "test@tut", "5657432", 2, 1);
        PeopleCRUD.create(people);
        people.setName("testName");
        PeopleCRUD.update(people);
        PeopleCRUD.delete(people);
        System.out.println(people);
        people = PeopleCRUD.read(2);
        System.out.println(people + "\n");




        Tours tour = new Tours(4,"rest","plane","France","Cannes",10,2000,2);
        ToursCRUD.create(tour);
        tour.setCity("Paris");
        ToursCRUD.update(tour);
        ToursCRUD.delete(tour);
        System.out.println(tour);
        tour=ToursCRUD.read(3);
        System.out.println(tour);

    }
}