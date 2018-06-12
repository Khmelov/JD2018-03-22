package by.it.poprugo.jd03_03.dao.daobeans;

import by.it.poprugo.jd03_03.beans.Role;
import by.it.poprugo.jd03_03.dao.UniversalDAO;
import by.it.poprugo.jd03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// было public class RoleDAO extends UniversalDAO<Role> {

/* было public RoleDAO() {
        super(new Role(), "roles"); // sqlTableName = "users"
    }*/

public class RoleDAO extends AbstractDAO<Role> {
    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `roles`(`role`) VALUES ('%s')", role.getRole());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            role.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `roles` SET `role`='%s' " +
                "WHERE `id`=%d", role.getRole(), role.getId());

        return false;
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        /*String sql = String.format(Locale.US, "DELETE FROM `roles` WHERE `id`=%d", role.getId());
        return executeUpdate(sql, true); //???*/
        return true;
    }

    @Override
    public Role read(int id) throws SQLException {
        List<Role> list = getAll("WHERE `id`=" + id);
        if (list.size() == 1)
            return list.get(0);
        return null;
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        /*String sql = String.format(Locale.US, "SELECT * FROM `roles` " + where);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Role> list = new ArrayList<>();
            if (resultSet.next()) {
                list.add(new Role(
                        resultSet.getInt("id"),
                        resultSet.getString("role"))
                );
            }
        }
        return list;*/
        return null;
    }


}
