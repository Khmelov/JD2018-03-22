package by.it.kirova.project.java.controller;

import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.DAO;

import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            if (req.getParameter("loginbutton") != null) {
                String salt = "randomstring"; // генерация разной соли в классе SaltRandom
                //String salt = SaltRandom.getSaltString();
                String email = req.getParameter("email");
                String password = req.getParameter("password");
                if (Parser.validator(email, "email") ||
                    Parser.validator(password, "password")) {
                    return null;
                }
                User user;
                DAO dao = DAO.getInstanceDAO();
                String hashpass = DigestUtils.sha256Hex(password + salt);
                String where = String.format("WHERE email='%s' AND password='%s' LIMIT 0,1", email, hashpass);
                List<User> users = dao.user.getAll(where);
                if (users.size() > 0) {
                    user = users.get(0);
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);
                    session.setMaxInactiveInterval(120);
                    return Actions.INDEX.command;
                }
            }

        }
        return null;

    }
}
