package by.it.desykevich.jd03_03;

import by.it.desykevich.jd03_03.dao.DAO;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao=DAO.getInstanse();
        System.out.println(dao.role.getAll(""));
        System.out.println(dao.user.getAll(""));
    }
}
