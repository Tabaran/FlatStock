package com.flatstock.controllers;

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
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Created by Valentin on 09.06.2015.
 */

@WebServlet("/add_reservation")
public class AddReservationController extends HttpServlet {
    static Logger LOG = Logger.getLogger(AddReservationController.class.getName());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservationDao dao = new ReservationDaoImpl();
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            IReservation reservation = new Reservation();
            reservation.setApartmentId(Integer.parseInt(request.getParameter("apartment")));
            reservation.setUserId(Integer.parseInt(request.getParameter("owner")));
            reservation.setStartTime(format.parse(request.getParameter("start")));
            reservation.setEndTime(format.parse(request.getParameter("end")));
            dao.addReservation(reservation);
            response.sendRedirect("/reservations");
        }
        catch (ParseException e){
            LOG.error(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl();
        List<IUser> users = userDao.getAllUsers();
        request.setAttribute("users", users);
        ApartmentDao apartmentDao = new ApartmentDaoImpl();
        List<IApartment> apartments = apartmentDao.getAllApartments();
        request.setAttribute("apartments", apartments);
        RequestDispatcher view = request.getRequestDispatcher("addReservation.jsp");
        view.forward(request, response);
    }

}
