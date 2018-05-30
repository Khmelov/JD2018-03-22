package by.it.danilevich.jd03_03.dao.daobeans;

import by.it.danilevich.jd03_03.beans.KindOfWorkBean;
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

public class KindOfWorkDao extends AbstractDao<KindOfWorkBean> {    @Override
public boolean create(KindOfWorkBean kindOfWorkBean) throws SQLException {
    String sql = String.format( Locale.US, "INSERT INTO"+"`"+CN.NAME_DB+"`.`kind_of_work`" +
                    "(`name`,`price`,`time_norm`,`category`,`unit`) " +
                    "VALUES ('%s','%f','%f','%s','%s')",
            kindOfWorkBean.getName(), kindOfWorkBean.getPrice(),kindOfWorkBean.getTimeNorm(),
            kindOfWorkBean.getCategory(),kindOfWorkBean.getUnit());
    int id = executeUpdate(sql, true);
    if (id>0){
        kindOfWorkBean.setId(id);
        return true;
    }

    return false;
}

    @Override
    public KindOfWorkBean read(int id) throws SQLException {
        List<KindOfWorkBean> kindsOfWork = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (kindsOfWork.size() > 0) {
            return kindsOfWork.get(0);
        } else
            return null;
    }

    @Override
    public boolean update(KindOfWorkBean kindOfWorkBean) throws SQLException {
        String sql = String.format(Locale.US,"UPDATE "+"`"+CN.NAME_DB+"`.`kind_of_work` SET " +
                        "`name`=\"%s\"," +
                        "`price`=%.2f, " +
                        "`time_norm`=%.2f," +
                        "`category`=\"%s\"," +
                        "`unit`=\"%s\" " +
                        "WHERE `id`=%d",
                kindOfWorkBean.getName(), kindOfWorkBean.getPrice(),kindOfWorkBean.getTimeNorm(),
                kindOfWorkBean.getCategory(),kindOfWorkBean.getUnit(),kindOfWorkBean.getId());

        return (executeUpdate(sql, false)==1);
    }

    @Override
    public boolean delete(KindOfWorkBean kindOfWorkBean) throws SQLException {
        String sql = String.format("DELETE FROM "+"`"+CN.NAME_DB+"`.`kind_of_work` WHERE `id`=%d", kindOfWorkBean.getId());
        return (executeUpdate(sql, false)==1);
    }

    @Override
    public List<KindOfWorkBean> getAll(String where) throws SQLException {
        List<KindOfWorkBean> kindsOfWorks = new ArrayList<>();
        String sql = String.format("Select * from "+"`"+CN.NAME_DB+"`.`kind_of_work` "+ where);
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                KindOfWorkBean kindOfWorkBean = new KindOfWorkBean();
                kindOfWorkBean.setId(rs.getInt("id"));
                kindOfWorkBean.setName(rs.getString("name"));
                kindOfWorkBean.setPrice(rs.getDouble("price"));
                kindOfWorkBean.setTimeNorm(rs.getDouble("time_norm"));
                kindOfWorkBean.setCategory(rs.getString("category"));
                kindOfWorkBean.setUnit(rs.getString("unit"));
                kindsOfWorks.add(kindOfWorkBean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kindsOfWorks;    }
}
