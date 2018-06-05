package by.it.verishko.project.java.controller;

import by.it.verishko.project.java.beans.Product;
import by.it.verishko.project.java.beans.User;
import by.it.verishko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdCreateProduct extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest reg) throws Exception {
        User user = Util.getUserFormSession(reg);
        if (user != null) {
            if (reg.getMethod().equalsIgnoreCase("post")) {
                String name = reg.getParameter("name");
                String description = reg.getParameter("description");
                double price = Double.parseDouble(reg.getParameter("price"));
                Product product = new Product(0, name, description, price, 2);
                DAO dao = DAO.getInstance();
                dao.product.create(product);
            } else return null;
        }
        return Actions.LOGIN.command;

//        if (reg.getMethod().equalsIgnoreCase("post")) {
//            String name = reg.getParameter("name");
//            String description = reg.getParameter("description");
//            double price = Double.parseDouble(reg.getParameter("price"));
//
//            Product product = new Product(0, name, description, price, 2);
//            DAO dao = DAO.getInstance();
//            dao.product.create(product);
//            return Actions.LOGINPAGE.command;
//        }
//        return null;
    }
}
