//package by.it.uskoryaev.jd03_02;
//
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//class ConnectionCreator {
//    static private Connection connection;
//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Driver driver = new FabricMySqlDriver();
//            DriverManager.registerDriver(driver);
//        }catch (SQLException | ClassNotFoundException e){
//            e.getStackTrace();
//        }
//    }
//
//    private ConnectionCreator(){}
//
//    static Connection getConnection() throws SQLException{
//        if (connection == null||connection.isClosed()){
//            synchronized (ConnectionCreator.class){
//                if (connection == null || connection.isClosed()){
//                    connection = DriverManager.getConnection(CN.URL_DB,CN.USER_DB, CN.PASSWORD);
//                }
//            }
//        }
//    }
//}
