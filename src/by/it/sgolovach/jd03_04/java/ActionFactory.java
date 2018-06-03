package by.it.sgolovach.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    ActionComand defineCmd(HttpServletRequest req){
        String commandName = req.getParameter("command");
        ActionComand current=Action.ERROR.comand;
        if(commandName!=null && !commandName.isEmpty()){
            try {
                current = Action.valueOf(commandName.toUpperCase()).comand;
            } catch (IllegalArgumentException e){
                throw  new IllegalArgumentException("Command not found");
            }
        }
        return current;
    }

}
