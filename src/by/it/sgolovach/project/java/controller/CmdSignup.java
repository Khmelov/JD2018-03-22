package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        if(req.getMethod().equalsIgnoreCase("post")){
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            User user=new User(0,login,password,email,2);
            DAO dao = DAO.getInstance();
            dao.user.create(user);
            return Action.LOGIN.comand;
        }
        return null;
    }
}
