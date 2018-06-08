package by.it.desykevich.project.java.controller;



import by.it.desykevich.project.java.beans.User;
import by.it.desykevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends CmdAbstract {

    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req))
            return null;
        String login =
                FormUtil.getString(req, "login", Patterns.LOGIN);
        String password =
                FormUtil.getString(req, "password", Patterns.PASSWORD);
        DAO dao = DAO.getInstanse();
        List<User> list = dao.userDAO.getAll(" where login='" + login + "' and password='" + password + "'");
        if (list.size() > 0) {
            req.setAttribute(Msg.MESSAGE, "user " + login + " exists.");
            HttpSession session = req.getSession();
            session.setAttribute("user", list.get(0));
            return Actions.INDEX.command;
        } else
            req.setAttribute(Msg.MESSAGE, "check inputs");

        req.setAttribute(Msg.MESSAGE, "user " + login + " not exists.");
        return Actions.LOGIN.command;
    }
}
