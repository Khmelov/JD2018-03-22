package by.it.desykevich.project.java.controller;


import javax.servlet.http.HttpServletRequest;

public class CmdError extends CmdAbstract {
    @Override
    public CmdAbstract execute(HttpServletRequest reg) {

        return Actions.ERROR.command;
    }
}
