package by.it.lyukovich.jd_03_03.dao.daobeans;

import by.it.lyukovich.jd_03_03.beans.Book;
import by.it.lyukovich.jd_03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BookDAO extends AbstractDAO<Book> {
    @Override
    public boolean create(Book book) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO books(bookid, categoryid, bookdateadded, bookname, booklang," +
                        "bookauthors, bookcountry, bookdescription, bookformat, bookfilename, bookimgname, " +
                        "uploadedbyuser) VALUES (DEFAULT,'%d','%d','%s','%s','%s','%s','%s','%s','%s','%s','%d')",
                book.getCategoryid(), book.getBookdateadded(), book.getBookname(), book.getBooklang(),
                book.getBookauthors(), book.getBookcountry(), book.getBookdescription(), book.getBookformat(),
                book.getBookfilename(), book.getBookimgname(), book.getUploadedbyuser());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            book.setBookid(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE books SET categoryid='%d', bookdateadded='%d', bookname='%s'," +
                        " booklang='%s', bookauthors='%s', bookcountry='%s', bookdescription='%s', bookformat='%s'," +
                        " bookfilename='%s', bookimgname='%s', uploadedbyuser='%d' WHERE bookid='%d'",
                book.getCategoryid(), book.getBookdateadded(), book.getBookname(), book.getBooklang(),
                book.getBookauthors(), book.getBookcountry(), book.getBookdescription(), book.getBookformat(),
                book.getBookfilename(), book.getBookimgname(), book.getUploadedbyuser(), book.getBookid());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public boolean delete(Book book) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM books WHERE bookid='%d'", book.getBookid());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public Book read(int id) throws SQLException {
        List<Book> list=getAll("WHERE bookid="+id);
        if (list.size()==1)
            return list.get(0);
        return null;
    }

    @Override
    public List<Book> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM books " + where);
        List<Book> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Book(
                        resultSet.getInt("bookid"),
                        resultSet.getInt("categoryid"),
                        resultSet.getLong("bookdateadded"),
                        resultSet.getString("bookname"),
                        resultSet.getString("booklang"),
                        resultSet.getString("bookauthors"),
                        resultSet.getString("bookcountry"),
                        resultSet.getString("bookdescription"),
                        resultSet.getString("bookformat"),
                        resultSet.getString("bookfilename"),
                        resultSet.getString("bookimgname"),
                        resultSet.getInt("uploadedbyuser")
                ));
            }
        }
        return list;
    }
}
