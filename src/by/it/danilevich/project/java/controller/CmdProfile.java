package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.KindOfWorkBean;
import by.it.danilevich.project.java.beans.OrderBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;
import by.it.danilevich.project.java.dao.connect.CN;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        UserBean userBean = Util.getUserFromSession(req);
        if (userBean != null) {
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (req.getParameter("logout") != null)
                    req.getSession().invalidate();
                return Actions.LOGIN.command;
            }
            else {
                Dao dao = Dao.getInstance();
                List<OrderBean> listOrdersUser = dao.orderDao.getAll("where `client_id`=" + userBean.getId());
                List<KindOfWorkBean> listkindOfWork = dao.kindOfWorkDao.getAll("");
                List<UserBean> listExecutor= dao.userDao.getAll("where `role_id`=2");

                req.getSession().setAttribute("listOrder",listOrdersUser);
                req.getSession().setAttribute("listWork",listkindOfWork);
                req.getSession().setAttribute("listCategory", CN.listCategory);
                req.getSession().setAttribute("listUnit", CN.listUnit);
                req.getSession().setAttribute("listStatus", CN.listStatus);
                            req.getSession().setAttribute("listExecutor", listExecutor);
            }
            return null;
        }
        return Actions.LOGIN.command;
    }
}
