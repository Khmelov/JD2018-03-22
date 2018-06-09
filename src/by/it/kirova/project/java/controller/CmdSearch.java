package by.it.kirova.project.java.controller;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class CmdSearch extends Cmd {

    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        ArrayList<ArrayList> searchResult = CmdIndex.searchResult;
        req.setAttribute("searchResult", searchResult);
        return null;

    }
}
