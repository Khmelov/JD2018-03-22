package by.it.desykevich.project.java.dao.daobeans;

import by.it.desykevich.project.java.beans.Ad;
import by.it.desykevich.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdDAO extends AbstractDAO<Ad> {

    @Override
    public boolean create(Ad ad) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String insert = String.format("INSERT INTO `ads` (`Title`,  `Description`, `Price`, `users_ID`, `category_ID`) " +
                            "VALUES ('%s',  '%s', '%d', '%d', '%d');",
                    ad.getTitle(), ad.getDescription(),
                    ad.getPrice(), ad.getUsers_Id(), ad.getCategory_Id());
            int recCount = statement.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            if (recCount == 1) {
                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    int ID = keys.getInt(1);
                    ad.setId(ID);
                }
            }
            return recCount == 1;
        }
    }

    @Override
    public boolean update(Ad ad) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String set = String.format("UPDATE `ads` SET title='%s', description='%s', price='%d'," +
                            "users_id='%d', category_id='%d' WHERE id='%d';",
                    ad.getTitle(),  ad.getDescription(),
                    ad.getPrice(), ad.getUsers_Id(), ad.getCategory_Id(),ad.getId());
            int recCount = statement.executeUpdate(set);
            return recCount == 1;
        }
    }

    @Override
    public Ad read(int ID) throws SQLException {
        List<Ad> list = getAll(" where ID=" + ID);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public boolean delete(Ad ad) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            String query = String.format("DELETE FROM ads WHERE ID=%d;", ad.getId());
            int recCount = statement.executeUpdate(query);
            return recCount == 1;
        }
    }

    @Override
    public List<Ad> getAll(String where) throws SQLException {
        List<Ad> list = new ArrayList<>();
        Connection connection = ConnectionCreator.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * from ads " + where + ";";
        ResultSet rs = statement.executeQuery(sql);
        while (rs.next()) {
            Ad ad = new Ad(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getInt("price"),
                    rs.getInt("users_id"),
                    rs.getInt("category_id"));
            list.add(ad);
        }
        return list;
    }
}
