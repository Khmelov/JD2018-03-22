package by.it.sgolovach.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {

    CmdAbstract defineCmd(HttpServletRequest req){
        String commandName = req.getParameter("command");
        CmdAbstract current= Action.INDEX.comand;
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
