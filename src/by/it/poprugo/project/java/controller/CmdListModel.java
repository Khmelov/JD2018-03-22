package by.it.poprugo.project.java.controller;

import by.it.poprugo.project.java.beans.Model;
import by.it.poprugo.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdListModel extends Cmd {
    @Override
    Cmd execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstance();
        List<Model> listModel = dao.model.getAll("");
        req.setAttribute("listModel", listModel);
        return null;
    }
}
