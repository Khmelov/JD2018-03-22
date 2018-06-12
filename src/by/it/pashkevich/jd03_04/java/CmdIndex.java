package by.it.pashkevich.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdIndex implements IActionCmd
{
    @Override
    public String execute(HttpServletRequest req) throws Exception {
        return Actions.INDEX.jsp;
    }
}
