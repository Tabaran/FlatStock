package com.flatstock.controllers;

import com.flatstock.dao.ApartmentDao;
import com.flatstock.dao.ApartmentDaoImpl;
import com.flatstock.dao.UserDao;
import com.flatstock.dao.UserDaoImpl;
import com.flatstock.model.*;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Created by Valentin on 09.06.2015.
 */

@WebServlet("/add_apartments")
public class AddApartmentsController extends HttpServlet {
    static Logger LOG = Logger.getLogger(AddApartmentsController.class.getName());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentDao dao = new ApartmentDaoImpl();
        IApartment apartment = new Apartment();
        apartment.setAddress(request.getParameter("address"));
        apartment.setFloor(Integer.parseInt(request.getParameter("floor")));
        apartment.setDescription(request.getParameter("desc"));
        apartment.setPrice(Integer.parseInt(request.getParameter("price")));
        apartment.setRoomNumber(Integer.parseInt(request.getParameter("rooms")));
        apartment.setOwnerId(Integer.parseInt(request.getParameter("owner")));
        LOG.info("Trying to add apartments");
        dao.addApartment(apartment);
        response.sendRedirect("/apartments");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao userDao = new UserDaoImpl();
        List<IUser> users = userDao.getAllUsers();
        request.setAttribute("users", users);
        ApartmentDao apartmentDao = new ApartmentDaoImpl();
        List<IApartment> apartments = apartmentDao.getAllApartments();
        request.setAttribute("apartments", apartments);
        RequestDispatcher view = request.getRequestDispatcher("addApartments.jsp");
        view.forward(request, response);
    }
}
