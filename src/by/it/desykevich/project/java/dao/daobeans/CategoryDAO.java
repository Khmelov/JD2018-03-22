package by.it.desykevich.project.java.dao.daobeans;

import by.it.desykevich.project.java.beans.Category;
import by.it.desykevich.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<Category>{

    @Override
    public boolean create(Category category) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String insert = String.format("INSERT INTO `category` (`name`) VALUES ('%s');",
                    category.getName());
            int recCount = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int ID = keys.getInt(1);
                    category.setId(ID);
                }
            }
            return recCount == 1;
        }
    }

    @Override
    public boolean update(Category category) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String set = String.format("UPDATE `category` SET Name='%s' WHERE category.ID='%d';",
                    category.getName(),category.getId());
            int recCount = statement.executeUpdate(set);
            return recCount == 1;
        }
    }

    @Override
    public Category read(int ID) throws SQLException {
        List<Category> list = getAll(" where ID=" + ID);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public boolean delete(Category category) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ){
            String query = String.format("DELETE FROM category WHERE ID=%d;", category.getId());
            int recCount = statement.executeUpdate(query);
            return recCount == 1;
        }
    }

    @Override
    public List<Category> getAll(String where) throws SQLException {
        List<Category> list = new ArrayList<>();
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * from category " + where + ";";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Category category = new Category(
                    rs.getInt("id"),
                    rs.getString("name"));
            list.add(category);
        }
        return list;
    }
}
