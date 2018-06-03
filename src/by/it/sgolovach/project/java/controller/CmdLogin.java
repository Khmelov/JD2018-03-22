package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdLogin extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            User user = new User(0, login, password, "", 2);
            DAO dao = DAO.getInstance();
            String where = String.format("WHERE login='%s' AND password='%s'", login, password);
            if (dao.user.getAll(where).size() > 0) {
                return Action.INDEX.comand;
            }
            return Action.LOGIN.comand;
        }
        return null;
    }
}
