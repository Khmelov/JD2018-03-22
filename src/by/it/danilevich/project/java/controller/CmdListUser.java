package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.OrderBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdListUser extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao=Dao.getInstance();
        List<UserBean> listOrder= dao.userDao.getAll("");
        req.setAttribute("listUser",listOrder);
        return null;
    }
}
