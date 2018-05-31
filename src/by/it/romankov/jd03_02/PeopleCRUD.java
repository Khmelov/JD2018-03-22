package by.it.romankov.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class PeopleCRUD {

    static boolean create(People people) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `people`(`name`,`email`,`telephone`,`age`, `roles_id`)"+
                "VALUES ('%s','%s','%s',%d,%d)",
                people.getName(), people.getEmail(), people.getTelephone(),people.getAge(),people.getRoles_id());

        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    people.setId(id);

                }
            }
            return result;
        }
    }

    static boolean update(People people) throws SQLException {
        String sql = String.format(Locale.US,
                "UPDATE `people` SET `name`='%s',`email`='%s',`telephone`='%s'," +
                        "`age`=%d,`roles_id`=%d  WHERE `id`=%d",
                people.getName(),people.getEmail(),people.getTelephone(),
                people.getAge(), people.getRoles_id(),people.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
    static boolean delete(People people) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `people` WHERE `id`=%d", people.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static People read(int id) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `people` WHERE `id`=%d", id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new People(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("telephone"),
                        resultSet.getInt("age"),
                        resultSet.getInt("roles_id")
                );
            }
        }
        return null;
    }

}
