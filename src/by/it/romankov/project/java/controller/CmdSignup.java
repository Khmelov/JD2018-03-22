package by.it.romankov.project.java.controller;

import by.it.romankov.project.java.beans.People;
import by.it.romankov.project.java.dao.DAO;
import javax.servlet.http.HttpServletRequest;


public class CmdSignup extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")){
            String login=req.getParameter("login");
            String email=req.getParameter("email");
            String name=req.getParameter("name");
            String password=req.getParameter("password");
            int telephone= Integer.parseInt(req.getParameter("telephone"));
            int age= Integer.parseInt(req.getParameter("age"));


            People people=new People(0,name,email,login,password,telephone,age,2);
            DAO dao = DAO.getInstance();
            dao.people.create(people);
            return Actions.LOGIN.command;
        }
        return null;
    }


}