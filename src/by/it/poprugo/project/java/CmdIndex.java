package by.it.poprugo.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdIndex implements ActionCmd {
    @Override
    public String execute(HttpServletRequest reg) throws Exception {
        return Actions.INDEX.jsp;
    }
}
