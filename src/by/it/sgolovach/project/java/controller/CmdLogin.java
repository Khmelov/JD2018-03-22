package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;
import by.it.sgolovach.project.java.pattern.Parser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends CmdAbstract {


    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            Parser parser = new Parser();
            boolean log, pass;
            String login = req.getParameter("login");
            log = parser.regEx(login, "login");
            String password = req.getParameter("password");
            pass = parser.regEx(password, "pass");
            if (log && pass) {
                User user = new User(0, login, password, "", 2);
                DAO dao = DAO.getInstance();
                String where = String.format("WHERE login='%s' AND password='%s'", login, password);
                List<User> users = dao.user.getAll(where);
                if (users.size() > 0) {
                    user = users.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);
                    return Action.PROFILE.comand;
                }
            }
            return Action.LOGIN.comand;
        }
        return null;
    }
}
