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
            int id = FormUtil.getInt(req, "id");
            String login = FormUtil.getString(req, "login", Patterns.LOGIN);
            String password = FormUtil.getString(req, "password", Patterns.PASSWORD);
            String email = FormUtil.getString(req, "email", Patterns.EMAIL);
            String nickname = FormUtil.getString(req, "nickname", Patterns.NICKNAME);
            String phonenumber = FormUtil.getString(req, "phonenumber", Patterns.PHONENUMBER);
            int roles_id = FormUtil.getInt(req, "roles_id");
            User user = new User(id, login,password, email, nickname, phonenumber, roles_id);
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
