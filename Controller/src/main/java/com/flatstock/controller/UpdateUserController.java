package com.flatstock.controller;

/**
 * Created by Valentin on 17.06.2015.
 */

import com.flatstock.service.UserService;
import com.flatstock.service.impl.UserServiceImpl;
import com.flatstock.model.Gender;
import com.flatstock.model.IUser;
import com.flatstock.model.impl.User;
import static com.flatstock.model.impl.User.*;
import static com.flatstock.controller.UpdateUserController.*;
import static com.flatstock.controller.ShowUsersController.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(UPDATE_USER_PATH)
public class UpdateUserController extends HttpServlet {

    public static final String UPDATE_USER_PATH = "/update_user";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        IUser user = new User();
        user.setId(Integer.parseInt(request.getParameter(ID)));
        user.setFirstName(request.getParameter(FIRST_NAME));
        user.setLastName(request.getParameter(LAST_NAME));
        user.setLogin(request.getParameter(LOGIN));
        user.setEmail(request.getParameter(EMAIL));
        user.setPassword(request.getParameter(PASSWORD));
        user.setGender(Gender.fromString(request.getParameter(GENDER)));
        service.updateUser(user);
        response.sendRedirect(USERS_PATH);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        IUser user = service.getUser(Integer.parseInt(request.getParameter(ID)));
        request.setAttribute(USER, user);
        RequestDispatcher view = request.getRequestDispatcher("updateUser.jsp");
        view.forward(request, response);
    }


}
