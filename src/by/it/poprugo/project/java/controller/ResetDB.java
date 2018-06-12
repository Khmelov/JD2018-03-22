package by.it.poprugo.project.java.controller;

import by.it.poprugo.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class ResetDB extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        DAO dao=DAO.getInstance();
        //System.out.println("Are You sure?");
        dao.reset();
        req.getSession().invalidate();
        return Actions.INDEX.command;
    }
}
