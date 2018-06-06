package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")){
            String login= req.getParameter("login");
            String name= req.getParameter("name");
            String password= req.getParameter("password");
            String address= req.getParameter("address");
            String telephone= req.getParameter("telephone");
            UserBean user=new UserBean(0,name,1,address,telephone,login,password);
            Dao dao = Dao.getInstance();
            dao.userDao.create(user);
            return Actions.LOGIN.command;
        }
        return null;
    }
}
