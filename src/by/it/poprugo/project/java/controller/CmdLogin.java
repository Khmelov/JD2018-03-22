package by.it.poprugo.project.java.controller;
//
//import by.it.poprugo.project.java.beans.User;
//import by.it.poprugo.project.java.dao.DAO;
//
//import javax.servlet.http.HttpServletRequest;
//
//public class CmdLogin extends CmdAbstact {
//    @Override
//    public CmdAbstact execute(HttpServletRequest reg) throws Exception {
//        if (reg.getMethod().equalsIgnoreCase("post")) {
//            String login = reg.getParameter("login");
//            String password = reg.getParameter("password");
//            User user = new User(0, login, password, "", 2);
//            DAO dao = DAO.getInstance();
//            String where = String.format("WHERE login='%s' AND password='%s'", login,password);
//            //dao.user.getAll(where);
//            return null;//Actions.INDEX.command;
//        }
//        return null;
//    }
//}
