package by.it.pashkevich.project.java.controller;

import by.it.pashkevich.project.java.beans.Product;
import by.it.pashkevich.project.java.beans.User;
import by.it.pashkevich.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class CmdEditProduct extends Cmd
{
    @Override
    Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null) {
            if (Util.isPost(req)) {
                if (req.getParameter("Update") != null || req.getParameter("Delete") != null) {
                    DAO dao = DAO.getInstance();
                    int id = Integer.parseInt(req.getParameter("id"));
                    Product ourProduct = dao.product.read(id);
                    String name = req.getParameter("name");
                    String description = req.getParameter("description");
                    double price = Double.parseDouble(req.getParameter("price"));
                    int users_id = ourProduct.getUsers_id();
                    Product editProduct = new Product(id, name, description, price, users_id);
                    if (req.getParameter("Update") != null) {
                        dao.product.update(editProduct);
                        return Actions.EDITPRODUCT.command;
                    } else if (req.getParameter("Delete") != null) {
                        dao.product.delete(editProduct);
                        return Actions.EDITPRODUCT.command;
                    }
                }
            } else {
                String login = user.getLogin();
                String pass = user.getPassword();
                Cookie cookie = new Cookie(login, pass);
                cookie.setMaxAge(60);
                resp.addCookie(cookie);
                List<Product> listGoods = DAO.getInstance().product.getAll("");
                req.getSession().setAttribute("listGoods", listGoods);
            }
            return null;
        }
        return Actions.LOGIN.command;
    }
}