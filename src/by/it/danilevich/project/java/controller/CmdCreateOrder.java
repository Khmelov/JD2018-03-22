package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.KindOfWorkBean;
import by.it.danilevich.project.java.beans.OrderBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdCreateOrder extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        UserBean user=Util.getUserFromSession(req);
        if (user!=null){
            if (req.getMethod().equalsIgnoreCase("post")){
                List<KindOfWorkBean> listkindOfWork= Dao.getInstance().kindOfWorkDao.getAll("where `id`="+Integer.parseInt(req.getParameter("selectkindofworks")));
                int col =1;
                double timeNorm=0.0;
                if (!req.getParameter("amount").trim().isEmpty()) {
                    col = Integer.parseInt(req.getParameter("amount"));
                }
                double price = 0;
                int idKindOfWork = 0;

                if (listkindOfWork.size()!=0){
                    price = listkindOfWork.get(0).getPrice();
                    idKindOfWork = listkindOfWork.get(0).getId();
                    timeNorm = listkindOfWork.get(0).getTimeNorm();
                }

                double totalMoney =col*timeNorm;
                double totalTime = col*price;
                OrderBean orderBean=new OrderBean();
                orderBean.setAmount(col);
                orderBean.setClientId(user.getId());
                orderBean.setStatus("waiting");
                orderBean.setDateOrder(Util.getCurrentDate());
                orderBean.setKindOfWorkId(idKindOfWork);

                orderBean.setTotalMoney(totalMoney);
                orderBean.setTotalTime(totalTime);
                Dao.getInstance().orderDao.create(orderBean);

            }
            else
                return null;
        }
        return Actions.LOGIN.command;
    }
}
