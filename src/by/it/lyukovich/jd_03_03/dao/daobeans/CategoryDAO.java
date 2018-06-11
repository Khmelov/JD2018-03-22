package by.it.lyukovich.jd_03_03.dao.daobeans;

import by.it.lyukovich.jd_03_03.beans.Category;
import by.it.lyukovich.jd_03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoryDAO extends AbstractDAO<Category> {
    @Override
    public boolean create(Category category) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO category(categorysubid, categoryname," +
                        " categorydescription) VALUES ('%d','%s','%s')",category.getCategorysubid(),
                category.getCategoryname(), category.getCategorydescription());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            category.setCategoryid(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE category SET categorysubid='%d', categoryname='%s', " +
                "categorydescription='%s' WHERE categoryid=%d", category.getCategorysubid(), category.getCategoryname(),
                category.getCategorydescription(), category.getCategoryid());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public boolean delete(Category category) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM category WHERE categoryid=%d", category.getCategoryid());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public Category read(int id) throws SQLException {
        List<Category> list=getAll("WHERE categoryid="+id);
        if (list.size()==1)
            return list.get(0);
        return null;
    }

    @Override
    public List<Category> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM category " + where);
        List<Category> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Category(
                        resultSet.getInt("categoryid"),
                        resultSet.getInt("categorysubid"),
                        resultSet.getString("categoryname"),
                        resultSet.getString("categorydescription")
                ));
            }
        }
        return list;
    }
}
