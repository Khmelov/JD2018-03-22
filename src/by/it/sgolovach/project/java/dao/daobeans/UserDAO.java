package by.it.sgolovach.project.java.dao.daobeans;

import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.connect.ConnectionCreator;
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
        String sql = String.format(Locale.US,"INSERT INTO `users`(`login`, `email`, `password`, `roles_id`)" +
                " VALUES ('%s','%s','%s',%d)", user.getLogin(), user.getEmail(), user.getPassword(), user.getRoles_id());
        int id=executeUpdate(sql,true);
        if (id > 0) {
            user.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String sql=String.format(Locale.US,"UPDATE " +
                "`users` SET `login`='%s',`email`='%s'," +
                "`password`='%s',`roles_id`=%d" +
                " WHERE `id`=%d",user.getLogin(),user.getEmail(),user.getPassword(),user.getRoles_id(),user.getId());
        return executeUpdate(sql,false)==1;
    }

    @Override
    public boolean delete(User user) throws SQLException {
        String sql=String.format(Locale.US,"DELETE FROM `users` WHERE `id`=%d",user.getId());
        return executeUpdate(sql,false)==1;
    }

    @Override
    public User read(int id) throws SQLException {
        String sql=String.format(Locale.US,"SELECT * FROM `users` WHERE `id`=%d",id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet=statement.executeQuery(sql);
            if(resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("roles_id")
                );
            }

        }
        return null;
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `users` "+where);
        List<User> list =new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add( new User(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("roles_id")
                ));
            }
        }
        return list;
    }
}
