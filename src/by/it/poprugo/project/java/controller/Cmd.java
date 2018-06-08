package by.it.poprugo.project.java.controller;

import javax.servlet.http.HttpServletRequest;

public abstract class Cmd {
    abstract Cmd execute(HttpServletRequest req) throws Exception;

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                .replaceFirst("Cmd", "");
    }

    public String getJsp(){
        return "/"+this.toString().toLowerCase()+".jsp";
    }
}
