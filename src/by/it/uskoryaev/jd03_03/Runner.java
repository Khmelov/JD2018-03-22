package by.it.uskoryaev.jd03_03;

import by.it.uskoryaev.jd03_03.dao.DAO;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstanceDao();
        System.out.println(dao.baseFace.getAll(""));
    }
}
