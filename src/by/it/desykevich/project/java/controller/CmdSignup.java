package by.it.desykevich.project.java.controller;



import by.it.desykevich.project.java.beans.User;
import by.it.desykevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest reg) throws Exception {

        if (reg.getMethod().equalsIgnoreCase("post")) {
            String  login=reg.getParameter("login");
            String  email=reg.getParameter("email");
            String  password=reg.getParameter("password");
            String  nickname=reg.getParameter("nickname");
            String  phonenumber=reg.getParameter("phonenumber");
            User user=new User(0,login,password,email,nickname,phonenumber,2);
            DAO dao = DAO.getInstanse();
            dao.userDAO.create(user);
            return Actions.LOGIN.command;
        }
        return null;
    }
}
