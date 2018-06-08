package by.it.danilevich.project.java.dao.daobeans;

import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.UniversalDao;
import by.it.danilevich.project.java.dao.connect.CN;
import by.it.danilevich.project.java.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserDao extends AbstractDao<UserBean> {
    @Override
    public boolean create(UserBean userBean) throws SQLException {
        String sql = String.format( "INSERT INTO"+"`"+CN.NAME_DB+"`. `user`" +
                        "(`name`,`role_id`,`" +
                        "address`,`telephone`," +
                        "`login`,`password`) " +
                        "VALUES " +
                        "('%s','%d','%s','%s','%s','%s')",
                userBean.getName(), userBean.getRoleId(),userBean.getAddress(),
                userBean.getTelephone(),userBean.getLogin(),userBean.getPassword());
        int id = executeUpdate(sql, true);
        if (id>0){
            userBean.setId(id);
            return true;
        }

        return false;
    }

    @Override
    public UserBean read(int id) throws SQLException {
        List<UserBean> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }

    @Override
    public boolean update(UserBean userBean) throws SQLException {
        String sql = String.format("UPDATE "+"`"+CN.NAME_DB+"`.`user` SET " +
                        "`name`='%s'," +
                        "`role_id`='%d', " +
                        "`address`='%s'," +
                        "`telephone`='%s'," +
                        "`login`='%s'," +
                        "`password`='%s'" +
                        "WHERE `id`=%d",
                userBean.getName(), userBean.getRoleId(),userBean.getAddress(),
                userBean.getTelephone(),userBean.getLogin(),userBean.getPassword(),userBean.getId());

        return (executeUpdate(sql, false)==1);
    }

    @Override
    public boolean delete(UserBean userBean) throws SQLException {
        String sql = String.format("DELETE FROM "+"`"+CN.NAME_DB+"`.`user` WHERE `id`=%d", userBean.getId());
        return (executeUpdate(sql, false)==1);
    }

    @Override
    public List<UserBean> getAll(String where) throws SQLException {
        List<UserBean> users = new ArrayList<>();
        String sql = String.format("Select * from "+"`"+CN.NAME_DB+"`.`user`" + where);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                UserBean userBean = new UserBean();
                userBean.setId(rs.getInt("id"));
                userBean.setName(rs.getString("name"));
                userBean.setRoleId(rs.getInt("role_id"));
                userBean.setAddress(rs.getString("address"));
                userBean.setTelephone(rs.getString("telephone"));
                userBean.setLogin(rs.getString("login"));
                userBean.setPassword(rs.getString("password"));
                users.add(userBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;    }
}
