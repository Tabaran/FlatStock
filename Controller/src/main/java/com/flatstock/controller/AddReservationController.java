package com.flatstock.controller;

import com.flatstock.model.impl.Reservation;
import com.flatstock.service.*;
import com.flatstock.model.*;
import com.flatstock.service.impl.ApartmentServiceImpl;
import com.flatstock.service.impl.ReservationServiceImpl;
import com.flatstock.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import static com.flatstock.model.impl.Reservation.*;
import static com.flatstock.model.impl.Apartment.*;
import static com.flatstock.model.impl.User.*;
import static com.flatstock.controller.AddReservationController.*;


/**
 * Created by Valentin on 09.06.2015.
 */

@WebServlet(ADD_RESERVATION_PATH)
public class AddReservationController extends HttpServlet {

    public static final String ADD_RESERVATION_PATH = "/add_reservation";

    static Logger LOG = Logger.getLogger(AddReservationController.class.getName());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservationService service = new ReservationServiceImpl();
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            IReservation reservation = new Reservation();
            reservation.setApartmentId(Integer.parseInt(request.getParameter(APARTMENTS)));
            reservation.setUserId(Integer.parseInt(request.getParameter(USER_ID)));
            reservation.setStartTime(format.parse(request.getParameter(START_TIME)));
            reservation.setEndTime(format.parse(request.getParameter(END_TIME)));
            service.addReservation(reservation);
            response.sendRedirect(RESERVATIONS);
        }
        catch (ParseException e){
            LOG.error(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<IUser> users = userService.getAllUsers();
        request.setAttribute(USERS, users);
        ApartmentService apartmentService = new ApartmentServiceImpl();
        List<IApartment> apartments = apartmentService.getAllApartments();
        request.setAttribute(APARTMENTS, apartments);
        RequestDispatcher view = request.getRequestDispatcher("addReservation.jsp");
        view.forward(request, response);
    }

}
