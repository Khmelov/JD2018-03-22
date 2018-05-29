package by.it.desykevich.jd03_03.dao.connect;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionCreator {

     static private Connection connection;

     static {

         try {
             Class.forName("com.mysql.jdbc.Driver");
         }catch (ClassNotFoundException e){
             e.printStackTrace();
         }

         try{
             Driver driver=new FabricMySQLDriver();
         }catch (SQLException e){
             e.printStackTrace();
         }
     }

     private ConnectionCreator(){}


     static Connection getConnection()throws SQLException {
         if (connection==null||connection.isClosed()){
          synchronized (ConnectionCreator.class){
              if (connection==null|| connection.isClosed()){
                  connection= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD);
              }
          }
         }
         return connection;
     }
}
