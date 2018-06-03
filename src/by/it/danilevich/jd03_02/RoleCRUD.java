package by.it.danilevich.jd03_02;

import by.it.danilevich.jd03_02.ConnectionCreator;
import by.it.danilevich.jd03_02.RoleBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class RoleCRUD {
    public static boolean create(RoleBean roleBean) throws SQLException {
        String sql = String.format( Locale.US,"INSERT INTO "+"`"+CN.NAME_DB+"`.`role`" +
                        "(`name`) " +
                        "VALUES " +
                        "('%s')", roleBean.getName());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    roleBean.setId(id);
                }
            }
            return result;
        }    }

    static RoleBean read(int id) throws SQLException {
        String sql = String.format("Select * from "+"`"+CN.NAME_DB+"`.`role` where `id`=%d",id);
        try (Connection connection = ConnectionCreator.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                return (new RoleBean(resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
        }
        return null;
    }

    static boolean delete(RoleBean roleBean) throws SQLException {
        String sql = String.format("DELETE FROM "+"`"+CN.NAME_DB+"`.`role` WHERE `id`=%d", roleBean.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
    static boolean update(RoleBean roleBean) throws SQLException {
        String sql = String.format("UPDATE "+"`"+CN.NAME_DB+"`.`role` SET " +
                        "`name`='%s'" +
                        "WHERE `id`=%d",
                roleBean.getName(), roleBean.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }



}
