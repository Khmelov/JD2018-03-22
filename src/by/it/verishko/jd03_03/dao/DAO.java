package by.it.verishko.jd03_03.dao;

import by.it.verishko.jd03_03.dao.daobeans.*;

public class DAO {

    private static DAO dao;

    private DAO() {
        role = new RoleDAO();
        user = new UserDAO();
        product = new ProductDAO();
    }

    public RoleDAO role;
    public UserDAO user;
    public ProductDAO product;

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null)
                    dao = new DAO();
            }
        }
        return dao;
    }
}
