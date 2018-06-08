package by.it.poprugo.jd03_03_mine.dao.daobeans;

import by.it.poprugo.jd03_03_mine.beans.Model;
import by.it.poprugo.jd03_03_mine.dao.UniversalDAO;

public class ModelDAO extends UniversalDAO {
    public ModelDAO() { super(new Model(), "models"); // sqlTableName
    }
}
