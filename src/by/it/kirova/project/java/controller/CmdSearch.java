package by.it.kirova.project.java.controller;


import javax.servlet.http.HttpServletRequest;

public class CmdSearch extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        String str = CmdIndex.searchResult.toString();
        req.setAttribute("str", str);
        return null;

    }
}
