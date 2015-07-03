package com.flatstock.controllers;

import com.flatstock.dao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Valentin on 15.06.2015.
 */
@WebServlet("/remove_reservation")
public class RemoveReservationController extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservationDao dao = new ReservationDaoImpl();
        dao.deleteReservation(Integer.parseInt(request.getParameter("id")));
        RequestDispatcher view = request.getRequestDispatcher("/reservations");
        view.forward(request, response);
    }
}