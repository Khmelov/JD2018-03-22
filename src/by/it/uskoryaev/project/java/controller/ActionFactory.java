package by.it.uskoryaev.project.java.controller;


import javax.servlet.http.HttpServletRequest;

<<<<<<< HEAD
class ActionFactory {
=======
public class ActionFactory {
>>>>>>> origin/master
    AbstractCmd defineCmd(HttpServletRequest req) {
        String commandName = req.getParameter("command");
        AbstractCmd current = Action.ERROR.command;
        if (commandName != null && !commandName.isEmpty()) {
            try {
                current = Action.valueOf(commandName.toUpperCase()).command;

            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("command not found");
            }
        }
        return current;
    }
}
