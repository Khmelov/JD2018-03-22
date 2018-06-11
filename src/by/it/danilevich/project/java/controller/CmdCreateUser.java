package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateUser extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        UserBean user=Util.getUserFromSession(req);
        if (user!=null){
            if (req.getMethod().equalsIgnoreCase("post")){


                UserBean userBean=new UserBean();
                userBean.setName(req.getParameter("name"));
                userBean.setAddress(req.getParameter("address"));
                userBean.setTelephone(req.getParameter("telephone"));
                userBean.setRoleId(Integer.parseInt(req.getParameter("roleId")));
                userBean.setLogin(req.getParameter("login"));
                userBean.setPassword(req.getParameter("password"));

                Dao.getInstance().userDao.create(userBean);

            }
            else
                return null;
        }
        else{
            return Actions.LOGIN.command;
        }
        return Actions.LISTUSER.command;
    }
}
