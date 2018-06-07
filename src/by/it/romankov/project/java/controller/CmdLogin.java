package by.it.romankov.project.java.controller;


import by.it.romankov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdLogin extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            DAO dao = DAO.getInstance();
            String where=String.format("WHERE login='%s' AND password='%s'",login,password);
            if (dao.people.getAll(where).size()>0){
                return Actions.INDEX.command;
        }
        }
        return null;
    }
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        String where=String.format("WHERE login='%s' AND password='%s'","testlogin","testPassword");
        if (dao.people.getAll(where).size()==4){
            System.out.println("ok");
        }
    }}