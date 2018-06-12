package by.it.poprugo.project.java.controller;

import by.it.poprugo.project.java.beans.Model;
import by.it.poprugo.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        List<Model> ads = DAO.getInstance().model.getAll("");
        req.setAttribute("ads",ads);
        return null;
    }
}
