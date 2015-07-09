package com.flatstock.controllers;

import com.flatstock.dao.UserDao;
import com.flatstock.dao.UserDaoImpl;
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
        UserDao dao = new UserDaoImpl();
        List<IUser> users = dao.getAllUsers();
        request.setAttribute(USERS, users);
        RequestDispatcher view = request.getRequestDispatcher("users.jsp");
        view.forward(request, response);
        LOG.info(users.size() + " users loaded.");
    }

}