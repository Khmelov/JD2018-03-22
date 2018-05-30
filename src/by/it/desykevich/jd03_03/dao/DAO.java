package by.it.desykevich.jd03_03.dao;

import by.it.desykevich.jd03_03.dao.daobeans.RoleDAO;
import by.it.desykevich.jd03_03.dao.daobeans.UserDAO;

public class DAO {

    private static   DAO dao;

    public DAO() {
        role=new RoleDAO();
        user=new UserDAO();
    }

     public UserDAO user;
     public RoleDAO role;


    public static  DAO getInstanse(){
        if (dao==null){
            synchronized (DAO.class){
            dao=new DAO();
        }}
        return dao;
    }
}
