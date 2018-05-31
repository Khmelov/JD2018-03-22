package by.it.verishko.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public interface ActionCmd {
    String execute (HttpServletRequest req) throws Exception;
}
