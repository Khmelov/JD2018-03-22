package by.it.uskoryaev.project.java.controller;

import by.it.uskoryaev.project.java.beans.User;
import by.it.uskoryaev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdSignUp extends AbstractCmd {
    @Override
    public AbstractCmd execute(HttpServletRequest reg) throws Exception {
        if (reg.getMethod().equalsIgnoreCase("post")){
            if (reg.getParameter("SingUp") != null) {
                String nickName = reg.getParameter("nickName");
                String email = reg.getParameter("email");
                String password = reg.getParameter("password");
                String firstName = reg.getParameter("firstName");
                String lastName = reg.getParameter("lastName");
                String middleName = reg.getParameter("middleName");
                String phoneNumber = reg.getParameter("phoneNumber");
                User user = new User(0, nickName, email, password, firstName, lastName, middleName,phoneNumber, 2);
                DAO dao = DAO.getInstanceDao();
                dao.user.create(user);
                return Action.LOGIN.command;
            }
        }
        return null;
    }
}
