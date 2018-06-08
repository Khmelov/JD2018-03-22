package by.it.danilevich.project.java.dao.daobeans;

import by.it.danilevich.project.java.beans.RoleBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.UniversalDao;
import by.it.danilevich.project.java.dao.connect.CN;
import by.it.danilevich.project.java.dao.connect.ConnectionCreator;

import javax.management.AttributeValueExp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class RoleDao extends AbstractDao<RoleBean> {
    @Override
    public boolean create(RoleBean roleBean) throws SQLException {
        String sql = String.format( Locale.US,"INSERT INTO "+"`"+CN.NAME_DB+"`.`role`" +
                "(`name`) " +
                "VALUES " +
                "('%s')", roleBean.getName());
        int id = executeUpdate(sql, true);
        if (id>0){
            roleBean.setId(id);
            return true;
        }

        return false;
    }

    @Override
    public RoleBean read(int id) throws SQLException {
        List<RoleBean> roles = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean update(RoleBean roleBean) throws SQLException {
        String sql = String.format("UPDATE "+"`"+CN.NAME_DB+"`.`role` SET " +
                        "`name`='%s'" +
                        "WHERE `id`=%d",
                roleBean.getName(), roleBean.getId());
        return (executeUpdate(sql, false)==1);
     }

    @Override
    public boolean delete(RoleBean roleBean) throws SQLException {
        String sql = String.format("DELETE FROM "+"`"+CN.NAME_DB+"`.`role` WHERE `id`=%d", roleBean.getId());
        return (executeUpdate(sql, false)==1);
    }

    @Override
    public List<RoleBean> getAll(String where) throws SQLException {
        List<RoleBean> roles = new ArrayList<>();
        String sql = String.format("Select * from "+"`"+CN.NAME_DB+"`.`role` "+ where);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                RoleBean roleBean = new RoleBean();
                roleBean.setId(rs.getInt("ID"));
                roleBean.setName(rs.getString("name"));
                roles.add(roleBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;    }
}
