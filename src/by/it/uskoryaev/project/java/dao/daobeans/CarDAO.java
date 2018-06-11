package by.it.uskoryaev.project.java.dao.daobeans;

import by.it.uskoryaev.project.java.beans.Car;
import by.it.uskoryaev.project.java.dao.UniversalDAO;

public class CarDAO extends UniversalDAO<Car> {
    public CarDAO() {
        super(new Car(), "car");
    }
}
