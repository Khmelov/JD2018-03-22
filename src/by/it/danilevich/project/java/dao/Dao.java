package by.it.danilevich.project.java.dao;

import by.it.danilevich.project.java.dao.daobeans.KindOfWorkDao;
import by.it.danilevich.project.java.dao.daobeans.OrderDao;
import by.it.danilevich.project.java.dao.daobeans.RoleDao;
import by.it.danilevich.project.java.dao.daobeans.UserDao;

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

}
