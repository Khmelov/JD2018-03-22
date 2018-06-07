package by.it.kirova.project.java.dao.daobeans;

import by.it.kirova.project.java.beans.Role;
import by.it.kirova.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class RoleDAO extends AbstractDAO<Role> {

    @Override
    public boolean create(Role role) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `role` (`role_name`) VALUES ('%s')",
                role.getRole_name());
        int id = executeUpdate(sql, true);
        if (id>0) {
            role.setRole_id(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Role role) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `role` SET `role_name`='%s' WHERE `role_id` = %d",
                role.getRole_name(), role.getRole_id());
        return executeUpdate(sql, false)==1;
    }

    @Override
    public boolean delete(Role role) throws SQLException {
        String sql = String.format(Locale.US,"DELETE FROM `role` WHERE `role_id` = %d", role.getRole_id());
        return executeUpdate(sql, false)==1;
    }

    @Override
    public Role read(int role_id) throws SQLException {
        List<Role> list=getAll("WHERE `role_id`="+role_id);
        if (list.size()==1)
            return list.get(0);
        return null;
//        String sql = String.format(Locale.US,"SELECT * FROM `role` WHERE `role_id` = %d", role_id);
//        try (Connection connection = ConnectionCreator.getConnection();
//             Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(sql);
//            if (resultSet.next()) {
//                return new Role(
//                        resultSet.getInt("role_id"),
//                        resultSet.getString("role_name")
//                );
//            }
//        }
//        return null;
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US,"SELECT * FROM `role` " + where);
        List<Role> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add( new Role(
                        resultSet.getInt("role_id"),
                        resultSet.getString("role_name")
                ));
            }
        }
        return list;
    }
}
