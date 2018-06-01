package by.it.desykevich.jd03_04.java;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController  extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        process(req,resp);

    }

    private void process(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        ActionFactory actionFactory = new ActionFactory();
        ActionCmd cmd = actionFactory.defineCmd(req);
        String viewPage;
        try{
            viewPage=cmd.execute(req);
        }catch (Exception e){
            viewPage=Actions.ERROR.jsp;
        }
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(viewPage);
        requestDispatcher.forward(req, resp);

    }
}
