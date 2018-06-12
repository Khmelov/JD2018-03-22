package by.it.pashkevich.project.java.controller;

import by.it.pashkevich.project.java.dao.DAO;
import by.it.pashkevich.project.java.beans.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdEditUsers extends Cmd
{
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user == null)
            return Actions.LOGIN.command;
        if (user.getRoles_id() != 1)
            return Actions.PROFILE.command;
        DAO dao = DAO.getInstance();
        if (req.getMethod().equalsIgnoreCase("post")) {
            String salt = "shaurma";
            int id = Integer.parseInt(req.getParameter("id"));
            String password = req.getParameter("password");
            int roles_id = Integer.parseInt(req.getParameter("roles_id"));
            String hashpassword = DigestUtils.sha256Hex(password + salt);
            User editUser = new User(id, req.getParameter("login"), hashpassword, req.getParameter("email"), roles_id);
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
