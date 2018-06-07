package by.it.romankov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
   public CmdAbstract defineCmd(HttpServletRequest req) {
        String commandName = req.getParameter("command");
       CmdAbstract current = Actions.ERROR.command;
        if (commandName != null && !commandName.isEmpty()) {
            try {
                current = Actions.valueOf(commandName.toUpperCase()).command;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Commant not found");
            }

        }
        return current;
    }
}
