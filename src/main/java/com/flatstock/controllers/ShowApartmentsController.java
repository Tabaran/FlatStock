package com.flatstock.controllers;

import com.flatstock.dao.ApartmentDao;
import com.flatstock.dao.ApartmentDaoImpl;
import com.flatstock.dao.UserDao;
import com.flatstock.dao.UserDaoImpl;
import com.flatstock.model.IApartment;
import com.flatstock.model.IUser;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import static com.flatstock.model.Names.*;


@WebServlet(APARTMENTS_PATH)
public class ShowApartmentsController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ApartmentDao apartmentDao = new ApartmentDaoImpl();
        List<IApartment> apartments = apartmentDao.getAllApartments();
        request.setAttribute(APARTMENTS, apartments);
        UserDao userDao = new UserDaoImpl();
        Map usersMap = new HashMap<Integer, IUser>();
        for(IApartment apartment : apartments){
            usersMap.put(apartment.getOwnerId(), userDao.getUser(apartment.getOwnerId()));
        }
        request.setAttribute(USERS, usersMap);
        RequestDispatcher view = request.getRequestDispatcher("apartments.jsp");
        view.forward(request, response);
    }

}
