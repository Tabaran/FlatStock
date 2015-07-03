package com.flatstock.controllers;

/**
 * Created by Valentin on 17.06.2015.
 */

import com.flatstock.dao.ApartmentDao;
import com.flatstock.dao.ApartmentDaoImpl;
import com.flatstock.dao.UserDao;
import com.flatstock.dao.UserDaoImpl;
import com.flatstock.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/update_apartments")
public class UpdateApartmentsController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentDao dao = new ApartmentDaoImpl();
        IApartment apartment = new Apartment();
        apartment.setId(Integer.parseInt(request.getParameter("id")));
        apartment.setOwnerId(Integer.parseInt(request.getParameter("owner")));
        apartment.setAddress(request.getParameter("address"));
        apartment.setRoomNumber(Integer.parseInt(request.getParameter("rooms")));
        apartment.setPrice(Integer.parseInt(request.getParameter("price")));
        apartment.setFloor(Integer.parseInt(request.getParameter("floor")));
        apartment.setDescription(request.getParameter("desc"));
        dao.updateApartment(apartment);
        response.sendRedirect("/apartments");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentDao dao = new ApartmentDaoImpl();
        IApartment apartment = dao.getApartment(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("apartment", apartment);
        RequestDispatcher view = request.getRequestDispatcher("updateApartments.jsp");
        view.forward(request, response);
    }


}
