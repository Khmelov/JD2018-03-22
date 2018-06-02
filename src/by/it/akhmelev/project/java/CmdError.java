package by.it.akhmelev.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdError implements ActionCmd {
    @Override
    public String execute(HttpServletRequest reg) throws Exception {
        return by.it.akhmelev.project.java.Actions.ERROR.jsp;
    }
}
