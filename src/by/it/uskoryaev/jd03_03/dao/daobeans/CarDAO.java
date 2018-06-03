package by.it.uskoryaev.jd03_03.dao.daobeans;

import by.it.uskoryaev.jd03_03.beans.Car;
import by.it.uskoryaev.jd03_03.dao.UniversalDAO;

public class CarDAO extends UniversalDAO<Car> {
    public CarDAO() {
        super(new Car(),"car");
    }
}
