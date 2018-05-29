package by.it.akhmelev.jd03_03.dao.daobeans;

import by.it.akhmelev.jd03_03.beans.Ad;
import by.it.akhmelev.jd03_03.dao.UniversalDAO;

public class AdDAO extends UniversalDAO<Ad>{
    public AdDAO() {
        super(new Ad(), "ads");
    }
}
