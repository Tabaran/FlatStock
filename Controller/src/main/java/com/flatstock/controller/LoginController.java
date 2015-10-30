package com.flatstock.controller;

import com.flatstock.model.User;
import com.flatstock.service.UserService;
import com.flatstock.service.exceptions.IncorrectLoginExceptions;
import com.flatstock.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.flatstock.controller.LoginController.*;
import static com.flatstock.model.User.*;

/**
 * Created by Valentin on 08.08.2015.
 */

//@WebServlet(LOGIN_PATH)
public class LoginController extends HttpServlet {
    private Logger LOG = Logger.getLogger(LoginController.class.getName());
    public static final String LOGIN_PATH = "/login";
    public static final String ERROR_PAGE = "/loginError.jsp";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.info("Trying to login");
        UserService service = new UserServiceImpl();
        try {
            User user = service.validateUser(request.getParameter(LOGIN), request.getParameter(PASSWORD));
            service.getPhoto(user.getId());
            request.getSession().setAttribute(USER, user);
            switch (user.getRole()){
                case CUSTOMER: response.sendRedirect("/profile.jsp");
                    break;
                default: response.sendRedirect("/index.jsp");
            }

        } catch (IncorrectLoginExceptions incorrectLoginExceptions) {
            response.sendRedirect(ERROR_PAGE);
        }

    }
}
