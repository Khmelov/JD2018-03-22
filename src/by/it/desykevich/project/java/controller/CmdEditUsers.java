package by.it.desykevich.project.java.controller;


import by.it.desykevich.project.java.beans.User;
import by.it.desykevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;


public class CmdEditUsers extends CmdAbstract {

//    @Override
//    CmdAbstract execute(HttpServletRequest req) throws Exception {
//
//        if (FormUtil.isPost(req)) {
//            int id = FormUtil.getInt(req, "ID");
//            String login = FormUtil.getString(req, "login", Patterns.LOGIN);
//            String password = FormUtil.getString(req, "password", Patterns.PASSWORD);
//            String email = FormUtil.getString(req, "email", Patterns.EMAIL);
//            String nickname = FormUtil.getString(req, "nickname", Patterns.NICKNAME);
//            String phonenumber = FormUtil.getString(req, "phonenumber", Patterns.PHONENUMBER);
//            int roles_id = FormUtil.getInt(req, "roles_id");
//            User user = new User(id, login, password, email, nickname, phonenumber, roles_id);
//            if (req.getParameter("Update") != null) {
//                DAO.getInstanse().userDAO.update(user);
//            } else if (req.getParameter("Delete") != null) {
//                DAO.getInstanse().userDAO.delete(user);
//            }
//        }
//
//        req.setAttribute("users", DAO.getInstanse().userDAO.getAll(""));
//        req.setAttribute("roles", DAO.getInstanse().roleDAO.getAll(""));
//        return null;
//    }

    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user == null)
            return Actions.LOGIN.command;
        if (user.getRoles_id() != 1)
            return Actions.PROFILE.command;

        DAO dao = DAO.getInstanse();
        if (req.getMethod().equalsIgnoreCase("post")) {
            int id = Integer.parseInt(req.getParameter("ID"));
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String nickname = req.getParameter("nickname");
            String phonenumber = req.getParameter("phonenumber");
            int roles_id = Integer.parseInt(req.getParameter("roles_id"));

            User editUser = new User(id, login, password, email, nickname, phonenumber, roles_id);
            if (req.getParameter("Update") != null)
                dao.userDAO.update(editUser);
            else if (req.getParameter("Delete") != null)
                dao.userDAO.delete(editUser);

            //do somthing
        }
        req.setAttribute("users", dao.userDAO.getAll(""));
        req.setAttribute("roles", dao.roleDAO.getAll("")); //to context servlet
        return null;
    }
}
