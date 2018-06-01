package by.it.danilevich.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    ActionCmd defineCmd(HttpServletRequest req) throws InterruptedException {
        String commandName = req.getParameter("command");
        ActionCmd current = Actions.ERROR.command;
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
