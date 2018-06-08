package by.it.lyukovich.jd_03_02;

import java.sql.*;

public class TaskB {
    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            if(!connection.isClosed()) System.out.println("Соединение с базой открыто");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users \n" +
                    "INNER JOIN roles ON users.roleid = roles.roleid");
            int usercount=0, rolecount=0;
            String roles="";

            while (resultSet.next()){
                String email = resultSet.getString("email");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                Timestamp regdate = resultSet.getTimestamp("regdate");
                String firstname = resultSet.getString("firstname");
                String secondname = resultSet.getString("secondname");
                String rolename = resultSet.getString("rolename");
                if (!roles.contains(rolename)){rolecount++; roles+=rolename+"/";}
                /*Integer roleid = resultSet.getInt("roleid");
                Statement rsconn = connection.createStatement();
                ResultSet res = rsconn.executeQuery("SELECT `rolename` FROM `roles` WHERE roleid = "+roleid+"");
                String rolename="";
                if (res.next()){
                    rolename = res.getString(1);
                }*/
                usercount++;
                String result="Username: " + username +", email: " + email + ", Password: " + password + "Registration date: "+
                        regdate.toString() + ", First name: " + firstname + ", Second name: " + secondname + ", Role: " + rolename;
                System.out.println(result);
            }
            connection.close();
            if(connection.isClosed()) System.out.println("Соединение с базой закрыто");
            System.out.println("Пользователей - " + usercount + ". Ролей - " + rolecount);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
