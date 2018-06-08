package by.it.kirova.project.java.controller;


import by.it.kirova.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class CmdSearch extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        ArrayList<ArrayList> searchResult = CmdIndex.searchResult;
        req.setAttribute("searchResult", searchResult);
        if (req.getParameter("booking") != null) {
            User user = Util.getUserFromSession(req);
            if (user == null) {
                return Actions.LOGIN.command;
            }



        }
        return null;

    }
}
