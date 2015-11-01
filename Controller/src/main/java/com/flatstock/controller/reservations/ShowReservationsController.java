package com.flatstock.controller.reservations;

import com.flatstock.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import static com.flatstock.model.Reservation.*;
import java.io.*;
import javax.servlet.http.*;

@Controller
@Scope("request")
public class ShowReservationsController extends HttpServlet {

    public static final String RESERVATIONS_PATH = "/reservations";

    @Autowired
    ReservationService reservationService;

    @RequestMapping(value=RESERVATIONS_PATH)
    public ModelAndView showReservations() throws IOException {
        return new ModelAndView(RESERVATIONS, RESERVATIONS, reservationService.getAllReservation());
    }

}
