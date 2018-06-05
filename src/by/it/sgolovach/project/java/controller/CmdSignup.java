package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;
import by.it.sgolovach.project.java.pattern.Parser;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            Parser parser = new Parser();
            boolean log, ema, pass;
            String login = req.getParameter("login");
            log = parser.regEx(login, "login");
            String email = req.getParameter("email");
            ema = parser.regEx(email, "email");
            String password = req.getParameter("password");
            pass = parser.regEx(password, "pass");
            if(log&&ema&&pass) {
            User user = new User(0, login, password, email, 2);
            DAO dao = DAO.getInstance();
                dao.user.create(user);
                return Action.LOGIN.comand;
            }
        }
        return null;
    }
}
