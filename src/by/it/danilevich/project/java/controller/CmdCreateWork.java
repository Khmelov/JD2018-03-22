package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.KindOfWorkBean;
import by.it.danilevich.project.java.beans.OrderBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdCreateWork extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        UserBean user=Util.getUserFromSession(req);
        if (user!=null){
            if (req.getMethod().equalsIgnoreCase("post")){


                KindOfWorkBean kindOfWorkBean=new KindOfWorkBean();
                kindOfWorkBean.setName(req.getParameter("name"));
                kindOfWorkBean.setPrice(Double.parseDouble(req.getParameter("price")));
                kindOfWorkBean.setCategory(req.getParameter("category"));
                kindOfWorkBean.setTimeNorm(Double.parseDouble(req.getParameter("timenorm")));
                kindOfWorkBean.setUnit(req.getParameter("unit"));

                Dao.getInstance().kindOfWorkDao.create(kindOfWorkBean);

            }
            else
                return null;
        }
        else{
            return Actions.LOGIN.command;
        }
        return Actions.LISTWORK.command;
    }
}
