package by.it.kirova.project.java.controller;


import javax.servlet.http.HttpServletRequest;

public class CmdIndex extends CmdAbstract {

    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            if (req.getParameter("search") != null) {
                return Actions.SEARCH.command;
            }
        }
        return null;
    }

}
