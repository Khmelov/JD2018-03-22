package by.it.kirova.project.java.controller;


import javax.servlet.http.HttpServletRequest;

public class CmdMyAccount extends CmdAbstract{




    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
//        if (req.getMethod().equalsIgnoreCase("post")) {
//            String email = req.getParameter("email");
//            String password = req.getParameter("password");
//            String first_name = req.getParameter("firstname");
//            String last_name = req.getParameter("lastname");
//            String middle_name = req.getParameter("middlename");
//            String residence_country = req.getParameter("residencecountry");
//            String phone_number = req.getParameter("phonenumber");
//            User user = new User(0, email, password, first_name, last_name, middle_name,
//                    residence_country, phone_number, 2);
//            DAO dao = DAO.getInstanceDAO();
//            dao.user.update(user);
//            return Actions.MYACCOUNT.command;
//        }
        return null;
    }

}
