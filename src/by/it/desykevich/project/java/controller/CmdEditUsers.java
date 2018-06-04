package by.it.desykevich.project.java.controller;

import by.it.desykevich.project.java.beans.Role;
import by.it.desykevich.project.java.beans.User;
import by.it.desykevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditUsers extends CmdAbstract {
    @Override
    CmdAbstract execute(HttpServletRequest req) throws Exception {

        if (FormUtil.isPost(req)) {
            int id = FormUtil.getInt(req, "ID");
            String login = FormUtil.getString(req, "Login", Patterns.LOGIN);
            String email = FormUtil.getString(req, "Email", Patterns.EMAIL);
            String password = FormUtil.getString(req, "Password", Patterns.PASSWORD);
            String nickname = FormUtil.getString(req, "Nickname", Patterns.NICKNAME);
            String phonenumber = FormUtil.getString(req, "PhoneNumber", Patterns.PHONENUMBER);
            int roles_ID = FormUtil.getInt(req, "roles_ID");
            User user = new User(id, login, email, password, nickname, phonenumber, roles_ID);
            if (req.getParameter("Update") != null) {
                DAO.getInstanse().userDAO.update(user);
            } else if (req.getParameter("Delete") != null) {
                DAO.getInstanse().userDAO.delete(user);
            }
        }
        List<User> users = DAO.getInstanse().userDAO.getAll("");
        List<Role> roles = DAO.getInstanse().roleDAO.getAll("");
        req.setAttribute("users", users);
        req.setAttribute("roles", roles);
        return null;
    }
}
