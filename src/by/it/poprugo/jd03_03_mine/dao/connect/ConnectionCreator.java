package by.it.poprugo.jd03_03_mine.dao.connect;

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

    private ConnectionCreator() {} // может, всё-таки public ???

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (ConnectionCreator.class) {
                connection = DriverManager.getConnection(CN.URL_DB, CN.USERDB, CN.PASSWORD);
            }
        }
        return connection;
    }
}