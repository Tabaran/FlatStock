package com.flatstock.filter;

import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static com.flatstock.model.impl.User.*;
import static com.flatstock.controller.LoginController.*;


/**
 * Created by Valentin on 05.08.2015.
 */
public class AuthenticationFilter implements Filter {
    private Logger LOG = Logger.getLogger(AuthenticationFilter.class.getName());


    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        LOG.info(req.getRequestURI() + "  **************** Do filter ***************");
        HttpSession session = req.getSession();
        if(session.getAttribute(USER) == null && !LOGIN_PATH.equals(req.getRequestURI())
                && !ERROR_PAGE.equals(req.getRequestURI())){
            RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        } else {
            chain.doFilter(request, response);
        }

    }

    public void destroy() {

    }
}
