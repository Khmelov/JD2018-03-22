package by.it.kirova.jd03_03.dao.daobeans;

import java.sql.SQLException;
import java.util.List;

public interface IDao<Type> {
    boolean create(Type bean) throws SQLException;
    boolean update(Type bean) throws SQLException;
    boolean delete(Type bean) throws SQLException;
    Type read(int id) throws SQLException;
    List<Type> getAll(String where) throws SQLException;
}
