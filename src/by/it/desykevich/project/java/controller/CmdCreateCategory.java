package by.it.desykevich.project.java.controller;

import by.it.desykevich.project.java.beans.Category;
import by.it.desykevich.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateCategory extends CmdAbstract {

    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        if (!FormUtil.isPost(req)) {
            return null;
        }
        Category category = new Category(0, FormUtil.getString(req,"name",".+"));
        DAO.getInstanse().categoryDAO.create(category);
        req.setAttribute(Msg.MESSAGE, "Category created");
        return null;
    }
}
