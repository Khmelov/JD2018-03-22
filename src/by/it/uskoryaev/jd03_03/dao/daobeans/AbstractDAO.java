package by.it.uskoryaev.jd03_03.dao.daobeans;

import by.it.uskoryaev.jd03_03.dao.InterfaceDAO;
import by.it.uskoryaev.jd03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class AbstractDAO<Type> implements InterfaceDAO<Type> {

    int executeUpdate(String sql, boolean generateId) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            int result = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (result > 0 && generateId) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    return id;
                }
            }
            return result;
        }
    }
}
