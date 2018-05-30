package by.it.desykevich.jd03_02;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

 public class ConnectionCreator {
    static private Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private ConnectionCreator() {
    }

    static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (ConnectionCreator.class) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(CN.URL_DB, CN.USERDB, CN.PASSWORD);
                }
            }
        }
        return connection;
    }
}


//public class ConnectionCreator {
//
//    private static Connection connection;
//
//    public static Connection getConnection() {
//        try {
//            if (connection == null || connection.isClosed()) {
//                connection = DriverManager.getConnection(
//                        "jdbc:mysql://127.0.0.1:3306/krasutski" +
//                                "?useUnicode=true&characterEncoding=UTF-8",
//                        "root",
//                        ""
//                );
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
//}