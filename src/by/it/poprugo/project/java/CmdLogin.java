package by.it.poprugo.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogin implements ActionCmd {
    @Override
    public String execute(HttpServletRequest reg) throws Exception {
        return Actions.LOGIN.jsp;
    }
}
