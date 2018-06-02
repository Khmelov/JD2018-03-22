package by.it.poprugo.jd03_03_mine.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO <Type>{ //типизированный интерфейс
    boolean create(Type bean) throws SQLException;
    boolean update(Type bean) throws SQLException;
    boolean delete(Type bean) throws SQLException;
    Type read(int id) throws SQLException;
    List<Type> getAll(String where) throws SQLException;
}
