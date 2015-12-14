package com.flatstock.controller;


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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import static com.flatstock.model.User.*;
import java.io.*;


@Controller
@Scope("request")
public class UsersController {

    public static final String ADMIN_PATH = "admin/";
    public static final String USERS_PATH = "/admin/users";
    public static final String ADD_USER_PATH = "/admin/add_user";
    public static final String REMOVE_USER_PATH = "/admin/remove_user";
    public static final String UPDATE_USER_PATH = "/admin/update_user";
    public static final String UPDATE_USER = "updateUser";
    public static final String SIGN_UP_PATH = "/sign_up";

    static Logger LOG = Logger.getLogger(UsersController.class.getName());

    @Autowired
    UserService service;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Gender.class, new GenderEnumConverter());
        dataBinder.registerCustomEditor(Role.class, new RoleEnumConverter());
    }

    @RequestMapping(value=USERS_PATH)
    public ModelAndView showUsers() throws IOException{
        return new ModelAndView( ADMIN_PATH + USERS, USERS, service.getAllUsers());
    }

    @RequestMapping(value = ADD_USER_PATH)
    public String addUser(@ModelAttribute User user){
        service.addUser(user);
        return "redirect:" + USERS_PATH;
    }

    @RequestMapping(value = REMOVE_USER_PATH)
    public String removeUser(@RequestParam(ID) String id){
        service.deleteUser(Integer.parseInt(id));
        return "redirect:" + USERS_PATH;
    }

    @RequestMapping(value = UPDATE_USER_PATH, method = RequestMethod.GET)
    public ModelAndView showUpdateUserForm(@RequestParam(ID) String id){
        ModelAndView model = new ModelAndView(ADMIN_PATH + UPDATE_USER);
        model.addObject(USER, service.getUser(Integer.parseInt(id)));
        return model;
    }

    @RequestMapping(value = UPDATE_USER_PATH, method = RequestMethod.POST)
    public String updateUser(@ModelAttribute User user){
        service.updateUser(user);
        return "redirect:" + USERS_PATH;
    }

    @RequestMapping(value = SIGN_UP_PATH, method = RequestMethod.POST)
    public String signUp(@ModelAttribute User user){
        service.addUser(user);
        return "redirect:" + "home.jsp";
    }
}