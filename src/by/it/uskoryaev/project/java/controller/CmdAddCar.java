package by.it.uskoryaev.project.java.controller;

import javax.servlet.http.HttpServletRequest;

class CmdAddCar extends AbstractCmd{

    @Override
    AbstractCmd execute(HttpServletRequest reg) throws Exception {
        if (reg.getMethod().equalsIgnoreCase("post")){

        }
        return null;
    }
}
