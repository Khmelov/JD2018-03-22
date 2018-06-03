package by.it.uskoryaev.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout implements IActionCmd {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.LOGOUT.jsp;
    }
}
