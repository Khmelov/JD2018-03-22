package by.it.romankov.jd03_03.dao.daobeans;

import by.it.romankov.jd03_03.beans.People;
import by.it.romankov.jd03_03.dao.UniversalDAO;
import by.it.romankov.jd03_03.dao.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class PeopleDAO extends AbstactDAO<People>{
    @Override
    public boolean create(People people) throws SQLException {
        String sql = String.format(Locale.US, "INSERT INTO `people`(`name`,`email`,`telephone`,`age`, `roles_id`)"+
                        "VALUES ('%s','%s','%s',%d,%d)",
                people.getName(), people.getEmail(), people.getTelephone(),people.getAge(),people.getRoles_id());
        int id = executeUpdate(sql, true);
        if (id > 0) {
            people.setId(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(People people) throws SQLException {
        String sql = String.format(Locale.US, "DELETE FROM `people` WHERE `id`=%d", people.getId());
        return executeUpdate(sql, false) == 1;

    }

    @Override
    public boolean update(People people) throws SQLException {
        String sql = String.format(Locale.US, "UPDATE `people` SET `name`='%s',`email`='%s',`telephone`='%s'," +
                        "`age`=%d,`roles_id`=%d  WHERE `id`=%d",
                people.getName(),people.getEmail(),people.getTelephone(),
                people.getAge(), people.getRoles_id(),people.getId());
        return executeUpdate(sql, false) == 1;
    }

    @Override
    public People read(int id) throws SQLException {
        List<People> list=getAll("WHERE `id`="+id);
        if (list.size()==1)
            return list.get(0);
        return null;
    }

    @Override
    public List<People> getAll(String where) throws SQLException {
        String sql = String.format(Locale.US, "SELECT * FROM `people` " + where);
        List <People> list = new ArrayList<>();
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new People(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getInt("telephone"),
                        resultSet.getInt("age"),
                        resultSet.getInt("roles_id")
                ));
            }
        }
        return list;

    }
}
