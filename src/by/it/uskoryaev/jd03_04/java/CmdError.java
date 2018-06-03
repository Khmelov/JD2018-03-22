package by.it.uskoryaev.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdError implements IActionCmd {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.ERROR.jsp;
    }
}
