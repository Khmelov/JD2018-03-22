package by.it.desykevich.project.java.controller;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class FrontController  extends HttpServlet{

    private ActionFactory actionFactory;

    @Override
    public void init() throws ServletException {
        actionFactory = new ActionFactory();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String viewPage;
        try {
            CmdAbstract cmd = actionFactory.defineCmd(req);
            CmdAbstract next = cmd.execute(req);
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
        String viewPage;
        try {
            CmdAbstract cmd = actionFactory.defineCmd(req);
            CmdAbstract next = cmd.execute(req);
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

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        process(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        process(req, resp);
//    }
//
//    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ActionFactory actionFactory = new ActionFactory();
//        CmdAbstract command = actionFactory.defineCmd(req);
//        CmdAbstract nextStep = null;
//        ServletContext servletContext = getServletContext();
//        try {
//            nextStep = command.execute(req);
//        } catch (Exception e) {
//            req.setAttribute(Msg.ERROR, "FC:" + e.getMessage());
//            String errorJsp = Actions.ERROR.command.getJsp();
//            RequestDispatcher dispatcher = servletContext.getRequestDispatcher(errorJsp);
//        }
//        if (nextStep == null || nextStep == command) {
//            String viewJsp = command.getJsp();
//            RequestDispatcher dispatcher = servletContext.getRequestDispatcher(viewJsp);
//            dispatcher.forward(req, resp);
//        } else {
//            resp.sendRedirect("do?command=" + nextStep);
//        }
//    }

}
