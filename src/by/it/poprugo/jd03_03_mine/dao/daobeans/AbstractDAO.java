package by.it.poprugo.jd03_03_mine.dao.daobeans;

import by.it.poprugo.jd03_03_mine.dao.InterfaceDAO;
import by.it.poprugo.jd03_03_mine.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class AbstractDAO<Type> implements InterfaceDAO<Type> {

    int executeUpdate(String sql, boolean generateId) throws SQLException {
        //возвращаемый тип НЕ boolean, а int
        // скопировали из RoleCRUD of jd03_02
        //String sql = String.format(Locale.US, "INSERT INTO `roles`(`role`) VALUES ('%s')",
        //        role.getRole()); - эта string придёт в параметр из ROleDAO
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
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
