package com.flatstock.filter;

import com.flatstock.model.IUser;
import com.flatstock.model.Role;
import com.flatstock.service.AccessService;
import com.flatstock.service.impl.AccessServiceImpl;
import org.apache.log4j.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

import static com.flatstock.model.impl.User.*;
import static com.flatstock.controller.LoginController.*;


/**
 * Created by Valentin on 05.08.2015.
 */
public class AccessFilter implements Filter {
    private static final String LOGIN_JSP = "/login.jsp";
    private Logger LOG = Logger.getLogger(AccessFilter.class.getName());
    private AccessService accessService;

    public void init(FilterConfig filterConfig) throws ServletException {
        accessService = new AccessServiceImpl();
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        LOG.info(req.getRequestURI() + "  **************** Do filter ***************");
        HttpSession session = req.getSession();
        IUser user = (IUser) session.getAttribute(USER);
        if (LOGIN_PATH.equals(req.getRequestURI()) || ERROR_PAGE.equals(req.getRequestURI()) ||
                LOGIN_JSP.equals(req.getRequestURI())) {
            chain.doFilter(request, response);
        } else {
            if (user == null) {
                ((HttpServletResponse) response).sendRedirect(LOGIN_JSP);
            } else {
                Set<Role> accessList = accessService.getAccessMap().get(req.getRequestURI());
                if (accessList != null && accessList.contains(user.getRole())) {
                    chain.doFilter(request, response);
                } else {
                    RequestDispatcher rd = req.getRequestDispatcher("/accessError.jsp");
                    rd.forward(request, response);
                }
            }
        }

    }

    public void destroy() {

    }
}
