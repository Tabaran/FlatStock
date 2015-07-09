package com.flatstock.controllers;

/**
 * Created by Valentin on 17.06.2015.
 */

import com.flatstock.dao.ApartmentDao;
import com.flatstock.dao.ApartmentDaoImpl;
import com.flatstock.dao.UserDao;
import com.flatstock.dao.UserDaoImpl;
import com.flatstock.model.*;
import static com.flatstock.model.Names.*;
import static com.flatstock.model.Apartment.*;
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

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentDao dao = new ApartmentDaoImpl();
        IApartment apartment = new Apartment();
        apartment.setId(Integer.parseInt(request.getParameter(ID)));
        apartment.setOwnerId(Integer.parseInt(request.getParameter(OWNER_ID)));
        apartment.setAddress(request.getParameter(ADDRESS));
        apartment.setRoomNumber(Integer.parseInt(request.getParameter(ROOM_NUMBER)));
        apartment.setPrice(Integer.parseInt(request.getParameter(PRICE)));
        apartment.setFloor(Integer.parseInt(request.getParameter(FLOOR)));
        apartment.setDescription(request.getParameter(DESCRIPTION));
        dao.updateApartment(apartment);
        response.sendRedirect(APARTMENTS_PATH);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentDao apartmentDao = new ApartmentDaoImpl();
        IApartment apartment = apartmentDao.getApartment(Integer.parseInt(request.getParameter(ID)));
        request.setAttribute(APARTMENTS, apartment);
        UserDao userDao = new UserDaoImpl();
        List<IUser> users = userDao.getAllUsers();
        request.setAttribute(USERS, users);
        RequestDispatcher view = request.getRequestDispatcher("updateApartments.jsp");
        view.forward(request, response);
    }


}
