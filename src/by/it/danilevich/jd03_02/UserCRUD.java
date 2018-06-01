package by.it.danilevich.jd03_02;

import by.it.danilevich.jd03_02.ConnectionCreator;
import by.it.danilevich.jd03_02.RoleBean;
import by.it.danilevich.jd03_02.UserBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {
    static boolean create(UserBean userBean) throws SQLException {
        String sql = String.format( "INSERT INTO"+"`"+CN.NAME_DB+"`. `user`" +
                        "(`name`,`role_id`,`" +
                        "address`,`telephone`," +
                        "`login`,`password`) " +
                        "VALUES " +
                        "('%s','%d','%s','%s','%s','%s')",
                userBean.getName(), userBean.getRoleId(),userBean.getAddress(),
                userBean.getTelephone(),userBean.getLogin(),userBean.getPassword());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    userBean.setId(id);
                }
            }
            return result;
        }    }

    static UserBean read(int id) throws SQLException {
        String sql = String.format("Select * from"+"`"+CN.NAME_DB+"`. `user` where `id`=%d",id);
        try (Connection connection = ConnectionCreator.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                return (
                        new UserBean(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("role_id"),
                        resultSet.getString("address"),
                        resultSet.getString("telephone"),
                        resultSet.getString("login"),
                        resultSet.getString("password"))
                );
            }
        }
        return null;
    }

    static boolean delete(UserBean userBean) throws SQLException {
        String sql = String.format("DELETE FROM "+"`"+CN.NAME_DB+"`.`user` WHERE `id`=%d", userBean.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
    static boolean update(UserBean userBean) throws SQLException {
        String sql = String.format("UPDATE "+"`"+CN.NAME_DB+"`.`user` SET " +
                        "`name`='%s'," +
                        "`role_id`='%d'", " +
                        "`address`='%s'," +
                        "`telephone`='%s'," +
                        "`login`='%s'," +
                        "`password`='%s'" +
                        "WHERE `id`=%d",
                userBean.getName(), userBean.getRoleId(),userBean.getAddress(),
                userBean.getTelephone(),userBean.getLogin(),userBean.getPassword(),userBean.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }



}
