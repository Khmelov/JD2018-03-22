package by.it.sgolovach.jd03_03.dao;

import by.it.sgolovach.jd03_03.dao.daobeans.AdDAO;
import by.it.sgolovach.jd03_03.dao.daobeans.RoleDAO;
import by.it.sgolovach.jd03_03.dao.daobeans.UserDAO;

public class DAO {

    private static DAO dao;

    public RoleDAO role;
    public UserDAO user;
    public AdDAO ad;

    private DAO() {
        role=new RoleDAO();
        user=new UserDAO();
        ad=new AdDAO();
    }

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
