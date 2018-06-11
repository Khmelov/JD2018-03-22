package by.it.lyukovich.jd_03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdLogin implements ActionCmd {

    @Override
    public String execute(HttpServletRequest req) throws Exception {
        return Actions.LOGIN.jsp;
    }

}
