package by.it.desykevich.project.java.controller;



import by.it.desykevich.project.java.beans.User;
import by.it.desykevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdLogin extends CmdAbstract {

//    @Override
//    public CmdAbstract execute(HttpServletRequest reg) throws Exception {
//        if (reg.getMethod().equalsIgnoreCase("post")){
//            String login=reg.getParameter("login");
//            String password=reg.getParameter("password");
//            User user=new User(0,login,password,"","","",2);
//            DAO dao = DAO.getInstanse();
//            String where=String.format("WHERE login='%s' AND password='%s'",login,password);
//            if (dao.userDAO.getAll(where).size()>0){
//                return Actions.CREATEAD.command;
//            }
//        }
//        return null;
//    }
//
//    public static void main(String[] args) throws SQLException {
//        DAO dao = DAO.getInstanse();
//        String where=String.format("WHERE login='%s' AND password='%s'","TestLogintype","TestPassword");
//        if (dao.userDAO.getAll(where).size()==1){
//            System.out.println("ok");
//        }
//    }

    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req))
            return null;
        String login =
                FormUtil.getString(req, "login", Patterns.LOGIN);
        String password =
                FormUtil.getString(req, "password", Patterns.PASSWORD);
        DAO dao = DAO.getInstanse();
        List<User> list = dao.userDAO.getAll(" where login='" + login + "' and password='" + password + "'");
        if (list.size() > 0) {
            req.setAttribute(Msg.MESSAGE, "user " + login + " exists.");
            HttpSession session = req.getSession();
            session.setAttribute("user", list.get(0));
            return Actions.INDEX.command;
        } else
            req.setAttribute(Msg.MESSAGE, "check inputs");

        req.setAttribute(Msg.MESSAGE, "user " + login + " not exists.");
        return Actions.LOGIN.command;
    }
}
