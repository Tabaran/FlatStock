package com.flatstock.controller;

import com.flatstock.service.*;
import com.flatstock.model.IApartment;
import com.flatstock.model.IReservation;
import com.flatstock.model.IUser;
import static com.flatstock.model.Names.*;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(RESERVATIONS_PATH)
public class ShowReservationsController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservationService reservationService = new ReservationServiceImpl();
        List<IReservation> reservations = reservationService.getAllReservation();
        request.setAttribute(RESERVATIONS, reservations);
        UserService userService = new UserServiceImpl();
        Map usersMap = new HashMap<Integer, IUser>();
        for(IReservation reservation : reservations){
            usersMap.put(reservation.getUserId(), userService.getUser(reservation.getUserId()));
        }
        request.setAttribute(USERS, usersMap);
        ApartmentService apartmentService = new ApartmentServiceImpl();
        Map apartmentsMap = new HashMap<Integer, IApartment>();
        for(IReservation reservation : reservations){
            apartmentsMap.put(reservation.getApartmentId(), apartmentService.getApartment(reservation.getApartmentId()));
        }
        request.setAttribute(APARTMENTS, apartmentsMap);
        RequestDispatcher view = request.getRequestDispatcher("reservations.jsp");
        view.forward(request, response);
    }

}
