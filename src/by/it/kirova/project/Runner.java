package by.it.kirova.project;

import by.it.kirova.project.java.beans.*;
import by.it.kirova.project.java.dao.DAO;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstanceDAO();
        DAO.resetDB();


        //Role CRUD
        System.out.println("\nCRUD operations for bean Role");
        Role role = new Role(-1, "testRole");
        dao.role.create(role);
        System.out.println(dao.role.getAll(""));
        dao.role.update(role);
        System.out.println(dao.role.getAll(""));
        dao.role.delete(role);
        System.out.println(dao.role.getAll(""));

        //User CRUD
        System.out.println("\nCRUD operations for bean User");
        User user = new User(-1, "testEmail", "testPassword", "testFirstName",
                "testLastName", "testMiddleName", "testResidenceCountry",
                "testPhoneNumber", 1);
        dao.user.create(user);
        System.out.println(dao.user.getAll(""));
        dao.user.update(user);
        System.out.println(dao.user.getAll(""));
        dao.user.delete(user);
        System.out.println(dao.user.getAll(""));

        //Hotel CRUD
        System.out.println("\nCRUD operations for bean Hotel");
        Hotel hotel = new Hotel(-1, "testName", "testType", 5,
                "testCountry", "testCity", "testStreet", "testHouseNumber",
                "testContactEmail", "testContactPhoneNumber", 1);
        dao.hotel.create(hotel);
        System.out.println(dao.hotel.getAll(""));
        dao.hotel.update(hotel);
        System.out.println(dao.hotel.getAll(""));
        dao.hotel.delete(hotel);
        System.out.println(dao.hotel.getAll(""));

        //Room CRUD
        System.out.println("\nCRUD operations for bean Room");
        Room room = new Room(-1, "testRoomName", "250",
                4, "testDescription", 45.8, 1);
        dao.room.create(room);
        System.out.println(dao.room.getAll(""));
        dao.room.update(room);
        System.out.println(dao.room.getAll(""));
        dao.room.delete(room);
        System.out.println(dao.room.getAll(""));

        //Reservation CRUD
        System.out.println("\nCRUD operations for bean Room");
        Reservation reservation = new Reservation(-1, 61481855662587L,
                61481855662587L, 61481855662587L, 85.2, 1,1);
        dao.reservation.create(reservation);
        System.out.println(dao.reservation.getAll(""));
        dao.reservation.update(reservation);
        System.out.println(dao.reservation.getAll(""));
        dao.reservation.delete(reservation);
        System.out.println(dao.reservation.getAll(""));





    }
}
