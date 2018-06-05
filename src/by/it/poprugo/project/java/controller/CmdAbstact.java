package by.it.poprugo.project.java.controller;

import javax.servlet.http.HttpServletRequest;

// было public interface ActionCmd {
//  String execute(HttpServletRequest reg) throws Exception;
public abstract class CmdAbstact {
    abstract CmdAbstact execute(HttpServletRequest reg) throws Exception;

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName().replace("Cmd", "");

        return name;
    }

    public String getJsp() {
        return "/" + this.toString().toLowerCase() + ".jsp";
    }
}
