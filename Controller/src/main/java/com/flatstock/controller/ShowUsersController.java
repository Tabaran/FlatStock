package com.flatstock.controller;

import com.flatstock.service.UserService;
import com.flatstock.service.UserServiceImpl;
import com.flatstock.model.IUser;
import org.apache.log4j.Logger;
import static com.flatstock.model.Names.*;
import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(USERS_PATH)
public class ShowUsersController extends HttpServlet {
    static Logger LOG = Logger.getLogger(ShowUsersController.class.getName());

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        List<IUser> users = service.getAllUsers();
        request.setAttribute(USERS, users);
        RequestDispatcher view = request.getRequestDispatcher("users.jsp");
        view.forward(request, response);
        LOG.info(users.size() + " users loaded.");
    }

}