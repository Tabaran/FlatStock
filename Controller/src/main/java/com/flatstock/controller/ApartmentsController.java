package com.flatstock.controller;


import com.flatstock.converter.UserConverter;
import com.flatstock.model.Apartment;
import com.flatstock.model.User;
import com.flatstock.service.ApartmentService;
import com.flatstock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.io.*;
import static com.flatstock.model.Apartment.*;
import static com.flatstock.model.User.USERS;

@Controller
@Scope("request")
public class ApartmentsController {
    public static final String ADMIN_PATH = "admin/";
    public static final String APARTMENTS_PATH = "/admin/apartments";
    public static final String ADD_APARTMENTS_PATH = "/admin/add_apartments";
    public static final String ADD_APARTMENTS = "/admin/addApartments";
    public static final String UPDATE_APARTMENTS = "/admin/updateApartments";
    public static final String REMOVE_APARTMENTS_PATH = "/admin/remove_apartments";
    public static final String UPDATE_APARTMENTS_PATH = "/admin/update_apartments";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(User.class, new UserConverter(userService));
    }

    @Autowired
    UserService userService;

    @Autowired
    ApartmentService apartmentService;

    @RequestMapping(value=APARTMENTS_PATH)
    public ModelAndView showApartments() throws IOException {
        return new ModelAndView(ADMIN_PATH + APARTMENTS, APARTMENTS, apartmentService.getAllApartments());
    }

    @RequestMapping(value = ADD_APARTMENTS_PATH, method = RequestMethod.GET)
    public ModelAndView showAddApartmentsForm(){
        ModelAndView model = new ModelAndView(ADD_APARTMENTS);
        model.addObject(USERS, userService.getAllUsers());
        return model;
    }

    @RequestMapping(value = ADD_APARTMENTS_PATH, method = RequestMethod.POST)
    public String addApartment(@ModelAttribute Apartment apartment){
        apartmentService.addApartment(apartment);
        return "redirect:" + APARTMENTS_PATH;
    }

    @RequestMapping(value = REMOVE_APARTMENTS_PATH)
    public String removeApartment(@RequestParam(ID) String id){
        apartmentService.deleteApartment(Integer.parseInt(id));
        return "redirect:" + APARTMENTS_PATH;
    }

    @RequestMapping(value = UPDATE_APARTMENTS_PATH, method = RequestMethod.GET)
    public ModelAndView showUpdateApartmentsForm(@RequestParam(ID) String id){
        ModelAndView model = new ModelAndView(UPDATE_APARTMENTS);
        model.addObject(APARTMENTS, apartmentService.getApartment(Integer.parseInt(id)));
        model.addObject(USERS, userService.getAllUsers());
        return model;
    }

    @RequestMapping(value = UPDATE_APARTMENTS_PATH, method = RequestMethod.POST)
    public String updateApartment(@ModelAttribute Apartment apartment){
        apartmentService.updateApartment(apartment);
        return "redirect:" + APARTMENTS_PATH;
    }

}
