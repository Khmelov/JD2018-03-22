package by.it.kirova.project.java.controller;


import javax.servlet.http.HttpServletRequest;

public class CmdIndex extends Cmd {


    @Override
    public Cmd execute(HttpServletRequest req) throws Exception {
        if (req.getMethod().equalsIgnoreCase("post")) {
            if (req.getParameter("search") != null) {
                String destination = req.getParameter("destination");
                String checkindate = req.getParameter("checkindate");
                String checkoutdate = req.getParameter("checkoutdate");
                String peopleamount = req.getParameter("peopleamount");
                Long checkin = DateConverter.dateToMil(checkindate);
                Long checkout = DateConverter.dateToMil(checkoutdate);
                if (Parser.validator(destination, "city") ||
                        Parser.validator(checkindate, "date") ||
                        Parser.validator(checkoutdate, "date") ||
                        Parser.validator(peopleamount, "peopleamount") ||
                        checkin > checkout) {
                    return Actions.INDEX.command;
                }
                req.getSession().setAttribute("destination", destination);
                req.getSession().setAttribute("checkin", checkin);
                req.getSession().setAttribute("checkout", checkout);
                req.getSession().setAttribute("peopleamount", peopleamount);
                return Actions.SEARCH.command;
            }

        }
        return null;

    }
}

