package by.it.lyukovich.jd_03_03.dao.daobeans;

import by.it.lyukovich.jd_03_03.beans.Author;
import by.it.lyukovich.jd_03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AuthorDAO extends AbstractDAO<Author> {
    @Override
    public boolean create(Author author) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO authors(authorname) VALUES ('%s')",
                author.getAuthorname());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            author.setAuthorid(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Author author) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE authors SET authorname='%s' " +
                "WHERE authorid=%d", author.getAuthorname(), author.getAuthorid());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public boolean delete(Author author) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM authors WHERE authorid=%d", author.getAuthorid());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public Author read(int id) throws SQLException {
        List<Author> list=getAll("WHERE authorid="+id);
        if (list.size()==1)
            return list.get(0);
        return null;
    }

    @Override
    public List<Author> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM authors " + where);
        List<Author> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Author(
                        resultSet.getInt("authorid"),
                        resultSet.getString("authorname")
                ));
            }
        }
        return list;
    }
}
