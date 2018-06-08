package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdEditProfile extends CmdAbstract {
    @Override
    CmdAbstract execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user1 = Util.getUserFromSession(req);
        if (user1 == null)
            return Action.LOGIN.comand;
        DAO dao = DAO.getInstance();
        if (req.getMethod().equalsIgnoreCase("post")) {
            String salt = "random";
            int id = user1.getId();
            String login = req.getParameter("login");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            int roles_id = user1.getRoles_id();
            String hashpassword = DigestUtils.sha256Hex(password + salt);
            User editUser = new User(id, login, hashpassword, email, roles_id);
            if (req.getParameter("Update") != null) {
                dao.user.update(editUser);
                req.getSession().invalidate();
                return Action.LOGIN.comand;
            } else if (req.getParameter("Delete") != null) {
                dao.user.delete(editUser);
                req.getSession().invalidate();
                return Action.LOGIN.comand;
            }

        }
        req.setAttribute("userone", dao.user.read(user1.getId()));

        return null;
    }
}
