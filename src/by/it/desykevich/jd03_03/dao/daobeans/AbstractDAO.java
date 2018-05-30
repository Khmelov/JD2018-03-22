package by.it.desykevich.jd03_03.dao.daobeans;

import by.it.desykevich.jd03_03.dao.InterfaceDao;

import java.sql.SQLException;

abstract class AbstractDAO<Type>  implements InterfaceDao<Type>{

    int executeUpdate (String sql,boolean generateID)throws SQLException{

    }
}
