package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.beans.UserBean;
import by.it.danilevich.project.java.dao.Dao;
import by.it.danilevich.project.java.dao.connect.CN;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdListEditWork extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        Dao dao=Dao.getInstance();
        req.setAttribute("listWork", dao.kindOfWorkDao.getAll(""));
        req.setAttribute("listCategory", CN.listCategory);
        req.setAttribute("listUnit", CN.listUnit);

        return null;
    }
}
