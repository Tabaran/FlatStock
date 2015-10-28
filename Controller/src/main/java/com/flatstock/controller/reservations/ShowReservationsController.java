package com.flatstock.controller.reservations;

import com.flatstock.model.Apartment;
import com.flatstock.model.Reservation;
import com.flatstock.model.User;
import com.flatstock.service.*;
import com.flatstock.service.impl.ApartmentServiceImpl;
import com.flatstock.service.impl.ReservationServiceImpl;
import com.flatstock.service.impl.UserServiceImpl;
import static com.flatstock.controller.reservations.ShowReservationsController.*;
import static com.flatstock.model.Reservation.*;
import static com.flatstock.model.User.*;
import static com.flatstock.model.Apartment.*;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(RESERVATIONS_PATH)
public class ShowReservationsController extends HttpServlet {

    public static final String RESERVATIONS_PATH = "/reservations";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservationService reservationService = new ReservationServiceImpl();
        List<Reservation> reservations = reservationService.getAllReservation();
        request.setAttribute(RESERVATIONS, reservations);
        UserService userService = new UserServiceImpl();
        Map usersMap = new HashMap<Integer, User>();
        for(Reservation reservation : reservations){
            usersMap.put(reservation.getUser().getId(), userService.getUser(reservation.getUser().getId()));
        }
        request.setAttribute(USERS, usersMap);
        ApartmentService apartmentService = new ApartmentServiceImpl();
        Map apartmentsMap = new HashMap<Integer, Apartment>();
        for(Reservation reservation : reservations){
            apartmentsMap.put(reservation.getApartment().getId(), apartmentService.getApartment(reservation.getApartment().getId()));
        }
        request.setAttribute(APARTMENTS, apartmentsMap);
        RequestDispatcher view = request.getRequestDispatcher("reservations.jsp");
        view.forward(request, response);
    }

}
