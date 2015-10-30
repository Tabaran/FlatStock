package com.flatstock.controller.apartments;

import com.flatstock.service.ApartmentService;
import com.flatstock.service.impl.ApartmentServiceImpl;
import static com.flatstock.controller.apartments.RemoveApartmentsController.*;
import static com.flatstock.controller.apartments.ShowApartmentsController.*;
import static com.flatstock.model.Id.*;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by Valentin on 15.06.2015.
 */
//@WebServlet(REMOVE_APARTMENTS_PATH)
public class RemoveApartmentsController extends HttpServlet{

    public static final String REMOVE_APARTMENTS_PATH = "/remove_apartments";

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentService service = new ApartmentServiceImpl();
        service.deleteApartment(Integer.parseInt(request.getParameter(ID)));
        response.sendRedirect(APARTMENTS_PATH);
    }
}