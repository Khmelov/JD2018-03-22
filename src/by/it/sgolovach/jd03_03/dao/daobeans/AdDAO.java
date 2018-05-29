package by.it.sgolovach.jd03_03.dao.daobeans;

import by.it.sgolovach.jd03_03.beans.Ad;
import by.it.sgolovach.jd03_03.dao.UniversalDAO;

public class AdDAO extends UniversalDAO<Ad> {
    public AdDAO() {
        super(new Ad(), "ads");
    }
}
