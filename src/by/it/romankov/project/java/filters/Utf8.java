package by.it.romankov.project.java.filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class Utf8 implements javax.servlet.Filter {


        private String code;

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            code=filterConfig.getInitParameter("code");
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            String encoding = servletRequest.getCharacterEncoding();
            if (encoding==null || !encoding.equalsIgnoreCase(code))
                servletRequest.setCharacterEncoding(code);

            encoding = servletResponse.getCharacterEncoding();
            if (encoding==null || !encoding.equalsIgnoreCase(code))
                servletResponse.setCharacterEncoding(code);
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {

        }
    }

