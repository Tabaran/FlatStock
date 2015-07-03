package com.flatstock.controllers;

import com.flatstock.dao.UserDao;
import com.flatstock.dao.UserDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Valentin on 15.06.2015.
 */
@WebServlet("/remove_user")
public class RemoveUserController extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao dao = new UserDaoImpl();
        dao.deleteUser(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher view = request.getRequestDispatcher("/users");
        view.forward(request, response);
    }
}
