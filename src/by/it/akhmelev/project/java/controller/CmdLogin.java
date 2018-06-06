package by.it.akhmelev.project.java.controller;

import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

public class CmdLogin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")){
            String login=req.getParameter("login");
            String password=req.getParameter("password");
            User user=new User(0,login,password,"",2);
            DAO dao = DAO.getInstance();
            String where=String.format("WHERE login='%s' AND password='%s' LIMIT 0,1",login,password);
            List<User> users = dao.user.getAll(where);
            if (users.size()>0){
                user=users.get(0);
                HttpSession session = req.getSession();
                session.setAttribute("user",user);
                return Actions.PROFILE.command;
            }
        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        String where=String.format("WHERE login='%s' AND password='%s'","TestLogin","TestPassword");
        if (dao.user.getAll(where).size()==1){
            System.out.println("ok");
        }
    }
}
