package by.it.uskoryaev.project.java.dao.daobeans;

import by.it.uskoryaev.project.java.beans.BaseFace;
import by.it.uskoryaev.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BaseFaceDAO extends AbstractDAO<BaseFace> {

    @Override
    public boolean create(BaseFace baseFace) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO 'base_face'(base_face) VALUE ('%s')", baseFace.getBaseFace());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            baseFace.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(BaseFace baseFace) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE 'base_face' SET 'base_face'='%s'" + "WHERE'id'=%d", baseFace.getBaseFace(), baseFace.getId());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public boolean delete(BaseFace baseFace) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `base_face` WHERE `id`=%d", baseFace.getId());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public BaseFace read(int id) throws SQLException {
        List<BaseFace> list = getAll("WHERE'id'=" + id);
        if (list.size() == 1)
            return list.get(0);
        return null;
    }

    @Override
    public List<BaseFace> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `base_face` " + where);
        List<BaseFace> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new BaseFace(
                        resultSet.getInt("id"),
                        resultSet.getString("base_face")
                ));
            }
        }
        return list;
    }
}
