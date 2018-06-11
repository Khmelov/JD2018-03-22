package by.it.danilevich.project.java.dao;

import by.it.danilevich.project.java.dao.connect.ConnectionCreator;
import by.it.danilevich.project.java.dao.daobeans.KindOfWorkDao;
import by.it.danilevich.project.java.dao.daobeans.OrderDao;
import by.it.danilevich.project.java.dao.daobeans.RoleDao;
import by.it.danilevich.project.java.dao.daobeans.UserDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    private static Dao instance;
    public RoleDao roleDao;
    public UserDao userDao;
    public KindOfWorkDao kindOfWorkDao;
    public OrderDao orderDao;

    private Dao() {
        roleDao = new RoleDao();
        userDao = new UserDao();
        kindOfWorkDao = new KindOfWorkDao();
        orderDao = new OrderDao();
    }


    public static Dao getInstance(){
        if (instance==null){
            synchronized (Dao.class){
                if (instance==null){
                    instance = new Dao();
                }
            }
        }        return instance;
    }

    public static void deleteDateBase(){
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();)
        {
            statement.executeUpdate(InitBase.deleteSchema);
            System.out.println("Delete dateBase");
        }
        catch (SQLException e1) {

            e1.printStackTrace();
        }

    }

    public static void createDateBase() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();)
        {
//            statement.executeUpdate("use " + CN.NAME_DB);
            statement.executeUpdate(InitBase.createSchema);
            statement.executeUpdate(InitBase.createRole);
            statement.executeUpdate(InitBase.createKindofWork);
            statement.executeUpdate(InitBase.createUser);
            statement.executeUpdate(InitBase.createOrder);

            statement.executeUpdate(InitBase.insertRole);
            statement.executeUpdate(InitBase.insertUser);
            statement.executeUpdate(InitBase.insertKindOfWork);
            statement.executeUpdate(InitBase.insertOrder);
            System.out.println("Create dateBase");
        }
    }

}
