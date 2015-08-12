package com.flatstock.filter;

import com.flatstock.model.IUser;
import com.flatstock.model.Role;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.flatstock.model.impl.User.USER;

/**
 * Created by Valentin on 12.08.2015.
 */
public class AuthorizationFilter implements Filter {
    private Logger LOG = Logger.getLogger(AuthenticationFilter.class.getName());
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("do filter");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        IUser user = (IUser)session.getAttribute(USER);
        if(user != null){
            if(Role.ADMINISTRATOR.equals(user.getRole()) ||
                    (!req.getRequestURI().contains("update") &&
                     !req.getRequestURI().contains("remove") &&
                     !req.getRequestURI().contains("add")))
            {
                chain.doFilter(request, response);
            }
            else{
                ((HttpServletResponse)response).sendRedirect("/accessError.jsp");
            }
        }
        else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {

    }
}
