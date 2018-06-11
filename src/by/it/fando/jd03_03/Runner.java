package by.it.fando.jd03_03;

import by.it.fando.jd03_03.dao.DAO;

public class Runner {
    public static void main(String[] args) {
        DAO dao = DAO.getInstance();
        dao.reset();
    }
}
