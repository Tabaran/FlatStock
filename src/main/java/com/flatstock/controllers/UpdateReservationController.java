package com.flatstock.controllers;

/**
 * Created by Valentin on 17.06.2015.
 */

import com.flatstock.dao.*;
import com.flatstock.model.*;
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



@WebServlet("/update_reservation")
public class UpdateReservationController extends HttpServlet {
    static Logger LOG = Logger.getLogger(UpdateReservationController.class.getName());
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            ReservationDao dao = new ReservationDaoImpl();
            IReservation reservation = new Reservation();
            reservation.setId(Integer.parseInt(request.getParameter("id")));
            reservation.setUserId(Integer.parseInt(request.getParameter("user")));
            reservation.setApartmentId(Integer.parseInt(request.getParameter("apartment")));
            reservation.setStartTime(format.parse(request.getParameter("start")));
            reservation.setEndTime(format.parse(request.getParameter("end")));
            dao.updateReservation(reservation);
            response.sendRedirect("/reservations");
        }
        catch (ParseException e){
            LOG.error(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservationDao dao = new ReservationDaoImpl();
        IReservation reservation = dao.getReservation(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("reservation", reservation);
        RequestDispatcher view = request.getRequestDispatcher("updateReservation.jsp");
        view.forward(request, response);
    }


}
