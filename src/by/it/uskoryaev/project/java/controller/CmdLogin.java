package by.it.uskoryaev.project.java.controller;

import by.it.uskoryaev.project.java.beans.User;
import by.it.uskoryaev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdLogin extends AbstractCmd {
    @Override
    public AbstractCmd execute(HttpServletRequest reg) throws Exception {
        if (reg.getMethod().equalsIgnoreCase("post")) {
            String email = reg.getParameter("email");
            String password = reg.getParameter("password");

            DAO dao = DAO.getInstanceDao();
            String where = String.format("WHERE email='%s' AND password='%s' LIMIT 0,1", email, password);


            List<User> ff = dao.user.getAll("");
            if (ff != null && ff.size()>0){
                User user = ff.get(0);
                reg.getSession().setAttribute("user",user);
                /* ЕСЛИ ЗДЕСЬ УСТАНОВИТЬ RETURN НА PROFILE ВОЗНИКАЮТ ПРОБЛЕМЫ:
                1.для того чтобы удалить или обновить пользователя нужно залогиниться.
                2.логинимся и браузер выдает ошибку о множественной переодресации.
                3.как ее исправить? я не вижу множественной переодресации при попытке удаления или обновления.
                 */
            }else {
                return Action.SIGNUP.command;
            }
        }
        return null;
    }
}

