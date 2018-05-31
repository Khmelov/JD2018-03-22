package by.it.desykevich.jd03_03.dao.daobeans;


import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

public class RoleDAO extends AbstractDAO<Role> {


    @Override
    public boolean create(Role bean) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Role bean) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Role bean) throws SQLException {
        return false;
    }

    @Override
    public Role read(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        return null;
    }
}
