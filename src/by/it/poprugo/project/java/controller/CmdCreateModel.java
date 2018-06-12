package by.it.poprugo.project.java.controller;

import by.it.poprugo.project.java.beans.Model;
import by.it.poprugo.project.java.beans.User;
import by.it.poprugo.project.java.controller.Cmd;
import by.it.poprugo.project.java.controller.Util;
import by.it.poprugo.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateModel extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user!=null){
            if (req.getMethod().equalsIgnoreCase("post")){
                Model model = new Model();
                model.setModel(req.getParameter("model"));
                model.setName(req.getParameter("name"));
                model.setAddress(req.getParameter("address"));
                model.setPhone(req.getParameter("phone"));
                model.setNumber(req.getParameter("number"));
                model.setDatacontr(req.getParameter("datacontr"));
                model.setPrice(Integer.parseInt(req.getParameter("price")));
                model.setKeymoney(Integer.parseInt(req.getParameter("keymoney")));
                model.setUsers_id(user.getId());
                DAO.getInstance().model.create(model);
            }
            else
                return null;
        }
        return Actions.LOGIN.command;
    }
}