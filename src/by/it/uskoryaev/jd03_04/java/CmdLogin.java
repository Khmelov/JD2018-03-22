package by.it.uskoryaev.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogin implements IActionCmd{
    @Override
    public String execute(HttpServletRequest request) {
        return Action.LOGIN.jsp;
    }
}
