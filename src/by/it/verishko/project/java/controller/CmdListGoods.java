package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdListGoods extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest reg) throws Exception {
        DAO dao = DAO.getInstance();
        return null;
    }
}
