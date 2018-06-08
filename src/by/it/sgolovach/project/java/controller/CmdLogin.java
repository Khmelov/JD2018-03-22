package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;
import by.it.sgolovach.project.java.pattern.Parser;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends CmdAbstract {


    @Override
    public CmdAbstract execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String salt = "random";
            Parser parser = new Parser();
            boolean log, pass;
            String login = req.getParameter("login");
            log = parser.regEx(login, "login");
            String password = req.getParameter("password");
            pass = parser.regEx(password, "pass");
            if (log && pass) {
                String hashpassword = DigestUtils.sha256Hex(password + salt);
                User user;
                DAO dao = DAO.getInstance();
                String where = String.format("WHERE login='%s' AND password='%s'", login, hashpassword);
                List<User> users = dao.user.getAll(where);
                if (users.size() > 0) {
                    user = users.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);
                    session.setAttribute("userName",user.getLogin());
                    session.setAttribute("userRole_id",user.getRoles_id());
                    session.setMaxInactiveInterval(120);
                    return Action.PROFILE.comand;
                }
            }
            return Action.LOGIN.comand;
        }
        return null;
    }
}
