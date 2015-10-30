package com.flatstock.controller.users;

import com.flatstock.model.User;
import com.flatstock.repository.ApartmentsRepository;
import com.flatstock.service.UserService;
import com.flatstock.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import static com.flatstock.model.User.*;
import static com.flatstock.controller.users.ShowUsersController.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.servlet.*;

import javax.servlet.http.*;

//@WebServlet(USERS_PATH)
@Controller
@Scope("request")
public class ShowUsersController extends HttpServlet {

    public static final String USERS_PATH = "/users";

    static Logger LOG = Logger.getLogger(ShowUsersController.class.getName());


    User user;

    @Autowired
    public void setUser(User user){
        this.user = user;
    }

   /* public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        /*UserService service = new UserServiceImpl();
        List<User> users = service.getAllUsers();
        request.setAttribute(USERS, users);
        RequestDispatcher view = request.getRequestDispatcher("users.jsp");
        view.forward(request, response);
        LOG.info(users.size() + " users loaded.");*/

       /* List<User> users = new ArrayList<>();
        users.add(user);
        request.setAttribute(USERS, users);
        RequestDispatcher view = request.getRequestDispatcher("users.jsp");
        view.forward(request, response);
    }*/

    @RequestMapping(value=USERS_PATH)
    public ModelAndView test(HttpServletResponse response) throws IOException{
        List<User> users = new ArrayList<>();
        users.add(user);
        return new ModelAndView("users", USERS, users);
    }

}