package by.it.sgolovach.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public interface ActionComand {

    String execute(HttpServletRequest req) throws Exception;

}
