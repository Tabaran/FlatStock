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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import static com.flatstock.model.Names.*;
import static com.flatstock.model.Reservation.*;


/**
 * Created by Valentin on 09.06.2015.
 */

@WebServlet(ADD_RESERVATION_PATH)
public class AddReservationController extends HttpServlet {
    static Logger LOG = Logger.getLogger(AddReservationController.class.getName());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservationDao dao = new ReservationDaoImpl();
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            IReservation reservation = new Reservation();
            reservation.setApartmentId(Integer.parseInt(request.getParameter(APARTMENTS)));
            reservation.setUserId(Integer.parseInt(request.getParameter(USER_ID)));
            reservation.setStartTime(format.parse(request.getParameter(START_TIME)));
            reservation.setEndTime(format.parse(request.getParameter(END_TIME)));
            dao.addReservation(reservation);
            response.sendRedirect(RESERVATIONS);
        }
        catch (ParseException e){
            LOG.error(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl();
        List<IUser> users = userDao.getAllUsers();
        request.setAttribute(USERS, users);
        ApartmentDao apartmentDao = new ApartmentDaoImpl();
        List<IApartment> apartments = apartmentDao.getAllApartments();
        request.setAttribute(APARTMENTS, apartments);
        RequestDispatcher view = request.getRequestDispatcher("addReservation.jsp");
        view.forward(request, response);
    }

}
