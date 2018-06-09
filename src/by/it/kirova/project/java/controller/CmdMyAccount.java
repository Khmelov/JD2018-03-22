package by.it.kirova.project.java.controller;


import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdMyAccount extends Cmd {


    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user == null)
            return Actions.LOGIN.command;
        if (user != null) {
            req.setAttribute("email", user.getEmail());
            req.setAttribute("password", user.getPassword());
            req.setAttribute("firstname", user.getFirst_name());
            req.setAttribute("lastname", user.getLast_name());
            req.setAttribute("middlename", user.getMiddle_name());
            req.setAttribute("residencecountry", user.getResidence_country());
            req.setAttribute("phonenumber", user.getPhone_number());
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (req.getParameter("saveinfo") != null) {
                    String email = req.getParameter("email");
                    String password = req.getParameter("password");
                    String first_name = req.getParameter("firstname");
                    String last_name = req.getParameter("lastname");
                    String middle_name = req.getParameter("middlename");
                    String residence_country = req.getParameter("residencecountry");
                    String phone_number = req.getParameter("phonenumber");
                    if (Parser.validator(email, "email") || Parser.validator(password, "password") ||
                            Parser.validator(first_name, "firstname") ||
                            Parser.validator(middle_name, "middlename") ||
                            Parser.validator(last_name, "lastname") ||
                            Parser.validator(residence_country, "residencecountry") ||
                            Parser.validator(phone_number, "phonenumber")) {
                        return null;
                    }
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setFirst_name(first_name);
                    user.setLast_name(last_name);
                    user.setMiddle_name(middle_name);
                    user.setResidence_country(residence_country);
                    user.setPhone_number(phone_number);
                    DAO dao = DAO.getInstanceDAO();
                    dao.user.update(user);
                    return Actions.MYACCOUNT.command;
                }
                if (req.getParameter("logout") != null) {
                    req.getSession().invalidate();
                    return Actions.LOGIN.command;
                }
                if (req.getParameter("deletemyaccount") != null) {
                    DAO dao = DAO.getInstanceDAO();
                    dao.user.delete(user);
                    req.getSession().invalidate();
                    return Actions.LOGIN.command;
                }

            }

        }
        return null;

    }
}
