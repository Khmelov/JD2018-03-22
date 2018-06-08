package by.it.lyukovich.jd_03_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryCRUD {
    static boolean create(Category category) throws SQLException {
        boolean result;
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "INSERT INTO category(categoryid, categorysubid, categoryname, categorydescription) " +
                    "VALUES (DEFAULT,?,?,?)";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, category.getCategoryname());
            preparedStatement.setString(3, category.getCategorydescription());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                category.setCategoryid(id);
                result = true;
            } else result =  false;
        }
        return result;
    }


    static boolean update(Category category) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "UPDATE category SET categorysubid=?, categoryname=?, categorydescription=? WHERE categoryid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category.getCategorysubid());
            preparedStatement.setString(2, category.getCategoryname());
            preparedStatement.setString(3, category.getCategorydescription());
            preparedStatement.setInt(4, category.getCategoryid());
            return (preparedStatement.execute());
        }
    }

    static boolean delete(Category category) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection()
        ) {
            String sql = "DELETE FROM category WHERE categoryid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, category.getCategoryid());
            return (preparedStatement.execute());
        }
    }

    static Category read(int categoryid) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "SELECT * FROM category WHERE categoryid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, categoryid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Category(
                        resultSet.getInt("categoryid"),
                        resultSet.getInt("categorysubid"),
                        resultSet.getString("categoryname"),
                        resultSet.getString("categorydescription")
                );
            }
        }
        return null;
    }
}
