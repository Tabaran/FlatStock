package com.flatstock.controller.apartments;

import com.flatstock.model.Apartment;
import com.flatstock.model.User;
import com.flatstock.service.ApartmentService;
import com.flatstock.service.impl.ApartmentServiceImpl;
import com.flatstock.service.UserService;
import com.flatstock.service.impl.UserServiceImpl;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import static com.flatstock.controller.apartments.ShowApartmentsController.*;
import static com.flatstock.model.Apartment.*;
import static com.flatstock.model.User.*;


@WebServlet(APARTMENTS_PATH)
public class ShowApartmentsController extends HttpServlet {

    public static final String APARTMENTS_PATH = "/apartments";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentService apartmentService = new ApartmentServiceImpl();
        List<Apartment> apartments = apartmentService.getAllApartments();
        request.setAttribute(APARTMENTS, apartments);
        RequestDispatcher view = request.getRequestDispatcher("apartments.jsp");
        view.forward(request, response);
    }

}
