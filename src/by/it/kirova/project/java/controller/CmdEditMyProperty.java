package by.it.kirova.project.java.controller;


import javax.servlet.http.HttpServletRequest;

public class CmdEditMyProperty extends CmdAbstract{

    @Override
    public CmdAbstract execute(HttpServletRequest req) throws Exception {

        return Actions.EDITINFO.command;
    }

}
