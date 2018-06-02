package by.it.akhmelev.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdIndex implements ActionCmd {
    @Override
    public String execute(HttpServletRequest reg) throws Exception {
        return by.it.akhmelev.project.java.Actions.INDEX.jsp;
    }
}
