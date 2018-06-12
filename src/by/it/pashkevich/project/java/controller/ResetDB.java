package by.it.pashkevich.project.java.controller;

import by.it.pashkevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResetDB extends Cmd
{
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        DAO dao = DAO.getInstance();
        dao.reset();
        req.getSession().invalidate();
        return Actions.INDEX.command;
    }
}
