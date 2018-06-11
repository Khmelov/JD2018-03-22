package by.it.romankov.project.java.controller;

import by.it.romankov.project.java.beans.People;
import by.it.romankov.project.java.controller.CmdAbstract;
import by.it.romankov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdEditPeople extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        People people = Util.getPeopleFromSession(req);
        if (people == null)
            return Actions.LOGIN.command;
        System.out.println(people.toString());
        if (people.getRoles_id()!=1 && people.getRoles_id()!=3 ){

            return Actions.PROFILE.command;}


        if (req.getMethod().equalsIgnoreCase("post")) {
            String login=req.getParameter("login");
            String email=req.getParameter("email");
            String name=req.getParameter("name");
            String password=req.getParameter("password");
            int telephone= Integer.parseInt(req.getParameter("telephone"));
            int age= Integer.parseInt(req.getParameter("age"));
            int roles_id = Integer.parseInt(req.getParameter("roles_id"));
            int id = Integer.parseInt(req.getParameter("id"));

            People editpeople=new People(id,name,email,login,password,telephone,age,roles_id);
            DAO dao = DAO.getInstance();

            if (req.getParameter("Update") != null){
                dao.people.update(editpeople);
                System.out.println(editpeople.toString());

           }
            else if (req.getParameter("Delete") != null)
                dao.people.delete(editpeople);


        }
        DAO dao = DAO.getInstance();
        req.setAttribute("people", dao.people.getAll(""));
        req.setAttribute("roles", dao.role.getAll(""));
        return null;

    }
}
