package by.it.uskoryaev.project.java.controller;

import by.it.uskoryaev.project.java.beans.Car;
import by.it.uskoryaev.project.java.dao.connect.ConnectionCreator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class CmdChooseCar extends AbstractCmd {
    @Override
    AbstractCmd execute(HttpServletRequest reg) throws Exception {
        Car car = new Car();
        List<Car> carList = new ArrayList<>();
        String sql = "SELECT * FROM 'CAR' WHERE ID_CAR=" + car.getId_car();
        if (reg.getMethod().equalsIgnoreCase("post")) {
            if (reg.getParameter("click") != null) {
                try (Connection connection = ConnectionCreator.getConnection();
                     Statement statement = connection.createStatement()) {
                    ResultSet resultSet = statement.executeQuery(sql);


                }
            }
        }
        return null;
    }
}