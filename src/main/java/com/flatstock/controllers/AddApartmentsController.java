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
import java.io.IOException;
import java.util.List;
import static com.flatstock.model.Apartment.*;
import static com.flatstock.model.Names.*;


/**
 * Created by Valentin on 09.06.2015.
 */

@WebServlet(ADD_APARTMENTS_PATH)
public class AddApartmentsController extends HttpServlet {
    static Logger LOG = Logger.getLogger(AddApartmentsController.class.getName());

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentDao dao = new ApartmentDaoImpl();
        IApartment apartment = new Apartment();
        apartment.setAddress(request.getParameter(ADDRESS));
        apartment.setFloor(Integer.parseInt(request.getParameter(FLOOR)));
        apartment.setDescription(request.getParameter(DESCRIPTION));
        apartment.setPrice(Integer.parseInt(request.getParameter(PRICE)));
        apartment.setRoomNumber(Integer.parseInt(request.getParameter(ROOM_NUMBER)));
        apartment.setOwnerId(Integer.parseInt(request.getParameter(OWNER_ID)));
        LOG.info("Adding apartments");
        dao.addApartment(apartment);
        response.sendRedirect(APARTMENTS_PATH);
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
