package com.flatstock.controller;

/**
 * Created by Valentin on 17.06.2015.
 */

import com.flatstock.model.impl.Apartment;
import com.flatstock.service.ApartmentService;
import com.flatstock.service.impl.ApartmentServiceImpl;
import com.flatstock.service.UserService;
import com.flatstock.service.impl.UserServiceImpl;
import com.flatstock.model.*;
import static com.flatstock.model.impl.Apartment.*;
import static com.flatstock.model.impl.User.*;
import static com.flatstock.controller.UpdateApartmentsController.*;
import static com.flatstock.controller.ShowApartmentsController.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(UPDATE_APARTMENTS_PATH)
public class UpdateApartmentsController extends HttpServlet {

    public static final String UPDATE_APARTMENTS_PATH = "/update_apartments";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentService service = new ApartmentServiceImpl();
        IApartment apartment = new Apartment();
        apartment.setId(Integer.parseInt(request.getParameter(ID)));
        apartment.setOwnerId(Integer.parseInt(request.getParameter(OWNER_ID)));
        apartment.setAddress(request.getParameter(ADDRESS));
        apartment.setRoomNumber(Integer.parseInt(request.getParameter(ROOM_NUMBER)));
        apartment.setPrice(Integer.parseInt(request.getParameter(PRICE)));
        apartment.setFloor(Integer.parseInt(request.getParameter(FLOOR)));
        apartment.setDescription(request.getParameter(DESCRIPTION));
        service.updateApartment(apartment);
        response.sendRedirect(APARTMENTS_PATH);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentService apartmentService = new ApartmentServiceImpl();
        IApartment apartment = apartmentService.getApartment(Integer.parseInt(request.getParameter(ID)));
        request.setAttribute(APARTMENTS, apartment);
        UserService userService = new UserServiceImpl();
        List<IUser> users = userService.getAllUsers();
        request.setAttribute(USERS, users);
        RequestDispatcher view = request.getRequestDispatcher("updateApartments.jsp");
        view.forward(request, response);
    }

}