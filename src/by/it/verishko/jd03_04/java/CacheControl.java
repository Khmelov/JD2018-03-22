package by.it.verishko.jd03_04.java;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.util.Date;

public class CacheControl implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        resp.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
//        resp.setHeader("Pragma", "no-cache");
//        resp.setDateHeader("Expires", 0);
//        resp.setDateHeader("Last-Modified", new Date().getTime());
//        filterChain.doFilter(servletRequest, servletResponse);
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate, max-age=0");
        resp.setHeader("Pragma", "no-cache");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}
