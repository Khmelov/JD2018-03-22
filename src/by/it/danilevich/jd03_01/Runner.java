package by.it.danilevich.jd03_01;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
       // TaskA.printUser();
       // TaskA.printUserRole();
       // TaskB.addRoles();
        TaskC.deleteDateBase();
        TaskC.createDateBase();
        TaskA.printUser();
        TaskA.printUserRole();
        TaskB.addRoles();
    }
}
