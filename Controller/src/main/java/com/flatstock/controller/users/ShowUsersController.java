package com.flatstock.controller.users;


import com.flatstock.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import static com.flatstock.model.User.*;
import java.io.*;


@Controller
@Scope("request")
public class ShowUsersController {

    public static final String USERS_PATH = "/users";

    static Logger LOG = Logger.getLogger(ShowUsersController.class.getName());

    @Autowired
    UserService service;

    @RequestMapping(value=USERS_PATH)
    public ModelAndView showUsers() throws IOException{
        return new ModelAndView(USERS, USERS, service.getAllUsers());
    }

}