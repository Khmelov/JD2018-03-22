package by.it.sgolovach.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

    boolean creatUser(User user) throws SQLException {
        String sql = String.format("INSERT INTO `users`(`login`, `email`, `password`, `roles_id`)" +
                " VALUES ('%s','%s','%s',%d)", user.getLogin(), user.getEmail(), user.getPassword(), user.getId());
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


    boolean updateUser(User user) throws SQLException {
        String sql=String.format("UPDATE " +
                "`users` SET `login`='%s',`email`='%s'," +
                "`password`='%s',`roles_id`=%d" +
                " WHERE `id`=%d",user.getLogin(),user.getEmail(),user.getPassword(),user.getRoles_id(),user.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    boolean deleteUser(User user) throws SQLException {
        String sql=String.format("DELETE FROM `users` WHERE `id`=%d",user.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    User readUser(int id) throws SQLException {
        String sql=String.format("SELECT * FROM `users` WHERE `id`=%d",id);
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
