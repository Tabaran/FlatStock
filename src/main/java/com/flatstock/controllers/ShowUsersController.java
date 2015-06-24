package com.flatstock.controllers;

import com.flatstock.dao.UserDao;
import com.flatstock.dao.UserDaoImpl;
import com.flatstock.model.IUser;
import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/users")
public class ShowUsersController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao dao = new UserDaoImpl();
        List<IUser> users = dao.getAllUsers();
        request.setAttribute("users", users);
        RequestDispatcher view = request.getRequestDispatcher("users.jsp");
        view.forward(request, response);
    }

}