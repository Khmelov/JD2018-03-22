package by.it.kirova.project.java.controller;


import by.it.kirova.project.java.beans.User;
import by.it.kirova.project.java.dao.DAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CmdAdmin extends Cmd {
    @Override
    public Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User user = Util.getUserFromSession(req);
        if (user == null)
            return Actions.LOGIN.command;
        if (user.getRole_role_id() != 1)
            return Actions.MYACCOUNT.command;

        DAO dao = DAO.getInstanceDAO();
        if (req.getMethod().equalsIgnoreCase("post")) {
            String salt = "randomstring"; // генерация разной соли в классе SaltRandom
            int id = Integer.parseInt(req.getParameter("user_id"));
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String firstname = req.getParameter("first_name");
            String lastname = req.getParameter("last_name");
            String middlename = req.getParameter("middle_name");
            String residencecountry = req.getParameter("residence_country");
            String phonenumber = req.getParameter("phone_number");
            int roleid = Integer.parseInt(req.getParameter("role_id"));
            String hashpass = DigestUtils.sha256Hex(password + salt);
            User editUser = new User(id, hashpass, email, firstname, lastname, middlename, residencecountry, phonenumber,
                    roleid);
            if (req.getParameter("Update") != null)

                dao.user.update(editUser);
            else if (req.getParameter("Delete") != null)
                dao.user.delete(editUser);


        }
        req.setAttribute("users", dao.user.getAll(""));
        req.setAttribute("roles", dao.role.getAll("")); //to context servlet
        return null;
    }

}
