package by.it.kirova.project.java.controller;

import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.DAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CmdSignup extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String first_name = req.getParameter("firstname");
            String last_name = req.getParameter("lastname");
            String middle_name = req.getParameter("middlename");
            String residence_country = req.getParameter("residencecountry");
            String phone_number = req.getParameter("phonenumber");
            if (Parser.validator(email, "email") ||
                    Parser.validator(password, "password") ||
                    Parser.validator(first_name, "firstname") ||
                    Parser.validator(middle_name, "middlename") ||
                    Parser.validator(last_name, "lastname") ||
                    Parser.validator(residence_country, "residencecountry") ||
                    Parser.validator(phone_number, "phonenumber")) {
                return null;
            } else {
                String salt = "randomstring"; // генерация разной соли в классе SaltRandom
                String hashpass = DigestUtils.sha256Hex(password + salt);
                User user = new User(0, email, hashpass, first_name, last_name, middle_name,
                        residence_country, phone_number, 2);
                DAO dao = DAO.getInstanceDAO();
                dao.user.create(user);
                return Actions.LOGIN.command;
            }
        }
        return null;
    }
}
