package by.it.verishko.jd03_03.dao.daobeans;

import by.it.verishko.jd03_03.beans.Product;
import by.it.verishko.jd03_03.dao.UniversalDAO;

public class ProductDAO extends UniversalDAO<Product> {

    public ProductDAO() {
        super(new Product(), "users");
    }
}

