package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.beans.User;
import by.it.verishko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdEditUsers extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user == null)
            return Actions.LOGIN.command;
        if (user.getRoles_id() != 2)
            return Actions.PROFILE.command;
        DAO dao = DAO.getInstance();
        if (req.getMethod().equalsIgnoreCase("post")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            int roles_id = Integer.parseInt(req.getParameter("roles_id"));
            User editUser = new User(id, login, password, email, roles_id);
            if (req.getParameter("Update") != null)
                dao.user.update(editUser);
            else if (req.getParameter("Delete") != null)
                dao.user.delete(editUser);
        }
        req.setAttribute("users", dao.user.getAll(""));
        req.setAttribute("roles", dao.role.getAll("")); //to context servlet
        return null;
    }
}
