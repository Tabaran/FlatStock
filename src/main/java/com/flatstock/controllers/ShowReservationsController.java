package com.flatstock.controllers;

import com.flatstock.dao.*;
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
        ReservationDao reservationDao = new ReservationDaoImpl();
        List<IReservation> reservations = reservationDao.getAllReservation();
        request.setAttribute(RESERVATIONS, reservations);
        UserDao userDao = new UserDaoImpl();
        Map usersMap = new HashMap<Integer, IUser>();
        for(IReservation reservation : reservations){
            usersMap.put(reservation.getUserId(), userDao.getUser(reservation.getUserId()));
        }
        request.setAttribute(USERS, usersMap);
        ApartmentDao apartmentDao = new ApartmentDaoImpl();
        Map apartmentsMap = new HashMap<Integer, IApartment>();
        for(IReservation reservation : reservations){
            apartmentsMap.put(reservation.getApartmentId(), apartmentDao.getApartment(reservation.getApartmentId()));
        }
        request.setAttribute(APARTMENTS, apartmentsMap);
        RequestDispatcher view = request.getRequestDispatcher("reservations.jsp");
        view.forward(request, response);
    }

}
