package by.it.danilevich.jd03_02;

import by.it.danilevich.jd03_02.ConnectionCreator;
import by.it.danilevich.jd03_02.KindOfWorkBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class KindOfWorkCRUD {
    static boolean create(KindOfWorkBean kindOfWorkBean) throws SQLException {
        String sql = String.format( Locale.US, "INSERT INTO"+"`"+CN.NAME_DB+"`.`kind_of_work`" +
                        "(`name`,`price`,`time_norm`,`category`,`unit`) " +
                        "VALUES ('%s','%f','%f','%s','%s')",
                kindOfWorkBean.getName(), kindOfWorkBean.getPrice(),kindOfWorkBean.getTimeNorm(),
                kindOfWorkBean.getCategory(),kindOfWorkBean.getUnit());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    kindOfWorkBean.setId(id);
                }
            }
            return result;
        }    }

    static KindOfWorkBean read(int id) throws SQLException {
        String sql = String.format("Select * from"+"`"+CN.NAME_DB+"`.`kind_of_work` where `id`=%d", id);
        try (Connection connection = ConnectionCreator.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                return (
                        new KindOfWorkBean(resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getDouble("price"),
                                resultSet.getDouble("time_norm"),
                                resultSet.getString("category"),
                                resultSet.getString("unit"))
                );
            }
        }
        return null;
    }

    static boolean delete(KindOfWorkBean kindOfWorkBean) throws SQLException {
        String sql = String.format("DELETE FROM `"+ CN.NAME_DB+"`.`kind_of_work` WHERE `id`=%d", kindOfWorkBean.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
    static boolean update(KindOfWorkBean kindOfWorkBean) throws SQLException {
        String sql = String.format(Locale.US,"UPDATE "+"`"+CN.NAME_DB+"`.`kind_of_work` SET " +
                        "`name`=\"%s\"," +
                        "`price`=%.2f, " +
                        "`time_norm`=%.2f," +
                        "`category`=\"%s\"," +
                        "`unit`=\"%s\" " +
                        "WHERE `id`=%d",
                kindOfWorkBean.getName(), kindOfWorkBean.getPrice(),kindOfWorkBean.getTimeNorm(),
                kindOfWorkBean.getCategory(),kindOfWorkBean.getUnit(),kindOfWorkBean.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }



}
