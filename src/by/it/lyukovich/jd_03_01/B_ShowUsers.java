package by.it.lyukovich.jd_03_01;

import java.sql.*;

public class B_ShowUsers {
    public static void main(String[] args) {
        try (Connection connection =
                     DriverManager.getConnection(
                             "jdbc:mysql://127.0.0.1:2016/"+C_Init.DB+"",
                             "root",
                             "")) {
            if(!connection.isClosed()) System.out.println("Соединение с базой открыто");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()){
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Timestamp regdate = resultSet.getTimestamp("regdate");
                String firstname = resultSet.getString("firstname");
                String secondname = resultSet.getString("secondname");
                Integer roleid = resultSet.getInt("roleid");
                Statement rsconn = connection.createStatement();
                ResultSet res = rsconn.executeQuery("SELECT `rolename` FROM `roles` WHERE roleid = "+roleid+"");
                String rolename="";
                if (res.next()){
                    rolename = res.getString(1);
                }
                String result="Username: " + username +", email: " + email + ", Password: " + password + "Registration date: "+
                        regdate.toString() + ", First name: " + firstname + ", Second name: " + secondname + ", Role: " + rolename;
                System.out.println(result);
            }
            connection.close();
            if(connection.isClosed()) System.out.println("Соединение с базой закрыто");

        } catch (SQLException e) {
            System.out.println("При создании пользователя возникла ошибка" + e.toString());
        }

    }
}
