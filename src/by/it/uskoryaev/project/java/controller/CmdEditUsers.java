package by.it.uskoryaev.project.java.controller;

import by.it.uskoryaev.project.java.beans.User;
import by.it.uskoryaev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdEditUsers extends AbstractCmd {
    @Override
    public AbstractCmd execute(HttpServletRequest req) throws Exception {
        User user = Util.getUserFormSession(req);
        if (user == null) return Action.LOGIN.command;
        if (user.getBase_face_id() != 3) {
            DAO dao = DAO.getInstanceDao();
            req.getSession().setAttribute("user",user);
            if (req.getMethod().equalsIgnoreCase("post")) {
                if (req.getParameter("Update") != null || req.getParameter("Delete") != null) {
//                    int id = Integer.parseInt(req.getParameter("user_id"));
//                    String nickName = req.getParameter("nickName");
                    String email = req.getParameter("email");
                    String password = req.getParameter("password");
//                    String firstName = req.getParameter("firstName");
//                    String lastName = req.getParameter("lastName");
//                    String middleName = req.getParameter("middleName");
//                    String phoneNumber = req.getParameter("phoneNumber");
//                    int base_face_id = Integer.parseInt(req.getParameter("base_face_id"));
                    User userDel = new User(user.getUser_id(), user.getNick_Name(), email, password,user.getFirst_Name() , user.getLast_Name(), user.getMiddle_Name(), user.getPhone_Number(),2);
                    if (req.getParameter("Update") == req.getParameter("Update")) {
                        dao.user.update(userDel);
                        return Action.PROFILE.command;
                    }
                    if (req.getParameter("Delete") == req.getParameter("Delete")) {
                        dao.user.delete(userDel);
                        return Action.INDEX.command;
                    }
                }
            }
            return null;
        }
        return null;
    }
}
