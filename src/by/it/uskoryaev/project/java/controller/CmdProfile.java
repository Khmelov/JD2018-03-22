package by.it.uskoryaev.project.java.controller;


import by.it.uskoryaev.project.java.beans.Car;
import by.it.uskoryaev.project.java.beans.User;
import by.it.uskoryaev.project.java.dao.DAO;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

class CmdProfile extends AbstractCmd {
    @Override
    AbstractCmd execute(HttpServletRequest reg) throws Exception {
        User user = Util.getUserFormSession(reg);
        if (user != null) {
            if (reg.getMethod().equalsIgnoreCase("post")) {
            } else {
                DAO dao = DAO.getInstanceDao();
                List<Car> listCar = dao.car.getAll("WHERE user_user_Id=" + user.getUser_id());
                reg.getSession().setAttribute("listCar", listCar);
            }
            return Action.PROFILE.command;
        }
        return null;
    }
}
