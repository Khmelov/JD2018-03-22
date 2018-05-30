package by.it.sgolovach.jd03_02.taskC;

import by.it.sgolovach.jd03_02.beans.Role;
import by.it.sgolovach.jd03_02.crud.RolesCRUD;

import java.sql.SQLException;

public class AdRoles {
    public static void main(String[] args) throws SQLException {
        Role role = new Role(-1, "admin");
        RolesCRUD.create(role);
        role = new Role(-1, "user");
        RolesCRUD.create(role);
        role = new Role(-1, "guest");
        RolesCRUD.create(role);
        role = new Role(-1, "director");
        RolesCRUD.create(role);
    }
}
