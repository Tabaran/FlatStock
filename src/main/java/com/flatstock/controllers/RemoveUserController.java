package com.flatstock.controllers;

import com.flatstock.dao.UserDao;
import com.flatstock.dao.UserDaoImpl;
import static com.flatstock.model.Names.*;
import static com.flatstock.model.Id.*;
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
@WebServlet(REMOVE_USER_PATH)
public class RemoveUserController extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao dao = new UserDaoImpl();
        dao.deleteUser(Integer.parseInt(request.getParameter(ID)));
        RequestDispatcher view = request.getRequestDispatcher(USERS_PATH);
        view.forward(request, response);
    }
}
