package by.it.uskoryaev.project.java.controller;

import by.it.uskoryaev.project.java.beans.Car;
import by.it.uskoryaev.project.java.beans.User;
import by.it.uskoryaev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

class CmdAddCar extends AbstractCmd{

    @Override
    AbstractCmd execute(HttpServletRequest reg) throws Exception {
        User user= Util.getUserFormSession(reg);
        if (user != null){
            if (reg.getMethod().equalsIgnoreCase("post")){
                //create addCar
                String serialNumber = reg.getParameter("SerialNumber");
                String brand = reg.getParameter("Brand");
                String model = reg.getParameter("Model");
                String body_car = reg.getParameter("BodyCar");
                String color = reg.getParameter("Color");
                String year_release = reg.getParameter("YearRelease");
                int id = user.getUser_id();
                Car car = new Car(0,serialNumber,brand,model,body_car,year_release,color,id);
                DAO dao = DAO.getInstanceDao();
                dao.car.create(car);
            }else
                return null;
        }
        return Action.PROFILE.command;
    }
}