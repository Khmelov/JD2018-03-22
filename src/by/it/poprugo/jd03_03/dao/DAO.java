package by.it.poprugo.jd03_03.dao;

import by.it.poprugo.jd03_03.dao.daobeans.AdDAO;
import by.it.poprugo.jd03_03.dao.daobeans.RoleDAO;
import by.it.poprugo.jd03_03.dao.daobeans.UserDAO;

public class DAO {
    private static DAO dao;

    //public DAO() {} заменили на private DAO(), иначе это не будет синглтон

    private DAO() {
        role = new RoleDAO();
        user = new UserDAO();
        ad = new AdDAO();
    }

    public RoleDAO role;
    public UserDAO user;
    public AdDAO ad;

    public static DAO getInstance() {
        if (dao == null) {
            //синглтоном на синхронайзе по классу
            synchronized (DAO.class) {
                if (dao == null)
                    dao = new DAO();
            }
        }
        return dao;
    }

    //в reset вставили большой кусок скопированный из TaskC_Init
    public void reset() {};
}
