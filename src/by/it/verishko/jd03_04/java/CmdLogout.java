package by.it.verishko.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogout implements ActionCmd {
    @Override
    public String execute(HttpServletRequest req) throws Exception {
        return Actions.LOGOUT.jsp;
    }
}
