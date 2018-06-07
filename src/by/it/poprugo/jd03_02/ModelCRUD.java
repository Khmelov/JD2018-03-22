package by.it.poprugo.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class ModelCRUD {
    static boolean create(Model model) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `models`" +
                        "(`model`, `name`, `address`, `phone`, `number`, " +
                        "`datacontr`, `price`, `keymoney`, `users_idus`) " +
                        "VALUES " +
                        "('%s','%s','%s','%s','%s','%s',%d,%d,%d)",
                model.getModel(), model.getName(), model.getAddress(), model.getPhone(), model.getNumber(),
                model.getDatacontr(), model.getPrice(), model.getKeymoney(), model.getUsers_idus());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    model.setId(id);
                }
            }
            return result;
        }
    }


    static boolean update(Model model) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `models` SET " +
                        "`model`='%s', `name`='%s',`address`=%s," +
                        "`phone`=%s,`number`=%s,`datacontr`=%s," +
                        "`price`=%d,`keymoney`='%d',`users_idus`=%d " +
                        "WHERE `id`=%d",
                model.getModel(), model.getName(), model.getAddress(),
                model.getPhone(), model.getNumber(), model.getDatacontr(),
                model.getPrice(), model.getKeymoney(), model.getUsers_idus(),
                model.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static boolean delete(Model model) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `models` WHERE `id`=%d", model.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    static Model read(int id) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `models` WHERE `id`=%d", id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Model(
                        resultSet.getInt("id"),
                        resultSet.getString("model"),
                        resultSet.getString("name"),
                        resultSet.getString("address"),
                        resultSet.getString("phone"),
                        resultSet.getString("number"),
                        resultSet.getString("datacontr"),
                        resultSet.getInt("price"),
                        resultSet.getInt("keymoney"),
                        resultSet.getInt("users_idus")
                );
            }
        }
        return null;
    }
}