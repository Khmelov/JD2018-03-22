package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.beans.User;
import by.it.verishko.project.java.dao.DAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        User user = Util.getUserFromCookie(req);
//        if (user == null) {
//            return Actions.LOGIN.command;
//        }
        if (Util.isPost(req)) {
            String salt = "bla";
            String login = Util.getString(req.getParameter("login"), Pattern.LOGIN);
            String email = Util.getString(req.getParameter("email"), Pattern.EMAIL);
            String password = Util.getString(req.getParameter("password"), Pattern.PASSWORD);
            String hashpassword = DigestUtils.sha256Hex(password + salt);
            User user = new User(0, login, hashpassword, email, 2);
            DAO dao = DAO.getInstance();
            dao.user.create(user);
            return Actions.LOGIN.command;
        }
//        return Actions.LISTGOODS.command;
        return null;

    }
}
