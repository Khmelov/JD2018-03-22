package by.it.uskoryaev.project.java.controller;

import by.it.uskoryaev.project.java.beans.User;
import by.it.uskoryaev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdLogin extends AbstractCmd {
    @Override
    public CmdLogin execute(HttpServletRequest reg) throws Exception {
        if (reg.getMethod().equalsIgnoreCase("post")) {
            String nickName = reg.getParameter("nickName");
            String email = reg.getParameter("email");
            String password = reg.getParameter("password");
            User user = new User(0, nickName, email, password,2);
            DAO dao = DAO.getInstanceDao();
            dao.user.create(user);
        }
        return null;
    }
}
