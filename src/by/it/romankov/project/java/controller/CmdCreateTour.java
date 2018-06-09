package by.it.romankov.project.java.controller;

import by.it.romankov.project.java.beans.People;
import by.it.romankov.project.java.beans.Tours;
import by.it.romankov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateTour extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {

        People people = Util.getPeopleFromSession(req);
        if (people != null) {
            if (req.getMethod().equalsIgnoreCase("post")) {
                Tours tour = new Tours();
                tour.setTarget(req.getParameter("Target"));
                tour.setTransport(req.getParameter("Transport"));
                tour.setCountry(req.getParameter("Country"));
                tour.setCity(req.getParameter("City"));
                tour.setPrice(Integer.parseInt(req.getParameter("Price")));
                tour.setDays(Integer.parseInt(req.getParameter("Days")));
                tour.setPeople_id(people.getId());
                DAO.getInstance().tour.create(tour);
            } else
                return null;
        }
        return Actions.PROFILE.command;


    }
}