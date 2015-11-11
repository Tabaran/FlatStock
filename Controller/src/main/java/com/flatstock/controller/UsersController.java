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

    public static final String USERS_PATH = "/users";
    public static final String ADD_USER_PATH = "/add_user";
    public static final String REMOVE_USER_PATH = "/remove_user";
    public static final String UPDATE_USER_PATH = "/update_user";
    public static final String UPDATE_USER = "updateUser";

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
        return new ModelAndView(USERS, USERS, service.getAllUsers());
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
        ModelAndView model = new ModelAndView(UPDATE_USER);
        model.addObject(USER, service.getUser(Integer.parseInt(id)));
        return model;
    }

    @RequestMapping(value = UPDATE_USER_PATH, method = RequestMethod.POST)
    public String updateUser(@ModelAttribute User user){
        service.updateUser(user);
        return "redirect:" + USERS_PATH;
    }


}