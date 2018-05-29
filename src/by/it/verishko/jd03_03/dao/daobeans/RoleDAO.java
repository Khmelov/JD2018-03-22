package by.it.verishko.jd03_03.dao.daobeans;

import by.it.verishko.jd03_03.beans.Role;
import by.it.verishko.jd03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.Locale;

public class RoleDAO extends AbstractDAO<Role> {

    @Override
    public boolean create(Role role) throws Exception {
        String sql = String.format(Locale.US, "INSERT INTO `roles`(`role`) VALUES ('%s')",
                role.getRole());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            role.setId();
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Role role) throws Exception {
        String sql = String.format(Locale.US, "UPDATE `roles` SET `role`='%s' " +
                "WHERE `id`=%d", role.getRole(), role.getId());
//        return (1 == statement.executeUpdate(sql, false));
        return false;
    }

    @Override
    public boolean delete(Role role) throws Exception {
        return false;
    }

    @Override
    public Role read(int id) throws Exception {
        return null;
    }

    @Override
    public List<Role> getAll(String where) throws Exception {
        return null;
    }
}
