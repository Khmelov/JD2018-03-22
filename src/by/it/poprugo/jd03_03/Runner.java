package by.it.poprugo.jd03_03;

import by.it.poprugo.jd03_03.dao.DAO;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        System.out.println("проверим CRUD для бина Role");
        System.out.println(dao.role.getAll(""));
        /*System.out.println(dao.user.getAll(""));
        System.out.println(dao.ad.getAll(""));
        // чтобы работал этот Runner, надо проинициализировать by TaskC_Init из ов03_01
        */


        // проверим CRUD для бина User
        System.out.println(dao.user.getAll(""));
        //dao.ad.create();
    }
}
