package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.KindOfWorkBean;
import by.it.danilevich.project.java.beans.OrderBean;
import by.it.danilevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao = Dao.getInstance();
        List<OrderBean> listOrdersUser = dao.orderDao.getAll("");
        List<KindOfWorkBean> listkindOfWork = dao.kindOfWorkDao.getAll("");

        req.getSession().setAttribute("listOrder",listOrdersUser);
        req.getSession().setAttribute("kindOfWorks",listkindOfWork);


        return null;
    }
}
