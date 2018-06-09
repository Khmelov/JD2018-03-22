package by.it.verishko.project.java.dao.daobeans;

import by.it.verishko.project.java.beans.Product;
import by.it.verishko.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductDAO extends AbstractDAO<Product> {

    @Override
    public boolean create(Product product) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `goods`" +
                        "(`name`,`description`,`price`,`users_id`) " +
                        "VALUES " +
                        "('%s','%s',%f,%d)",
                product.getName(), product.getDescription(), product.getPrice(), product.getUsers_id());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            product.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `goods` SET " +
                        "`name`='%s',`description`='%s',`price`=%f,`users_id`=%d WHERE `id`=%d",
                product.getName(), product.getDescription(), product.getPrice(), product.getUsers_id(), product.getId());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public boolean delete(Product product) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `goods` WHERE `id`=%d", product.getId());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public Product read(int id) throws SQLException {
        List<Product> list = getAll("WHERE `id`=" + id);
        if (list.size() == 1)
            return list.get(0);
        return null;
    }

    @Override
    public List<Product> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `goods` " + where);
        List<Product> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("users_id")
                ));
            }
        }
        return list;
    }
}