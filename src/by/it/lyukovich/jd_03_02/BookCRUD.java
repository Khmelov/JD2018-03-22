package by.it.lyukovich.jd_03_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookCRUD {
    static boolean create(Book book) throws SQLException {
        boolean result;
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "INSERT INTO books(bookid, categoryid, bookdateadded, bookname, booklang, " +
                    "bookauthors, bookcountry, bookdescription, bookformat, bookfilename, bookimgname, uploadedbyuser)" +
                    " VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = null;
            preparedStatement = connection.prepareStatement(sql, preparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, book.getCategoryid());
            preparedStatement.setTimestamp(2, book.getBookdateadded());
            preparedStatement.setString(3, book.getBookname());
            preparedStatement.setString(4, book.getBooklang());
            preparedStatement.setString(5, book.getBookauthors());
            preparedStatement.setString(6, book.getBookcountry());
            preparedStatement.setString(7, book.getBookdescription());
            preparedStatement.setString(8, book.getBookformat());
            preparedStatement.setString(9, book.getBookfilename());
            preparedStatement.setString(10, book.getBookimgname());
            preparedStatement.setInt(11, book.getUploadedbyuser());
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                book.setBookid(id);
                result = true;
            } else result =  false;
        }
        return result;
    }


    static boolean update(Book book) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "UPDATE books SET categoryid=?, bookdateadded=?, bookname=?, booklang=?, bookauthors=?," +
                    "bookcountry=?, bookdescription=?, bookformat=?, bookfilename=?, bookimgname=?, uploadedbyuser=?" +
                    " WHERE bookid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getCategoryid());
            preparedStatement.setTimestamp(2, book.getBookdateadded());
            preparedStatement.setString(3, book.getBookname());
            preparedStatement.setString(4, book.getBooklang());
            preparedStatement.setString(5, book.getBookauthors());
            preparedStatement.setString(6, book.getBookcountry());
            preparedStatement.setString(7, book.getBookdescription());
            preparedStatement.setString(8, book.getBookformat());
            preparedStatement.setString(9, book.getBookfilename());
            preparedStatement.setString(10, book.getBookimgname());
            preparedStatement.setInt(11, book.getUploadedbyuser());
            preparedStatement.setInt(12, book.getBookid());
            return (preparedStatement.execute());
        }
    }

    static boolean delete(Book book) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection()
        ) {
            String sql = "DELETE FROM books WHERE bookid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getBookid());
            return (preparedStatement.execute());
        }
    }

    static Book read(int bookid) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
        ) {
            String sql = "SELECT * FROM books WHERE bookid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bookid);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return new Book(
                        resultSet.getInt("bookid"),
                        resultSet.getInt("categoryid"),
                        resultSet.getTimestamp("bookdateadded"),
                        resultSet.getString("bookname"),
                        resultSet.getString("booklang"),
                        resultSet.getString("bookauthors"),
                        resultSet.getString("bookcountry"),
                        resultSet.getString("bookdescription"),
                        resultSet.getString("bookformat"),
                        resultSet.getString("bookfilename"),
                        resultSet.getString("bookimgname"),
                        resultSet.getInt("uploadedbyuser")
                );
            }
        }
        return null;
    }
}
