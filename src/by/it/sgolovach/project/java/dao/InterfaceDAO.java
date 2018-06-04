package by.it.sgolovach.project.java.dao;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<Type>{
    boolean create(Type bean) throws SQLException;
    boolean update(Type bean)throws SQLException;
    boolean delete(Type bean)throws SQLException;
    Type read(int id)throws SQLException;
    List<Type> getAll(String where)throws SQLException;
}
