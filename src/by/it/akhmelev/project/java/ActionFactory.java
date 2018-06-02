package by.it.akhmelev.project.java;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    by.it.akhmelev.project.java.ActionCmd defineCmd(HttpServletRequest req) {
        String commandName = req.getParameter("command");
        ActionCmd current = by.it.akhmelev.project.java.Actions.ERROR.command;
        if (commandName != null && !commandName.isEmpty()) {
            try {
                current = by.it.akhmelev.project.java.Actions.valueOf(commandName.toUpperCase()).command;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Command not found");
            }

        }
        return current;
    }
}
