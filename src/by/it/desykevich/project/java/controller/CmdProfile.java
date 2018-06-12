package by.it.desykevich.project.java.controller;


import by.it.desykevich.project.java.beans.Ad;
import by.it.desykevich.project.java.beans.User;
import by.it.desykevich.project.java.dao.DAO;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdProfile extends CmdAbstract {

//    @Override
//    public CmdAbstract execute(HttpServletRequest req) throws Exception {
//        User user = Util.getUserFromSession(req);
//        if (user != null) {
//            if (req.getMethod().equalsIgnoreCase("post")) {
//                if (req.getParameter("UpdateProfile") != null){
//                    user.setPassword(req.getParameter("password"));
//                    user.setLogin(req.getParameter("login"));
//                    DAO dao = DAO.getInstanse();
//                    dao.userDAO.update(user);
//                    return null;
//                }
//                if (req.getParameter("logout") != null)
//                    req.getSession().invalidate();
//                return Actions.LOGIN.command;
//            }
//            else {
//                DAO dao = DAO.getInstanse();
//                int countAd = dao.adDAO.getAll("").size();
//                int stepAd = 5;
//                String startIndex = req.getParameter("startIndex");
//                if (startIndex == null) startIndex = "0";
//                req.setAttribute("countAd", countAd);
//                req.setAttribute("stepAd", stepAd);
//                String where = String.format("WHERE users_id=%d LIMIT %s, %d", user.getID(), startIndex, stepAd);
//                List<Ad> listAdsUser = dao.adDAO.getAll(where );
//                req.getSession().setAttribute("ads",listAdsUser);
//            }
//            return null;
//        }
//        return Actions.LOGIN.command;
//    }

    @Override
    CmdAbstract execute(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession();
        Object o = session.getAttribute("user");
        User user;
        if (o != null) {
            user = (User) o;
        } else
            return Actions.LOGIN.command;

        if (req.getMethod().equalsIgnoreCase("post")) {

            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            String nickname = req.getParameter("nickname");
            String phoneNumber = req.getParameter("phonenumber");
            user.setLogin(login);
            user.setPassword(password);
            user.setEmail(email);
            user.setNickname(nickname);
            user.setPhoneNumber(phoneNumber);
            DAO.getInstanse().userDAO.update(user);
                if (req.getParameter("logout") != null)
                    req.getSession().invalidate();
                return Actions.PROFILE.command;
         }return null;


    }
}
