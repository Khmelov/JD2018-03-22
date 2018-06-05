package by.it.kirova.project.java.controller;


import javax.servlet.http.HttpServletRequest;

public class CmdSearch extends CmdAbstract{

    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {
        return Actions.SEARCH.command;
    }

}
