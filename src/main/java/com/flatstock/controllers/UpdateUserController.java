package com.flatstock.controllers;

/**
 * Created by Valentin on 17.06.2015.
 */

import com.flatstock.dao.UserDao;
import com.flatstock.dao.UserDaoImpl;
import com.flatstock.model.Gender;
import com.flatstock.model.IUser;
import com.flatstock.model.User;
import static com.flatstock.model.Names.*;
import static com.flatstock.model.User.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(UPDATE_USER_PATH)
public class UpdateUserController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao dao = new UserDaoImpl();
        IUser user = new User();
        user.setId(Integer.parseInt(request.getParameter(ID)));
        user.setFirstName(request.getParameter(FIRST_NAME));
        user.setLastName(request.getParameter(LAST_NAME));
        user.setLogin(request.getParameter(LOGIN));
        user.setEmail(request.getParameter(EMAIL));
        user.setPassword(request.getParameter(PASSWORD));
        user.setGender(Gender.fromString(request.getParameter(GENDER)));
        dao.updateUser(user);
        response.sendRedirect(USERS_PATH);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao dao = new UserDaoImpl();
        IUser user = dao.getUser(Integer.parseInt(request.getParameter(ID)));
        request.setAttribute(USER, user);
        RequestDispatcher view = request.getRequestDispatcher("updateUser.jsp");
        view.forward(request, response);
    }


}
