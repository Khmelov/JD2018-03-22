package by.it.danilevich.project.java.controller;

import by.it.danilevich.project.java.dao.connect.CN;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class FrontController extends HttpServlet {

    private ActionFactory actionFactory;

    @Override
    public void init() throws ServletException {
        actionFactory = new ActionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Cmd cmd = actionFactory.defineCmd(req);
        String viewPage;
        try {
            Cmd next = cmd.execute(req);
            if (next == null) {
                viewPage = cmd.getJsp();
                getServletContext().getRequestDispatcher(viewPage).forward(req, resp);
            } else {
                resp.sendRedirect("do?command="+next.toString());
            }
        } catch (Exception e) {
            req.setAttribute("err",e.getMessage());
            String log = Arrays.toString(e.getStackTrace()).replaceAll(",","<br>");
            req.setAttribute("log",log);
            getServletContext().getRequestDispatcher(Actions.ERROR.command.getJsp()).forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Cmd cmd = actionFactory.defineCmd(req);
        String viewPage;
        try {
            Cmd next = cmd.execute(req);
            if (next == null) {
                viewPage = cmd.getJsp();
                getServletContext().getRequestDispatcher(viewPage).forward(req, resp);
            } else {
                resp.sendRedirect("do?command="+next.toString());
            }
        } catch (Exception e) {
            req.setAttribute("err",e.getMessage());
            String log = Arrays.toString(e.getStackTrace()).replaceAll(",","<br>");
            req.setAttribute("log",log);
            getServletContext().getRequestDispatcher(Actions.ERROR.command.getJsp()).forward(req, resp);
        }
    }

}
