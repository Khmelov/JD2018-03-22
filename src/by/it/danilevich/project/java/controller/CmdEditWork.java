package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.KindOfWorkBean;
import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;

import javax.servlet.http.HttpServletRequest;

public class CmdEditWork extends Cmd {

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
            String category = req.getParameter("category");
            String unit = req.getParameter("unit");
            Double price = Double.parseDouble(req.getParameter("price"));
            Double timeNorm = Double.parseDouble(req.getParameter("timenorm"));
            KindOfWorkBean kindOfWorkBean = new KindOfWorkBean(id,name, price, timeNorm, category, unit);
            if (req.getParameter("Update") != null)
                dao.kindOfWorkDao.update(kindOfWorkBean);
            else if (req.getParameter("Delete") != null)
                dao.kindOfWorkDao.delete(kindOfWorkBean);

            //do somthing
        }
        req.setAttribute("listWork", dao.kindOfWorkDao.getAll(""));
        return Actions.LISTWORK.command;
    }
}
