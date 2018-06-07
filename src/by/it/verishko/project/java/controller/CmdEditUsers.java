package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.beans.User;
import by.it.verishko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdEditUsers extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user == null)
            return Actions.LOGIN.command;
        if (user.getRoles_id() != 1)
            return Actions.PROFILE.command;
        DAO dao = DAO.getInstance();

        if (Util.isPost(req)) {
            int id = Integer.parseInt(req.getParameter("id"));
//            String login = Util.getString(req.getParameter("login"), Pattern.LOGIN);
//            String email = Util.getString(req.getParameter("email"), Pattern.EMAIL);
//            String password = Util.getString(req.getParameter("password"), Pattern.PASSWORD);


//            User edtitUser = new User(id, login, password, email, roles_id);
//            if (req.getParameter("Update") != null)
//                dao.user.update(editUser);
//            else if (req.getParameter("Delete") != null)
//                dao.user.delete(editUser);


//            do smt
        }
//        DAO dao = DAO.getInstance();
        req.setAttribute("users", dao.user.getAll(""));
        req.setAttribute("roles", dao.user.getAll(""));
        return null;


//        String login = Util.getString(req.getParameter("login"), Pattern.LOGIN);
//        String password = Util.getString(req.getParameter("password"), Pattern.PASSWORD);
//        User user;
//        DAO dao = DAO.getInstance();
//        String where = String.format("WHERE login='%s' AND password='%s' LIMIT 0,1", login, password);
//        List<User> users = dao.user.getAll(where);
//        if (users.size() > 0) {
//            user = users.get(0);
//            HttpSession session = req.getSession();
//            session.setAttribute("user", user);
//            session.setAttribute("userName", user.getLogin());
//            session.setMaxInactiveInterval(30);
//            return Actions.LISTGOODS.command;
////                return Actions.PROFILE.command;
//        }
//    }
//        return null;
//        return Actions.LOGIN.command;
    }
}