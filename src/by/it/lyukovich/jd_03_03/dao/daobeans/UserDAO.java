package by.it.lyukovich.jd_03_03.dao.daobeans;

import by.it.lyukovich.jd_03_03.beans.User;
import by.it.lyukovich.jd_03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserDAO extends AbstractDAO<User>{


    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO users(userid, email, username, password, regdate," +
                        "firstname, secondname, roleid) VALUES (DEFAULT,'%s','%s','%s','%d','%s','%s','%d')",
                user.getEmail(), user.getUsername(), user.getPassword(), user.getRegdate(), user.getFirstname(),
        user.getSecondname(), user.getRoleid());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            user.setUserid(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE users SET email = '%s', username='%s', password='%s', " +
                "regdate='%d', firstname='%s', secondname='%s', roleid='%d' WHERE userid ='%d'", user.getEmail(),
                user.getUsername(), user.getPassword(), user.getRegdate(), user.getFirstname(), user.getSecondname(),
                user.getRoleid(), user.getUserid());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM users WHERE userid='%d'", user.getUserid());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public User read(int id) throws SQLException {
        List<User> list=getAll("WHERE userid="+id);
        if (list.size()==1)
            return list.get(0);
        return null;
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM users " + where);
        List<User> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new User(
                        resultSet.getInt("userid"),
                        resultSet.getString("email"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getLong("regdate"),
                        resultSet.getString("firstname"),
                        resultSet.getString("secondname"),
                        resultSet.getInt("roleid")
                ));
            }
        }
        return list;
    }
}
