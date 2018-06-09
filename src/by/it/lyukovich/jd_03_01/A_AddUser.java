package by.it.lyukovich.jd_03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.Calendar;

public class A_AddUser {
    public static void main(String[] args) {
        addUser("admin@skylib.by", "admin", "admin", "Admin", "Adminovich", 1);
        addUser("moderator@skylib.by", "moderator", "moderator", "moderator", "moderatorovich", 2);
        addUser("user@skylib.by", "user", "user", "User", "Userovich", 3);
    }

    public static void addUser(String email, String username, String password,
                               String firstname, String secondname, Integer roleid){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/"+C_Init.DB+"",
                             "root",
                             "")) {
            String INSERT_USER = "insert into skylib.users(userid, email, username, password, regdate, firstname," +
                    " secondname, roleid) values(DEFAULT,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, password);
            preparedStatement.setTimestamp(4, getCurrentTimeStamp());
            preparedStatement.setString(5, firstname);
            preparedStatement.setString(6, secondname);
            preparedStatement.setInt(7, roleid);
            preparedStatement.executeUpdate();
            connection.close();
            System.out.println("Создание пользователя " + username + " выполнено");
        } catch (SQLException e) {
            if (e.toString().contains("Duplicate entry")){System.out.println("Пользователь " + username + " уже существует");}
            else System.out.println("При создании ролей возникла ошибка" + e.toString());
        }
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {
        return new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    }
}
