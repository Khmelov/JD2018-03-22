package by.it.verishko.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdSignup implements IActionCmd {
    @Override
    public String execute(HttpServletRequest req) throws Exception {
        return Actions.SIGNUP.jsp;
    }
}
