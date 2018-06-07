package by.it.kirova.project.java.dao.daobeans;

import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserDAO extends AbstractDAO<User> {

    @Override
    public boolean create(User user) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `user`" +
                        "(`email`, `password`, `first_name`, `last_name`, `middle_name`, `residence_country`, " +
                        "`phone_number`, `role_role_id`) VALUES ('%s','%s','%s','%s','%s','%s','%s',%d)",
                user.getEmail(), user.getPassword(), user.getFirst_name(), user.getLast_name(), user.getMiddle_name(),
                user.getResidence_country(), user.getPhone_number(), user.getRole_role_id());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            user.setUser_id(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `user` SET " +
                        "`email`='%s',`password`='%s',`first_name`='%s',`last_name`='%s',`middle_name`='%s',`residence_country`='%s'," +
                        "`phone_number`='%s',`role_role_id`=%d  WHERE `user_id` = %d",
                user.getEmail(), user.getPassword(), user.getFirst_name(), user.getLast_name(), user.getMiddle_name(),
                user.getResidence_country(), user.getPhone_number(), user.getRole_role_id(), user.getUser_id());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.US,"DELETE FROM `user` WHERE `user_id` = %d", user.getUser_id());
        return executeUpdate(sql, false)==1;
    }

    @Override
    public User read(int user_id) throws SQLException {
        List<User> list=getAll("WHERE `user_id` =" + user_id);
        if (list.size()==1)
            return list.get(0);
        return null;
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US,"SELECT * FROM `user` " + where);
        List<User> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add( new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("middle_name"),
                        resultSet.getString("residence_country"),
                        resultSet.getString("phone_number"),
                        resultSet.getInt("role_role_id")
                ));
            }
        }
        return list;
    }
}
