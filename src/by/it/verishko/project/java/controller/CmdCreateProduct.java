package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.beans.Product;
import by.it.verishko.project.java.beans.User;
import by.it.verishko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdCreateProduct extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null) {
            if (Util.isPost(req)) {
                Product product = new Product();
                product.setName(req.getParameter("name"));
                product.setDescription(req.getParameter("description"));
                product.setPrice(Double.parseDouble(req.getParameter("price")));
                product.setUsers_id((int) user.getId());
                DAO.getInstance().product.create(product);
            } else return null;
        }
        return Actions.PROFILE .command;
    }
}
