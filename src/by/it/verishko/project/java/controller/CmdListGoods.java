package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.beans.Product;
import by.it.verishko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdListGoods extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        DAO dao = DAO.getInstance();
        List<Product> listGoods = dao.product.getAll("");
        req.setAttribute("listGoods", listGoods);
        return null;
    }
}
