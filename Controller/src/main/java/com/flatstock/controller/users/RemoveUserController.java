package com.flatstock.controller.users;

import com.flatstock.service.UserService;
import com.flatstock.service.impl.UserServiceImpl;

import static com.flatstock.controller.users.UsersController.*;
import static com.flatstock.model.Id.*;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Valentin on 15.06.2015.
 */
//@WebServlet(REMOVE_USER_PATH)
public class RemoveUserController extends HttpServlet{

    public static final String REMOVE_USER_PATH = "/remove_user";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        service.deleteUser(Integer.parseInt(request.getParameter(ID)));
        response.sendRedirect(USERS_PATH);
    }
}
