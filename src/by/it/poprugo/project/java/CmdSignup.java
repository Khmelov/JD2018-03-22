package by.it.poprugo.project.java;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements ActionCmd {
    @Override
    public String execute(HttpServletRequest reg) throws Exception {
        return Actions.SIGNUP.jsp;
    }
}
