package by.it.romankov.project.java.controller;

import by.it.romankov.project.java.beans.People;
import by.it.romankov.project.java.beans.Tours;
import by.it.romankov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

public class ResetDB extends CmdAbstract {
    @Override
    CmdAbstract execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstance();
        People people = Util.getPeopleFromSession(req);
        if (people == null)
            return Actions.LOGIN.command;
        if (people.getRoles_id() == 2 || people.getRoles_id() == 4)
            return Actions.INDEX.command;
        List <Tours> listTours = dao.tour.getAll("");
        req.setAttribute("listTours", listTours);

        if (req.getMethod().equalsIgnoreCase("post")) {
            if (req.getParameter("ok") != null) {
                dao.reset();
                req.setAttribute("listTours", dao.tour.getAll(""));
                return null;
            }
            String target = req.getParameter("target");
            String transport = req.getParameter("transport");
            String country = req.getParameter("country");
            String city = req.getParameter("city");
            int price = Integer.parseInt(req.getParameter("price"));
            int days = Integer.parseInt(req.getParameter("days"));
            int id = Integer.parseInt(req.getParameter("id"));
            int people_id = Integer.parseInt(req.getParameter("people_id"));


            Tours edittour = new Tours(id, target, transport, country, city, price, days, people_id);

            if (req.getParameter("Update") != null) {
                dao.tour.update(edittour);
                req.setAttribute("listTours", dao.tour.getAll(""));
            }
            if (req.getParameter("Delete") != null) {
                dao.tour.delete(edittour);
                req.setAttribute("listTours", dao.tour.getAll(""));
            }


        }

        return null;
    }

    public static void main(String[] args) {
        DAO.getInstance().reset();
    }

}

