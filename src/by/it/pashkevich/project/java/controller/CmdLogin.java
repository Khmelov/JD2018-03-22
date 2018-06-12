package by.it.pashkevich.project.java.controller;

import by.it.pashkevich.project.java.beans.User;
import by.it.pashkevich.project.java.dao.DAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd
{
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        User user = Util.getUserFromSession(req);
//        if (user == null) {
//            return Actions.LOGIN.command;
//        }
        if (Util.isPost(req)) {
            String salt = "bla";
            String login = Util.getString(req.getParameter("login"), Pattern.LOGIN);
            String password = Util.getString(req.getParameter("password"), Pattern.PASSWORD);
            String hashpassword = DigestUtils.sha256Hex(password + salt);
            User user;
            DAO dao = DAO.getInstance();
            String where = String.format("WHERE login='%s' AND password='%s' LIMIT 0,1", login, hashpassword);
            List<User> users = dao.user.getAll(where);
            if (users.size() > 0) {
                user = users.get(0);
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                session.setAttribute("userName",user.getLogin());
                session.setMaxInactiveInterval(30);
                return Actions.PROFILE.command;
            }
        }
        return null;
    }
}