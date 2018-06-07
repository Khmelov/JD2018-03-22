package by.it.kirova.project.java.controller;

import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdLogin extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest reg) throws Exception {
        if (reg.getMethod().equalsIgnoreCase("post")){
            String email=reg.getParameter("email");
            String password=reg.getParameter("password");
            String first_name=reg.getParameter("first_name");
            String last_name=reg.getParameter("last_name");
            String middle_name=reg.getParameter("middle_name");
            String residence_country=reg.getParameter("residence_country");
            String phone_number=reg.getParameter("phone_number");
            User user=new User(0, email, password, first_name,last_name, middle_name,
                    residence_country, phone_number, 2);
            DAO dao = DAO.getInstanceDAO();
            String where=String.format("WHERE email='%s' AND password='%s'",email,password);
            if (dao.user.getAll(where).size()>0){
                return Actions.INDEX.command;
            }
            return Actions.LOGIN.command;
        }
        return null;
    }

}
