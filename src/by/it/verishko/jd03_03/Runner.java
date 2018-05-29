package by.it.verishko.jd03_03;

import by.it.verishko.jd03_03.dao.DAO;

import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
//        System.out.println(dao.role.getAll(""));
        System.out.println(dao.user.getAll(""));
        System.out.println(dao.product.getAll(""));
    }

}
