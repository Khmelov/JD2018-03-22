package by.it.romankov.project.java.controller;

import by.it.romankov.project.java.beans.People;
import by.it.romankov.project.java.beans.Tours;
import by.it.romankov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ResetDB extends CmdAbstract {
    @Override
    CmdAbstract execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstance();
        People people = Util.getPeopleFromSession(req);
        if (people == null)
            return Actions.LOGIN.command;
        if(people.getRoles_id()==2 ||people.getRoles_id()==4)
            return Actions.INDEX.command;
        List <Tours> listTours = dao.tour.getAll("");
        req.setAttribute("listTours", listTours);

        if(req.getParameter("Сброс")!=null){
           if (people.getRoles_id()==1 || people.getRoles_id()==3 ){
                dao.reset();
                return Actions.RESETDB.command;
           }
                }





        return null;
    }

}