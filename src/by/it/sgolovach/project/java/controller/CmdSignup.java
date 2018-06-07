package by.it.sgolovach.project.java.controller;

import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;
import by.it.sgolovach.project.java.pattern.CheckLog;
import by.it.sgolovach.project.java.pattern.Parser;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignup extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String salt = "random";
            Parser parser = new Parser();
            boolean log, ema, pass, uniqLogin;
            String login = req.getParameter("login");
            log = parser.regEx(login, "login");
            uniqLogin = CheckLog.checkLogin(login);
            String email = req.getParameter("email");
            ema = parser.regEx(email, "email");
            String password = req.getParameter("password");
            pass = parser.regEx(password, "pass");
            if (log && ema && pass && !uniqLogin) {
                String hashpassword = DigestUtils.sha256Hex(password + salt);
                User user = new User(0, login, hashpassword, email, 2);
                DAO dao = DAO.getInstance();
                dao.user.create(user);
                return Action.LOGIN.comand;
            }
            return Action.SIGNUP.comand;

        }
        return null;
    }

//    public static void main(String[] args) {
//
//        String pass = "admin";
//        String pass1 = "User";
//        String salt = "random";
//        String hash = DigestUtils.sha256Hex(pass + salt);
//        String hash1 = DigestUtils.sha256Hex(pass1 + salt);
//        System.out.println(hash);
//        System.out.println(hash1);
//    }
}
