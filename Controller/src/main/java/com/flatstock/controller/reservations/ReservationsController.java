package com.flatstock.controller.reservations;

import com.flatstock.model.Reservation;
import com.flatstock.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import static com.flatstock.model.Reservation.*;
import static com.flatstock.model.Apartment.*;
import static com.flatstock.model.User.*;
import java.io.*;
import javax.servlet.http.*;

@Controller
@Scope("request")
public class ReservationsController extends HttpServlet {

    public static final String RESERVATIONS_PATH = "/reservations";
    public static final String ADD_RESERVATION_PATH = "/add_reservation";
    public static final String REMOVE_RESERVATION_PATH = "/remove_reservation";
    public static final String UPDATE_RESERVATION_PATH = "/update_reservation";
    public static final String ADD_RESERVATION = "addReservation";

    @Autowired
    ReservationService reservationService;

    @Autowired
    UserService userService;

    @Autowired
    ApartmentService apartmentService;

    @RequestMapping(value=RESERVATIONS_PATH)
    public ModelAndView showReservations() throws IOException {
        return new ModelAndView(RESERVATIONS, RESERVATIONS, reservationService.getAllReservation());
    }

    @RequestMapping(value = ADD_RESERVATION_PATH, method = RequestMethod.GET)
    public ModelAndView showAddReservationForm(){
        ModelAndView model = new ModelAndView(ADD_RESERVATION);
        model.addObject(USERS, userService.getAllUsers());
        model.addObject(APARTMENTS, apartmentService.getAllApartments());
        return model;
    }

    @RequestMapping(value = ADD_RESERVATION_PATH, method = RequestMethod.POST)
    public String addReservation(@ModelAttribute Reservation reservation){
        reservationService.addReservation(reservation);
        return "redirect:" + RESERVATIONS_PATH;
    }



}
