package by.it.lyukovich.jd_03_02;

import java.sql.*;

class UserCRUD {

    static boolean create(User user) throws SQLException {
        boolean result=true;
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "INSERT INTO users(userid, email, username, password, regdate, firstname," +
                    "secondname, roleid) VALUES (DEFAULT,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setTimestamp(4, user.getRegdate());
            preparedStatement.setString(5, user.getFirstname());
            preparedStatement.setString(6, user.getSecondname());
            preparedStatement.setInt(7, user.getRoleid());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                user.setUserid(id);
                result = true;
            } else result =  false;

        } catch (Exception e) {
            if (e.toString().contains("Duplicate entry")) {
                System.out.println("Пользователь " + user.getUsername() + " уже существует");
            } else System.out.println("При создании ролей возникла ошибка" + e.toString());
        }
    return result;
    }


    static User read(int userid) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "SELECT * FROM users WHERE userid=?";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, userid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("userid"),
                        resultSet.getString("email"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getTimestamp("regdate"),
                        resultSet.getString("firstname"),
                        resultSet.getString("secondname"),
                        resultSet.getInt("roleid")
                );
            }
        } catch (Exception e){
            if (e.toString().contains("NullPointerException")){
                System.out.println("Пользователя с id )" + userid + " не существует");
            } else System.out.println(e.toString());
        }
        return null;
    }

    static boolean update(User user) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();

        ) {
            String sql = "UPDATE users SET email = ?, username=?, password=?, regdate=?, firstname=?," +
                    " secondname=?, roleid=? WHERE userid =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setTimestamp(4, ConnectionCreator.getCurrentTimeStamp());
            preparedStatement.setString(5, user.getFirstname());
            preparedStatement.setString(6, user.getSecondname());
            preparedStatement.setInt(7, user.getRoleid());
            preparedStatement.setInt(8, user.getUserid());
            return (preparedStatement.execute());
        }
    }

    static boolean delete(User user) throws SQLException {

        try (Connection connection = ConnectionCreator.getConnection();

        ) {
            String sql = "DELETE FROM users WHERE userid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getUserid());
            return (preparedStatement.execute());
        }
    }


}
