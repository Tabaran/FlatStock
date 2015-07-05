package com.flatstock.controllers;

import com.flatstock.dao.*;
import com.flatstock.model.IApartment;
import com.flatstock.model.IReservation;
import com.flatstock.model.IUser;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/reservations")
public class ShowReservationsController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservationDao reservationDao = new ReservationDaoImpl();
        List<IReservation> reservations = reservationDao.getAllReservation();
        request.setAttribute("reservations", reservations);
        UserDao userDao = new UserDaoImpl();
        Map usersMap = new HashMap<Integer, IUser>();
        for(IReservation reservation : reservations){
            usersMap.put(reservation.getUserId(), userDao.getUser(reservation.getUserId()));
        }
        request.setAttribute("usersMap", usersMap);
        ApartmentDao apartmentDao = new ApartmentDaoImpl();
        Map apartmentsMap = new HashMap<Integer, IApartment>();
        for(IReservation reservation : reservations){
            apartmentsMap.put(reservation.getApartmentId(), apartmentDao.getApartment(reservation.getApartmentId()));
        }
        request.setAttribute("apartmentsMap", apartmentsMap);
        RequestDispatcher view = request.getRequestDispatcher("reservations.jsp");
        view.forward(request, response);
    }

}
