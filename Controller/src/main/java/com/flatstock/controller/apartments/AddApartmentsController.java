package com.flatstock.controller.apartments;


import com.flatstock.converter.GenderEnumConverter;
import com.flatstock.converter.RoleEnumConverter;
import com.flatstock.converter.UserConverter;
import com.flatstock.model.Apartment;
import com.flatstock.model.Gender;
import com.flatstock.model.Role;
import com.flatstock.model.User;
import com.flatstock.service.ApartmentService;
import com.flatstock.service.impl.ApartmentServiceImpl;
import com.flatstock.service.UserService;
import com.flatstock.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import static com.flatstock.model.Apartment.*;
import static com.flatstock.model.User.*;
import static com.flatstock.controller.apartments.ShowApartmentsController.*;


/**
 * Created by Valentin on 09.06.2015.
 */
@Controller
@Scope("request")
public class AddApartmentsController extends HttpServlet {

    public static final String ADD_APARTMENTS_PATH = "/add_apartments";
    public static final String ADD_APARTMENTS = "addApartments";

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(User.class, new UserConverter(userService));
    }

    @Autowired
    UserService userService;

    @Autowired
    ApartmentService apartmentService;

    static Logger LOG = Logger.getLogger(AddApartmentsController.class.getName());


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

/*
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentService service = new ApartmentServiceImpl();
        UserService userService = new UserServiceImpl();
        Apartment apartment = new Apartment();
        apartment.setAddress(request.getParameter(ADDRESS));
        apartment.setFloor(Integer.parseInt(request.getParameter(FLOOR)));
        apartment.setDescription(request.getParameter(DESCRIPTION));
        apartment.setPrice(Integer.parseInt(request.getParameter(PRICE)));
        apartment.setRoomNumber(Integer.parseInt(request.getParameter(ROOM_NUMBER)));
        apartment.setOwner(userService.getUser(Integer.parseInt(request.getParameter(OWNER))));
        LOG.info("Adding apartments");
        service.addApartment(apartment);
        response.sendRedirect(APARTMENTS_PATH);
    }
    */
}
