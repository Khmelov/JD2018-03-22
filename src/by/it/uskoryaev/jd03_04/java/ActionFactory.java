package by.it.uskoryaev.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    IActionCmd defineCmd(HttpServletRequest req){
        String commandName = req.getParameter("command");
        IActionCmd current = Action.ERROR.command;
        if (commandName != null && !commandName.isEmpty()){
            try {
                current = Action.valueOf(commandName.toUpperCase()).command;

            }catch (IllegalArgumentException e){
                throw new IllegalArgumentException("command not found");
            }
        }
        return current;
    }
}
