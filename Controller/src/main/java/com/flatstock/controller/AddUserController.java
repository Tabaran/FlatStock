package com.flatstock.controller;

import com.flatstock.service.UserService;
import com.flatstock.service.impl.UserServiceImpl;
import com.flatstock.model.Gender;
import com.flatstock.model.IUser;
import com.flatstock.model.impl.User;
import static com.flatstock.model.impl.User.*;
import static com.flatstock.controller.ShowUsersController.*;
import static com.flatstock.controller.AddUserController.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;


/**
 * Created by Valentin on 09.06.2015.
 */

@WebServlet(ADD_USER_PATH)
public class AddUserController extends HttpServlet {

    public static final String ADD_USER_PATH = "/add_user";

    static Logger LOG = Logger.getLogger(AddUserController.class.getName());
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService service = new UserServiceImpl();
        IUser user = new User();
        user.setFirstName(request.getParameter(FIRST_NAME));
        user.setLastName(request.getParameter(LAST_NAME));
        user.setLogin(request.getParameter(LOGIN));
        user.setEmail(request.getParameter(EMAIL));
        user.setPassword(request.getParameter(PASSWORD));
        user.setGender(Gender.fromString(request.getParameter(GENDER)));
        LOG.info("Adding user");
        service.addUser(user);
        response.sendRedirect(USERS_PATH);
    }
}
