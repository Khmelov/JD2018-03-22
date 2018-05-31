package by.it.romankov.jd03_03.dao.daobeans;
import by.it.romankov.jd03_03.beans.Roles;
import by.it.romankov.jd03_03.dao.connect.ConnectionCreator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RolesDAO extends AbstactDAO<Roles> {
    @Override
    public boolean create(Roles role) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `roles`(`role`) VALUES ('%s')",
                role.getRole());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            role.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Roles role) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `roles` SET `role`='%s' " +
                "WHERE `id`=%d", role.getRole(), role.getId());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public boolean delete(Roles role) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `roles` WHERE `id`=%d", role.getId());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public Roles read(int id) throws SQLException {
        List<Roles> list=getAll("WHERE `id`="+id);
        if (list.size()==1)
            return list.get(0);
        return null;
    }

    @Override
    public List<Roles> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `roles` " + where);
        List <Roles> list = new ArrayList <>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Roles(
                        resultSet.getString("role"),
                        resultSet.getInt("id")
                ));
            }
        }
        return list;
    }
}
