package com.flatstock.controller.reservations;

/**
 * Created by Valentin on 17.06.2015.
 */

import com.flatstock.model.Apartment;
import com.flatstock.model.Reservation;
import com.flatstock.model.User;
import com.flatstock.service.*;
import com.flatstock.service.impl.ApartmentServiceImpl;
import com.flatstock.service.impl.ReservationServiceImpl;
import com.flatstock.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import static com.flatstock.controller.reservations.UpdateReservationController.*;
import static com.flatstock.model.Reservation.*;
import static com.flatstock.model.User.*;
import static com.flatstock.model.Apartment.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


//@WebServlet(UPDATE_RESERVATION_PATH)
public class UpdateReservationController extends HttpServlet {

    public static final String UPDATE_RESERVATION_PATH = "/update_reservation";

    static Logger LOG = Logger.getLogger(UpdateReservationController.class.getName());
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            ReservationService service = new ReservationServiceImpl();
            Reservation reservation = new Reservation();
            reservation.setId(Integer.parseInt(request.getParameter(ID)));
            //reservation.setUser(request.getParameter(OWNER));
            //reservation.setApartment(Integer.parseInt(request.getParameter(APARTMENT_ID)));
            reservation.setStartTime(format.parse(request.getParameter(START_TIME)));
            reservation.setEndTime(format.parse(request.getParameter(END_TIME)));
            service.updateReservation(reservation);
            response.sendRedirect(RESERVATIONS);
        }
        catch (ParseException e){
            LOG.error(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservationService reservationService = new ReservationServiceImpl();
        Reservation reservation = reservationService.getReservation(Integer.parseInt(request.getParameter("id")));
        request.setAttribute(RESERVATIONS, reservation);
        UserService userService = new UserServiceImpl();
        List<User> users = userService.getAllUsers();
        request.setAttribute(USERS, users);
        ApartmentService apartmentService = new ApartmentServiceImpl();
        List<Apartment> apartments = apartmentService.getAllApartments();
        request.setAttribute(APARTMENTS, apartments);
        RequestDispatcher view = request.getRequestDispatcher("updateReservation.jsp");
        view.forward(request, response);
    }


}
