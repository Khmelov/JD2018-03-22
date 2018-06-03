package by.it.danilevich.jd03_03.dao.daobeans;

import by.it.danilevich.jd03_03.dao.InterfaceDao;
import by.it.danilevich.jd03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public abstract class AbstractDao<Type> implements InterfaceDao<Type> {

    int executeUpdate(String sql, boolean generatedID) throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            int result = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if ((result>0)&&generatedID) {
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
