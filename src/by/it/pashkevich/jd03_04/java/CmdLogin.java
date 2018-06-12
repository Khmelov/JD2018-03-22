package by.it.pashkevich.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogin implements IActionCmd
{
    @Override
    public String execute(HttpServletRequest req) throws Exception {
        return Actions.LOGIN.jsp;
    }
}
