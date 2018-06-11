package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.KindOfWorkBean;
import by.it.danilevich.project.java.beans.OrderBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;
import by.it.danilevich.project.java.dao.connect.CN;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdListEditOrder extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao=Dao.getInstance();
        List<OrderBean> listOrder= dao.orderDao.getAll("");
    //    List<UserBean> listUser= dao.userDao.getAll("");
        List<UserBean> listClient= dao.userDao.getAll("where `role_id`=3 OR `role_id`=1");
        List<UserBean> listExecutor= dao.userDao.getAll("where `role_id`=2");
        List<KindOfWorkBean> listWork= dao.kindOfWorkDao.getAll("");

        List<String> listStatus = CN.listStatus;
        HttpSession session = req.getSession();
        session.setAttribute("listStatus", listStatus);

        session.setAttribute("listOrder",listOrder);
        session.setAttribute("listWork",listWork);
        session.setAttribute("listExecutor",listExecutor);
        session.setAttribute("listClient",listClient);
        return null;
    }
}
