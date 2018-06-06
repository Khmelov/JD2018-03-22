package by.it.romankov.project.java.controller;

import by.it.romankov.project.java.beans.People;
import by.it.romankov.project.java.beans.Tours;
import by.it.romankov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateTour extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        People people=Util.getPeopleFromSession(req);

        if (people!=null){
            if (req.getMethod().equalsIgnoreCase("post")){
                Tours tour = new Tours();
               tour.setTarget(req.getParameter("target"));
               tour.setTransport(req.getParameter("transport"));
               tour.setCountry(req.getParameter("country"));
                tour.setCity(req.getParameter("city"));
                tour.setPrice(Integer.parseInt(req.getParameter("price")));
                tour.setDays(Integer.parseInt(req.getParameter("days")));
                DAO.getInstance().tour.create(tour);
            }
            else return null;
        }
        return Actions.LOGIN.command;


    }
}