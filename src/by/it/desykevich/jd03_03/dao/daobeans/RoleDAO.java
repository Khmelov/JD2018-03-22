package by.it.desykevich.jd03_03.dao.daobeans;


import by.it.desykevich.jd03_03.beans.Role;
import by.it.desykevich.jd03_03.dao.UniversalDAO;
import by.it.desykevich.jd03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

//public class RoleDAO extends UniversalDAO<Role> {
//
//    public RoleDAO() {
//        super(new Role(), "users");
//    }
//}

public class RoleDAO extends AbstractDAO<Role> {

    @Override
    public boolean create(Role bean) throws SQLException {
        throw new SQLException("Not implements");
    }

    @Override
    public boolean update(Role bean) throws SQLException {
        throw new SQLException("Not implements");
    }

    @Override
    public boolean delete(Role bean) throws SQLException {
        throw new SQLException("Not implements");
    }

    @Override
    public Role read(int id) throws SQLException {
        List<Role> list = getAll(" where ID=" + id);
        return list.size() > 0 ? list.get(0) : null;
    }

    @Override
    public List<Role> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `roles` " + where);
        List<Role> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Role(
                        resultSet.getInt("id"),
                        resultSet.getString("role")
                ));
            }
        }
        return list;
    }
//    public List<Role> getAll(String where) throws SQLException {
//        List<Role> list = new ArrayList<>();
//        Connection connection = ConnectionCreator.getConnection();
//        Statement statement = connection.createStatement();
//        String sql = "SELECT * from roles " + where + ";";
//        ResultSet rs = statement.executeQuery(sql);
//        while (rs.next()) {
//            Role role = new Role(rs.getInt("ID"), rs.getString("Role"));
//            list.add(role);
//        }
//        return list;
//    }

}
