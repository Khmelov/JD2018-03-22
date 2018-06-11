package by.it.uskoryaev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class AbstractCmd {
    abstract AbstractCmd execute(HttpServletRequest reg) throws Exception;

    @Override
    public String toString() {
        String name = this.getClass().getSimpleName()
                .replaceFirst("Cmd", "");
        return name;
    }

    public String getJsp(){
        return "/"+this.toString().toLowerCase()+".jsp";
    }
}
