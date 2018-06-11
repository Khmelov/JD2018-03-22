package by.it.uskoryaev.project.java.controller;


import by.it.uskoryaev.project.java.beans.Car;
import by.it.uskoryaev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends AbstractCmd {
    @Override
    public CmdIndex execute(HttpServletRequest reg) throws Exception {
        List<Car> chooseCar = DAO.getInstanceDao().car.getAll("");
        reg.setAttribute("chooseCar",chooseCar);
        return null;
    }
}