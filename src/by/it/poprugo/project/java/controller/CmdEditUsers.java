package by.it.poprugo.project.java.controller;

import by.it.poprugo.project.java.beans.User;
import by.it.poprugo.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdEditUsers extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
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

            //do somthing
        }
        req.setAttribute("users", dao.user.getAll(""));
        req.setAttribute("roles", dao.role.getAll("")); //to context servlet
        return null;
    }

}