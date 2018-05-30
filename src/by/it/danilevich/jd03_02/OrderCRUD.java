package by.it.danilevich.jd03_02;

import by.it.danilevich.jd03_02.ConnectionCreator;
import by.it.danilevich.jd03_02.OrderBean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class OrderCRUD {
    static boolean create(OrderBean orderBean) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO "+"`"+CN.NAME_DB+"`.`order`" +
                        "(`date_order`,`client_id`,`kind_of_work_id`,`executor_id`,`admin_id`," +
                        "`begin_work`,`plan_end_work`,`end_work`,`amount`," +
                        "`total_money`,`total_time`,`status`) " +
                        "VALUES (%d,%d,%d,%d,%d," +
                        "%d,%d,%d,%d,%.2f,%.2f,\'%s\')",
                orderBean.getDateOrder(), orderBean.getClientId(),orderBean.getKindOfWorkId(),
                orderBean.getExecutorId(),orderBean.getAdminId(),orderBean.getBeginWork(),
                orderBean.getPlanEndWork(),orderBean.getEndWork(),orderBean.getAmount(),
                orderBean.getTotalMoney(), orderBean.getTotalMoney(),orderBean.getStatus());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            boolean result = (1 == statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS));
            if (result) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    orderBean.setId(id);
                }
            }
            return result;
        }    }

    static OrderBean read(int id) throws SQLException {
        String sql = String.format("Select * from "+"`"+CN.NAME_DB+"`.`order` where `id`=%d", id);
        try (Connection connection = ConnectionCreator.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                return (
                        new OrderBean(resultSet.getInt("id"),
                                resultSet.getInt("date_order"),
                                resultSet.getInt("client_id"),
                                resultSet.getInt("kind_of_work_id"),
                                resultSet.getInt("executor_id"),
                                resultSet.getInt("admin_id"),
                                resultSet.getInt("begin_work"),
                                resultSet.getInt("plan_end_work"),
                                resultSet.getInt("end_work"),
                                resultSet.getInt("amount"),
                                resultSet.getDouble("total_money"),
                                resultSet.getDouble("total_time"),
                                resultSet.getString("status")));
            }
        }
        return null;
    }

    static boolean delete(OrderBean orderBean) throws SQLException {
        String sql = String.format("DELETE FROM "+"`"+CN.NAME_DB+"`.`order` WHERE `id`=%d", orderBean.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
    static boolean update(OrderBean orderBean) throws SQLException {
        String sql = String.format(Locale.US,"UPDATE "+"`"+CN.NAME_DB+"`.`order` SET " +
                        "`date_order`=%d," +
                        "`client_id`=%d," +
                        "`kind_of_work_id`=%d," +
                        "`executor_id`=%d," +
                        "`admin_id`=%d,"+
                        "`begin_work`=%d,"+
                        "`plan_end_work`=%d,"+
                        "`end_work`=%d,"+
                        "`amount`=%d,"+
                        "`total_money`=%.2f,"+
                        "`total_time`=%.2f,"+
                        "`status`=\'%s\' "+
                        "WHERE `id`=%d",
                orderBean.getDateOrder(), orderBean.getClientId(),orderBean.getKindOfWorkId(),
                orderBean.getExecutorId(),orderBean.getAdminId(),orderBean.getBeginWork(),
                orderBean.getPlanEndWork(),orderBean.getEndWork(),orderBean.getAmount(),
                orderBean.getTotalMoney(),orderBean.getTotalTime(),orderBean.getStatus(),orderBean.getId());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
