package by.it.romankov.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdError implements ActionCmd {
    @Override
    public String execute(HttpServletRequest reg) throws Exception {
        return Actions.ERROR.jsp;
    }
}
