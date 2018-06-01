package by.it.kirova.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdError implements IActionCmd {

    @Override
    public String execute(HttpServletRequest req) throws Exception {
        return Actions.ERROR.jsp;
    }

}
