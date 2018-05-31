package by.it.sgolovach.jd03_02.crud;

import by.it.sgolovach.jd03_02.ConnectionCreator;
import by.it.sgolovach.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class UsersCRUD {

    public static boolean create(User user) throws SQLException {
        String sql = String.format(Locale.US,"INSERT INTO `users`(`login`, `email`, `password`, `roles_id`)" +
                " VALUES ('%s','%s','%s',%d)", user.getLogin(), user.getEmail(), user.getPassword(), user.getRoles_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    user.setId(id);
                }
            }
            return result;
        }
    }


   public static boolean update(User user) throws SQLException {
        String sql=String.format(Locale.US,"UPDATE " +
                "`users` SET `login`='%s',`email`='%s'," +
                "`password`='%s',`roles_id`=%d" +
                " WHERE `id`=%d",user.getLogin(),user.getEmail(),user.getPassword(),user.getRoles_id(),user.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

   public static boolean delete(User user) throws SQLException {
        String sql=String.format(Locale.US,"DELETE FROM `users` WHERE `id`=%d",user.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public static User read(int id) throws SQLException {
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


}
