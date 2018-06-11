package by.it.fando.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class A_AddUser {

//    try {
//        Class.forName("com.mysql.jdbc.Driver");
//    } catch (ClassNotFoundException e) {
//        e.printStackTrace();
//    }

    {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
