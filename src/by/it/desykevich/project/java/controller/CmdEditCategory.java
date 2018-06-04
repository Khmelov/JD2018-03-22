package by.it.desykevich.project.java.controller;

import by.it.desykevich.project.java.beans.Category;
import by.it.desykevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdEditCategory extends CmdAbstract {

    @Override
    CmdAbstract execute(HttpServletRequest req) throws Exception {
        if (FormUtil.isPost(req)) {
            Category category = new Category(FormUtil.getInt(req, "ID"),
                    FormUtil.getString(req, "Name", ".+"));
            if (req.getParameter("Update") != null) {
                DAO.getInstanse().categoryDAO.update(category);
            } else if (req.getParameter("Delete") != null) {
                DAO.getInstanse().categoryDAO.delete(category);
            }
        }
        List<Category> categories = DAO.getInstanse().categoryDAO.getAll("");
        req.setAttribute("categories", categories);
        return null;
    }
}
