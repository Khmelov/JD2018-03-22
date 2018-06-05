package by.it.kirova.project.java.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    private ActionFactory actionFactory;

    @Override
    public void init() throws ServletException {
        actionFactory = new ActionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CmdAbstract cmd = actionFactory.defineCmd(req);
        String viewPage;
        try {
            cmd.execute(req);
            viewPage = cmd.getJsp();
        } catch (Exception e) {
            viewPage = Actions.ERROR.command.getJsp();
        }
        getServletContext().getRequestDispatcher(viewPage).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CmdAbstract cmd = actionFactory.defineCmd(req);
        String viewPage;
        try {
            CmdAbstract next = cmd.execute(req);
            if (next == null) {
                viewPage = cmd.getJsp();
                getServletContext().getRequestDispatcher(viewPage).forward(req, resp);
            } else {
                resp.sendRedirect("do?command=" + next.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        CmdAbstract cmd = actionFactory.defineCmd(req);
//        String viewPage;
//        try {
//            viewPage = cmd.getJsp();
//        } catch (Exception e) {
//            viewPage = Actions.ERROR.command.getJsp();
//        }
//        ServletContext servletContext = getServletContext();
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(viewPage);
//        requestDispatcher.forward(req, resp);
//
//
//    }
}
