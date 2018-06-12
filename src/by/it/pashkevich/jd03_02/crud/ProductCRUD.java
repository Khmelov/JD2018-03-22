package by.it.pashkevich.jd03_02.crud;

import by.it.pashkevich.jd03_02.ConnectionCreator;
import by.it.pashkevich.jd03_02.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class ProductCRUD {

    public static boolean create(Product product) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `goods`" +
                        "(`name`,`description`,`price`,`users_id`) " +
                        "VALUES " +
                        "('%s','%s',%f,%d)",
                product.getName(), product.getDescription(), product.getPrice(), product.getUsers_id());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    product.setId(id);
                }
            }
            return result;
        }
    }

    public static boolean update(Product product) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `goods` SET " +
                        "`name`='%s',`description`='%s',`price`=%f,`users_id`=%d WHERE `id`=%d",
                product.getName(), product.getDescription(), product.getPrice(), product.getUsers_id(),product.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public static boolean delete(Product product) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `goods` WHERE `id`=%d", product.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public static Product read(int id) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `goods` WHERE `id`=%d", id);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("users_id")
                );
            }
        }
        return null;
    }
}
