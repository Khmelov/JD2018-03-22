package by.it.romankov.project.java.controller;

import by.it.romankov.project.java.beans.People;
import by.it.romankov.project.java.beans.Tours;
import by.it.romankov.project.java.dao.DAO;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProfile extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        People people = Util.getPeopleFromSession(req);
        if (people != null) {
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (req.getParameter("UpdateProfile") != null){
                    people.setPassword(req.getParameter("password"));
                    people.setLogin(req.getParameter("login"));
                    DAO dao = DAO.getInstance();
                    dao.people.update(people);
                    return null;
                }
                if (req.getParameter("logout") != null)
                    req.getSession().invalidate();
                return Actions.LOGIN.command;
            }
            else {
                DAO dao = DAO.getInstance();
                List<Tours> listToursPeople = dao.tour.getAll("WHERE people_id=" + people.getId());
                req.getSession().setAttribute("tours",listToursPeople);
            }
            return null;
        }
        return Actions.LOGIN.command;
    }
}
