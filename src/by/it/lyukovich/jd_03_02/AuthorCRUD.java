package by.it.lyukovich.jd_03_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthorCRUD {
    static boolean create(Author author) throws SQLException {
        boolean result;
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "INSERT INTO authors(authorid, authorname) VALUES (DEFAULT,?)";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, author.getAuthorname());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                author.setAuthorid(id);
                result = true;
            } else result =  false;
        }
        return result;
    }


    static boolean update(Author author) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "UPDATE authors SET authorname=? WHERE authorid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, author.getAuthorname());
            preparedStatement.setInt(2, author.getAuthorid());
            return (preparedStatement.execute());
        }
    }

    static boolean delete(Author author) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection()
        ) {
            String sql = "DELETE FROM authors WHERE authorid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, author.getAuthorid());
            return (preparedStatement.execute());
        }
    }

    static Author read(int authorid) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "SELECT * FROM authors WHERE authorid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, authorid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Author(
                        resultSet.getInt("authorid"),
                        resultSet.getString("authorname")
                );
            }
        }
        return null;
    }
}
