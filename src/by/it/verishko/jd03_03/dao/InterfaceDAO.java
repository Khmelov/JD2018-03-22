package by.it.verishko.jd03_03.dao;

import java.util.List;

public interface InterfaceDAO<Type> {
    boolean create(Type bean) throws Exception;

    boolean update(Type bean) throws Exception;

    boolean delete(Type bean) throws Exception;

    Type read(int id) throws Exception;

    List<Type> getAll(String where) throws Exception;
}
