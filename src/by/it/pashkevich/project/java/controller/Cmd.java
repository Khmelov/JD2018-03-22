package by.it.pashkevich.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Cmd {
    abstract Cmd execute(HttpServletRequest req, HttpServletResponse resp) throws Exception;

    @Override
    public String toString() {
        return this.getClass().getSimpleName()
                .replaceFirst("Cmd", "");
    }

    public String getJsp() {
        return "/" + this.toString().toLowerCase() + ".jsp";
    }
}
