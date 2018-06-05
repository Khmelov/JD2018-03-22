package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.beans.Product;
import by.it.verishko.project.java.beans.User;
import by.it.verishko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdProfile extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest reg) throws Exception {
        User user = Util.getUserFormSession(reg);
        if (user != null) {
            if (reg.getMethod().equalsIgnoreCase("post")) {
                if (reg.getParameter("logout") != null)
                    reg.getSession().invalidate();
                return Actions.LOGIN.command;
            } else {
                DAO dao = DAO.getInstance();
                List<Product> listGoodsUser = dao.product.getAll("WHERE users_id" + user.getId());
                reg.getSession().setAttribute("listGoodsUser", listGoodsUser);
            }
            return null;
        }
        return Actions.LOGIN.command;
    }
}