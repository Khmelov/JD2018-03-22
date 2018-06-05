package by.it.verishko.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    CmdAbstract defineCmd(HttpServletRequest req) {
        String commandName = req.getParameter("command");
        CmdAbstract current = Actions.ERROR.command;
        if (commandName != null && !commandName.isEmpty()) {
            try {
                current = Actions.valueOf(commandName.toUpperCase()).command;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Command not found");
            }
        }
        return current;
    }
}

