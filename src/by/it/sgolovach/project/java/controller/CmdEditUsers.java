package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;
import by.it.sgolovach.project.java.pattern.Parser;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdEditUsers extends CmdAbstract {


    @Override
    public CmdAbstract execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user1 = Util.getUserFromSession(req);
        if (user1 == null)
            return Action.LOGIN.comand;
        if (user1.getRoles_id() != 1)
            return Action.PROFILE.comand;
        DAO dao = DAO.getInstance();
        if (req.getMethod().equalsIgnoreCase("post")) {
            String salt = "random";
            int id = Integer.parseInt(req.getParameter("id"));
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            int roles_id = Integer.parseInt(req.getParameter("roles_id"));
            String hashpassword = DigestUtils.sha256Hex(password + salt);
            User editUser = new User(id, login, hashpassword, email, roles_id);
            if (req.getParameter("Update") != null)
                dao.user.update(editUser);
            else if (req.getParameter("Delete") != null)
                dao.user.delete(editUser);

        }
        req.setAttribute("users", dao.user.getAll(""));
        req.setAttribute("roles", dao.role.getAll(""));
        return null;
    }
}
