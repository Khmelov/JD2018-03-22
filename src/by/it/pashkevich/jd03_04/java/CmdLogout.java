package by.it.pashkevich.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout implements IActionCmd
{
    @Override
    public String execute(HttpServletRequest req) throws Exception {
        return Actions.LOGOUT.jsp;
    }
}
