package com.flatstock.controllers;

import com.flatstock.dao.ApartmentDao;
import com.flatstock.dao.ApartmentDaoImpl;
import com.flatstock.dao.ReservationDao;
import com.flatstock.dao.ReservationDaoImpl;
import com.flatstock.model.IApartment;
import com.flatstock.model.IReservation;

import java.io.*;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/reservations")
public class ShowReservationsController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservationDao dao = new ReservationDaoImpl();
        List<IReservation> reservations = dao.getAllReservation();
        request.setAttribute("reservations", reservations);
        RequestDispatcher view = request.getRequestDispatcher("reservations.jsp");
        view.forward(request, response);
    }

}
