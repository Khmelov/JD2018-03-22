package by.it.kirova.project.java.controller;

import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            if (req.getParameter("loginbutton") != null) {
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                User user;
                DAO dao = DAO.getInstanceDAO();
                String where = String.format("WHERE email='%s' AND password='%s' LIMIT 0,1", email, password);
                List<User> users = dao.user.getAll(where);
                if (users.size() > 0) {
                    user = users.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    return Actions.INDEX.command;
                }
            }

        }
        return null;

    }
}
