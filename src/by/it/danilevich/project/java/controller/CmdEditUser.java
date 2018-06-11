package by.it.danilevich.project.java.controller;

//import by.it.danilevich.project.java.beans.OrderBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdEditUser extends Cmd {

    public Cmd execute(HttpServletRequest req) throws Exception {
        UserBean user = Util.getUserFromSession(req);
        if (user == null)
            return Actions.LOGIN.command;
        if (user.getRoleId() != 1)
            return Actions.PROFILE.command;

        Dao dao = Dao.getInstance();
        if (req.getMethod().equalsIgnoreCase("post")) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String address = req.getParameter("address");
            int roleId = Integer.parseInt(req.getParameter("roleId"));
            String telephone = req.getParameter("telephone");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            UserBean userBean = new UserBean(id, name,roleId, address, telephone, login,password);
            if (req.getParameter("Update") != null)
                dao.userDao.update(userBean);
            else if (req.getParameter("Delete") != null)
                dao.userDao.delete(userBean);

            //do somthing
        }
        req.setAttribute("listWork", dao.kindOfWorkDao.getAll(""));
        return Actions.LISTUSER.command;
    }
}
