package by.it.poprugo.project.java.dao;

public class Runner {
    public static void main(String[] args) {
        DAO dao = DAO.getInstance();
        dao.reset();
    }
}
