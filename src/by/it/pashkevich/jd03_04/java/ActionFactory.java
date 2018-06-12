package by.it.pashkevich.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    IActionCmd defineCmd(HttpServletRequest req) {
        String commandName = req.getParameter("command");
        IActionCmd current = Actions.ERROR.command;
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

