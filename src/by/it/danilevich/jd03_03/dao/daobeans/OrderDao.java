package by.it.danilevich.jd03_03.dao.daobeans;

import by.it.danilevich.jd03_03.beans.OrderBean;
import by.it.danilevich.jd03_03.beans.UserBean;
import by.it.danilevich.jd03_03.dao.UniversalDao;
import by.it.danilevich.jd03_03.dao.connect.CN;
import by.it.danilevich.jd03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderDao extends AbstractDao<OrderBean> {
    public boolean create(OrderBean orderBean) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO "+"`"+CN.NAME_DB+"`.`order`" +
                        "(`date_order`,`client_id`,`kind_of_work_id`,`executor_id`,`admin_id`," +
                        "`begin_work`,`plan_end_work`,`end_work`,`amount`," +
                        "`total_money`,`total_time`,`status`) " +
                        "VALUES (%d,%d,%d,%d,%d," +
                        "%d,%d,%d,%d,%.2f,%.2f,\'%s\')",
                orderBean.getDateOrder(), orderBean.getClientId(),orderBean.getKindOfWorkId(),
                orderBean.getExecutorId(),orderBean.getAdminId(),orderBean.getBeginWork(),
                orderBean.getPlanEndWork(),orderBean.getEndWork(),orderBean.getAmount(),
                orderBean.getTotalMoney(), orderBean.getTotalMoney(),orderBean.getStatus());        int id = executeUpdate(sql, true);
        if (id>0){
            orderBean.setId(id);
            return true;
        }

        return false;
    }

    @Override
    public OrderBean read(int id) throws SQLException {
        List<OrderBean> orders = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        } else
            return null;
    }

    @Override
    public boolean update(OrderBean orderBean) throws SQLException {
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
        return (executeUpdate(sql, false)==1);
    }

    @Override
    public boolean delete(OrderBean orderBean) throws SQLException {
        String sql = String.format("DELETE FROM "+"`"+CN.NAME_DB+"`.`order` WHERE `id`=%d", orderBean.getId());
        return (executeUpdate(sql, false)==1);
    }

    @Override
    public List<OrderBean> getAll(String where) throws SQLException {
        List<OrderBean> orders = new ArrayList<>();
        String sql = String.format("Select * from "+"`"+CN.NAME_DB+"`.`order` "+ where);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                OrderBean orderBean = new OrderBean();
                orderBean.setId(rs.getInt("id"));
                        orderBean.setDateOrder(rs.getInt("date_order"));
                        orderBean.setClientId(rs.getInt("client_id"));
                        orderBean.setKindOfWorkId(rs.getInt("kind_of_work_id"));
                        orderBean.setExecutorId(rs.getInt("executor_id"));
                        orderBean.setAdminId(rs.getInt("admin_id"));
                        orderBean.setBeginWork(rs.getInt("begin_work"));
                        orderBean.setPlanEndWork(rs.getInt("plan_end_work"));
                        orderBean.setEndWork(rs.getInt("end_work"));
                        orderBean.setAmount(rs.getInt("amount"));
                        orderBean.setTotalMoney(rs.getDouble("total_money"));
                        orderBean.setTotalTime(rs.getDouble("total_time"));
                        orderBean.setStatus(rs.getString("status"));
                orders.add(orderBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
