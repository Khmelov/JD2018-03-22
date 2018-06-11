package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.OrderBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdEditOrder extends Cmd {

    public Cmd execute(HttpServletRequest req) throws Exception {
        UserBean user = Util.getUserFromSession(req);
        if (user == null)
            return Actions.LOGIN.command;
        if (user.getRoleId() != 1)
            return Actions.PROFILE.command;

        Dao dao = Dao.getInstance();
        if (req.getMethod().equalsIgnoreCase("post")) {
            int id = Integer.parseInt(req.getParameter("id"));
            int clientId = Integer.parseInt(req.getParameter("clientId"));
            Long data = Long.parseLong(req.getParameter("data"));
            int workId = Integer.parseInt(req.getParameter("workId"));
            int executorId = Integer.parseInt(req.getParameter("executorId"));
            double totalMoney = Double.parseDouble(req.getParameter("totalMoney"));
            String status = req.getParameter("status");
            OrderBean orderBean = new OrderBean(id,data, clientId, workId, executorId, 1,1,totalMoney,0,status);
            if (req.getParameter("Update") != null)
                dao.orderDao.update(orderBean);
            else if (req.getParameter("Delete") != null)
                dao.orderDao.delete(orderBean);

            //do somthing
        }
        req.setAttribute("listWork", dao.kindOfWorkDao.getAll(""));
        return Actions.LISTEDITORDER.command;
    }
}
