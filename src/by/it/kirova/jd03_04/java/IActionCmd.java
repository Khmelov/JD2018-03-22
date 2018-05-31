package by.it.kirova.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public interface IActionCmd {
    String execute(HttpServletRequest req) throws Exception;

}
