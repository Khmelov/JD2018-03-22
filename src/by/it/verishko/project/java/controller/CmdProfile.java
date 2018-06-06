package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.beans.Product;
import by.it.verishko.project.java.beans.User;
import by.it.verishko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProfile extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user != null) {
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (req.getParameter("logout") != null)
                    req.getSession().invalidate();
                return Actions.LOGIN.command;
            }
            else {
                DAO dao = DAO.getInstance();
                List<Product> listGoodsUser = dao.product.getAll("WHERE users_id" + user.getId());
                req.getSession().setAttribute("listGoodsUser", listGoodsUser);
            }
            return null;
        }
        return Actions.LOGIN.command;
    }
}
