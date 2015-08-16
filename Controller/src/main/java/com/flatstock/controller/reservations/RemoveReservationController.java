package com.flatstock.controller.reservations;

import com.flatstock.service.*;
import com.flatstock.service.impl.ReservationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static com.flatstock.controller.reservations.RemoveReservationController.*;
import static com.flatstock.controller.reservations.ShowReservationsController.*;
import static com.flatstock.model.Id.*;


/**
 * Created by Valentin on 15.06.2015.
 */
@WebServlet(REMOVE_RESERVATION_PATH)
public class RemoveReservationController extends HttpServlet{

    public static final String REMOVE_RESERVATION_PATH = "/remove_reservation";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ReservationService service = new ReservationServiceImpl();
        service.deleteReservation(Integer.parseInt(request.getParameter(ID)));
        response.sendRedirect(RESERVATIONS_PATH);
    }
}