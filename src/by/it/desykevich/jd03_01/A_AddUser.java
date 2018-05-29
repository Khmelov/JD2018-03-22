package by.it.desykevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;



public class A_AddUser {
    public static void main(String[] args) {

            addUser();
        }

    public static void addUser() {

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

        try(Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/desykevich"+
                        "?useUnicode=true&characterEncoding=UTF-8",
                    "root",
                    "")){

            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO `desykevich`.`users` ( `login`, `password`, `email`, `nickname`, `phonenumber`, `roles_id`) VALUES ( 'admin', '1234', 'admin@tut.by', 'administrator', '+3275278532', 1);");
            System.out.println(statement);

//            Statement statement= connection.createStatement();
//            ResultSet resultSet=statement.executeQuery("select * from users");
//            while (resultSet.next()){
//                String txt =
//                        resultSet.getString("login")
//                                + ":"
//                                +resultSet.getString("password")
//                                +":"+
//                                resultSet.getString("email");
//                System.out.println(txt);
//            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
