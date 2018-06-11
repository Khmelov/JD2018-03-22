package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.RoleBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdListEditUser extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao=Dao.getInstance();
        List<UserBean> listUser= dao.userDao.getAll("");
        List<RoleBean> listRole= dao.roleDao.getAll("");

        HttpSession session = req.getSession();
        session.setAttribute("listUser", listUser);

        session.setAttribute("listRole",listRole);
        return null;
    }
}
