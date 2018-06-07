package by.it.sgolovach.project.java.pattern;

import by.it.sgolovach.project.java.beans.User;
import by.it.sgolovach.project.java.dao.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckLog {
    public static boolean checkLogin(String login) throws SQLException {
        boolean answer = false;
        DAO dao = DAO.getInstance();
        List<User> all = dao.user.getAll("");
        for (User user : all) {
            if (user.getLogin().equals(login))
                answer = true;
        }
        return answer;
    }
}
