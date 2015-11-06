package com.flatstock.controller.users;


import com.flatstock.converter.GenderEnumConverter;
import com.flatstock.converter.RoleEnumConverter;
import com.flatstock.model.Gender;
import com.flatstock.model.Role;
import com.flatstock.model.User;
import com.flatstock.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import static com.flatstock.model.User.*;
import java.io.*;


@Controller
@Scope("request")
public class UsersController {

    public static final String USERS_PATH = "/users";
    public static final String ADD_USER_PATH = "/add_user";

    static Logger LOG = Logger.getLogger(UsersController.class.getName());

    @Autowired
    UserService service;

    @RequestMapping(value=USERS_PATH)
    public ModelAndView showUsers() throws IOException{
        return new ModelAndView(USERS, USERS, service.getAllUsers());
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Gender.class, new GenderEnumConverter());
        dataBinder.registerCustomEditor(Role.class, new RoleEnumConverter());
    }


    @RequestMapping(value = ADD_USER_PATH)
    public String addUser(@ModelAttribute User user){
        service.addUser(user);
        return "redirect:" + USERS_PATH;
    }

}