package by.it.fando.jd03_03.dao.daobeans;

import by.it.fando.jd03_03.beans.Role;
import by.it.fando.jd03_03.dao.UniversalDAO;

public class RoleDAO extends UniversalDAO<Role> {

    public RoleDAO() {
        super(new Role(), "roles");
    }
}
