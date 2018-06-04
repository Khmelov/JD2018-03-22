package by.it.desykevich.project.java.dao.daobeans;


import by.it.desykevich.project.java.beans.User;
import by.it.desykevich.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDAO extends AbstractDAO<User> {

    @Override
    public boolean create(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String insert = String.format("INSERT INTO `users` (`login`, `password`, `email`, `nickname`, `phonenumber`, `roles_id`) " +
                            "VALUES ('%s', '%s', '%s', '%s', '%s', '%d');",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getNickname(), user.getPhoneNumber(), user.getRoles_id());
            int recCount = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int ID = keys.getInt(1);
                    user.setID(ID);
                }
            }
            return recCount == 1;
        }
    }

    @Override
    public User read(int ID) throws SQLException {
        List<User> list = getAll(" where ID=" + ID);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public boolean update(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String set = String.format("UPDATE `users` SET login='%s', password='%s', email='%s', nickname='%s'," +
                            "phonenumber='%s', roles_id='%d' WHERE id='%d';",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getNickname(),
                    user.getPhoneNumber(), user.getRoles_id(), user.getID());
            int recCount = statement.executeUpdate(set);
            return recCount == 1;
        }
    }

    @Override
    public boolean delete(User user) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String query = String.format("DELETE FROM users WHERE id=%d;", user.getID());
            int recCount = statement.executeUpdate(query);
            return recCount == 1;
        }
    }

    @Override
    public List<User> getAll(String where) throws SQLException {
        List<User> list = new ArrayList<>();
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * from users " + where + ";";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("nickname"),
                    rs.getString("phonenumber"),
                    rs.getInt("roles_id")
            );
            list.add(user);
        }
        return list;
    }
}