package by.it.lyukovich.jd_03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CmdIndex implements ActionCmd {

    @Override
    public String execute(HttpServletRequest req) throws Exception {
        return Actions.INDEX.jsp;
    }

}
