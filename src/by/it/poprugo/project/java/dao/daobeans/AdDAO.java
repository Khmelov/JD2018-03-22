package by.it.poprugo.project.java.dao.daobeans;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.dao.UniversalDAO;

public class AdDAO extends UniversalDAO<Ad> {
    public AdDAO() {
        super(new Ad(), "ads");
    }
}
