package com.flatstock.controller;


import com.flatstock.model.*;
import com.flatstock.model.impl.Apartment;
import com.flatstock.service.ApartmentService;
import com.flatstock.service.impl.ApartmentServiceImpl;
import com.flatstock.service.UserService;
import com.flatstock.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import static com.flatstock.model.impl.Apartment.*;
import static com.flatstock.controller.AddApartmentsController.*;
import static com.flatstock.controller.ShowApartmentsController.*;


/**
 * Created by Valentin on 09.06.2015.
 */

@WebServlet(ADD_APARTMENTS_PATH)
public class AddApartmentsController extends HttpServlet {

    public static final String ADD_APARTMENTS_PATH = "/add_apartments";

    static Logger LOG = Logger.getLogger(AddApartmentsController.class.getName());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentService service = new ApartmentServiceImpl();
        IApartment apartment = new Apartment();
        apartment.setAddress(request.getParameter(ADDRESS));
        apartment.setFloor(Integer.parseInt(request.getParameter(FLOOR)));
        apartment.setDescription(request.getParameter(DESCRIPTION));
        apartment.setPrice(Integer.parseInt(request.getParameter(PRICE)));
        apartment.setRoomNumber(Integer.parseInt(request.getParameter(ROOM_NUMBER)));
        apartment.setOwnerId(Integer.parseInt(request.getParameter(OWNER_ID)));
        LOG.info("Adding apartments");
        service.addApartment(apartment);
        response.sendRedirect(APARTMENTS_PATH);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<IUser> users = userService.getAllUsers();
        request.setAttribute("users", users);
        ApartmentService apartmentService = new ApartmentServiceImpl();
        List<IApartment> apartments = apartmentService.getAllApartments();
        request.setAttribute("apartments", apartments);
        RequestDispatcher view = request.getRequestDispatcher("addApartments.jsp");
        view.forward(request, response);
    }
}
