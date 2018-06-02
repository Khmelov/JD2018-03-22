package by.it.uskoryaev.project.java.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

//    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ActionFactory actionFactory = new ActionFactory();
//        AbstractCmd cmd = actionFactory.defineCmd(req);
//        String viewPage;
//        try {
//            viewPage = cmd.getJsp();
//        } catch (Exception e) {
//            viewPage = Action.ERROR.command.getJsp();
//        }
//        ServletContext servletContext = getServletContext();
//        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(viewPage);
//        requestDispatcher.forward(req, resp);
//    }
}

