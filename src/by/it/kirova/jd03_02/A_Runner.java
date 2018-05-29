package by.it.kirova.jd03_02;

import java.sql.SQLException;

public class A_Runner {
    public static void main(String[] args) throws SQLException {

        //Перед запуском Runner запустить:
        // C_DBReset, затем C_DBInitWithoutData (каркас БД без заполненных полей)

        //Create + Read User
        System.out.println("Create + Read User");
        User user = new User(0, "abcdf@gmail.com", "dfgdfgjdf", "John", "Davis", null, "US", "+73135462678552");
        UserCRUD.create(user);
        user = UserCRUD.read(1);
        System.out.println(user + "\n");

        //Update + Read User
        System.out.println("Update + Read User");
        user.setEmail("ASERF@GMAIL.COM");
        UserCRUD.update(user);
        user = UserCRUD.read(1);
        System.out.println(user+ "\n");


        //Create + Read Role
        System.out.println("Create + Read Role");
        Role role = new Role(0, "admin");
        RoleCRUD.create(role);
        role = RoleCRUD.read(1);
        System.out.println(role+ "\n");

        //Find role id for role_name
        System.out.println("Find role id for role_name");
        int role_number = RoleCRUD.findIdRole("admin");
        System.out.println("Номер роли \"admin\" = " + role_number+ "\n");

        //Update + Read Role
        System.out.println("Update + Read Role");
        role.setRole_name("owner");
        RoleCRUD.update(role);
        role = RoleCRUD.read(1);
        System.out.println(role+ "\n");


        //Create + Read RHU
        System.out.println("Create + Read Role_has_users");
        RHU rhu = new RHU(1, 1);
        RHUCRUD.create(rhu);
        rhu = RHUCRUD.read(1);
        System.out.println(rhu+ "\n");

        //Update + Read RHU
        System.out.println("Update + Read Role_has_users");
        rhu.setRole_role_id(1);
        RHUCRUD.update(rhu);
        rhu = RHUCRUD.read(1);
        System.out.println(rhu+ "\n");


        //Create + Read Hotel
        System.out.println("Create + Read Hotel");
        Hotel hotel = new Hotel(0, "SPA RESORT", "Hotel", 5, "Austria", "Vienna", "Buhgasse", "82", "abcg@gmail.com", "+453538333454552", 1);
        HotelCRUD.create(hotel);
        hotel = HotelCRUD.read(1);
        System.out.println(hotel+ "\n");

        //Update + Read Role
        System.out.println("Update + Read Hotel");
        hotel.setHotel_name("RESORT VIENNA");
        HotelCRUD.update(hotel);
        hotel = HotelCRUD.read(1);
        System.out.println(hotel+ "\n");

        //Delete + Message Hotel
        System.out.println("Delete + Read Hotel");
        HotelCRUD.delete(hotel);
        hotel = HotelCRUD.read(1);
        System.out.println(hotel+ "\n");

        //Delete + Message RHU
        System.out.println("Delete + Read Role_has_users");
        RHUCRUD.delete(rhu);
        rhu = RHUCRUD.read(1);
        System.out.println(rhu+ "\n");

        //Delete + Message User
        System.out.println("Delete + Read User");
        UserCRUD.delete(user);
        user = UserCRUD.read(1);
        System.out.println(user+ "\n");

        //Delete + Message Role
        System.out.println("Delete + Read Role");
        RoleCRUD.delete(role);
        role = RoleCRUD.read(1);
        System.out.println(role+ "\n");


    }
}
