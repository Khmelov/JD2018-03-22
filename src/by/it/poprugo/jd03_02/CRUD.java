package by.it.poprugo.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

    // добавили static, чтобы легче было обращаться (для проверки) Runner'ом
    static boolean createUser(User user) throws SQLException {

        String sql = String.format("INSERT INTO " +
                "`users`(`login`, `email`, `password`, `roles_id`) " +
                // из
                // "`users`(`id`, `login`, `email`, `password`, `roles_id`) " +
                // "VALUES ([value-1],[value-2],[value-3],[value-4],[value-5])"); сделали формат.
                //"VALUES (%d,'%s','%s','%s',%d)"); - уберём id, т.к. оно AI
                "VALUES ('%s','%s','%s',%d)",
                user.getLogin(), user.getEmail(), user.getPassword(), user.getRoles_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generateKeys = statement.getGeneratedKeys();
                if (generateKeys.next()) {
                    int id = generateKeys.getInt(1);
                    user.setId(id);
                }
            }
            return result;
        }
    }

    /*static boolean updateUser(User user) throws SQLException {
        String sql = String.format(("UPDATE " +
                "`users` SET `login`='%s',`email`='%s'," +
                "`password`='%s',`roles_id`=%d " +
                "WHERE `id`=%d", user.getLogin(), user.getEmail(), user.getPassword(), user.getRoles_id(), user.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static boolean deleteUser(User user) throws SQLException {
        String sql = String.format(("DELETE FROM `users` WHERE 'id'=%d", user.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static User readUser(int id) throws SQLException {
        String sql = String.format(("SELECT * FROM `users` WHERE 'id'=%d", id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.excecuteQuery(sql);
            return (1 == statement.executeUpdate(sql));
        }
    }*/
}
