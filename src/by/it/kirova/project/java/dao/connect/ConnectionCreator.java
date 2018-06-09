package by.it.kirova.project.java.dao.connect;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    // для MySQL only
//    private static DataSource ds;
//
//    static {
//        try {
//            InitialContext initialContext = new InitialContext();
//            ds = (DataSource) initialContext.lookup("java:/comp/env/jdbc/my_sql_kirova");
//
//        } catch (NamingException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static Connection getConnection() throws SQLException {
//        return ds.getConnection();
//    }
//    для JAVA
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

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized ((ConnectionCreator.class)) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(CN.URL_DB, CN.USERDB, CN.PASSWORD);
                }
            }
        }
        return connection;
    }


}
