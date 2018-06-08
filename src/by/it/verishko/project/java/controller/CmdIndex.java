package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.beans.Product;
import by.it.verishko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdIndex extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Product> goods = DAO.getInstance().product.getAll("");
        req.setAttribute("goods",goods);
        return null;
    }
}
